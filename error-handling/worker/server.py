import requests
import logging

def get_hash(call_num, num_tries):
    logging.info("Starting call %d", call_num)
    for n in range(num_tries):
        r = requests.get('http://hasher:8000/hash')
        if r.status_code == 200:
            logging.info("Got hash=%s", r.text)
            return r.text
        else:
            logging.warn("request failed; re-trying %d", n)
    logging.error("Call %d failed after %d retries", call_num, num_tries)

if __name__ == "__main__":
    logging.info(">>> Starting worker")
    for n in range(10):
        get_hash(n, 5)
    logging.info("<<< Ending worker")