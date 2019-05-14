#!/bin/bash

echoerr() { if [[ $QUIET -ne 1 ]]; then echo "$@" 1>&2; fi }

wait_for()
{
    if [[ $TIMEOUT -gt 0 ]]; then
        echoerr "$cmdname: waiting $TIMEOUT seconds for $HOST:$PORT"
    else
        echoerr "$cmdname: waiting for $HOST:$PORT without a timeout"
    fi
    start_ts=$(date +%s)
    while :
    do
        echo "Probing  $HOST:$PORT..."
        nc -z -w 1 $HOST $PORT </dev/null
        result=$?
        end_ts=$(date +%s)
        delta_ts=$((end_ts-start_ts))
        if [[ $result -eq 0 ]]; then
            echoerr "$cmdname: $HOST:$PORT is available after $((end_ts - start_ts)) seconds"
            break
        fi
        echo "Passed $delta_ts of $TIMEOUT seconds"
        if [[ $delta_ts -ge $TIMEOUT ]]; then
            echo "Timeout reached, aborting..."
            break
        fi
        sleep 1
    done
    return $result
}

TIMEOUT=${TIMEOUT:-15}
QUIET=${QUIET:-0}

if [[ "$HOST" == "" || "$PORT" == "" ]]; then
    echoerr "Error: you need to provide a HOST and PORT to test."
    exit 1
fi

cmdname="entrypoint.sh"
wait_for
RESULT=$?
if [[ $RESULT -ne 0 ]]; then
    exit $RESULT
fi

echo "Starting API..."
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar