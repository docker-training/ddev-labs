import requests
import logging
from time import sleep

def get_hash(num_tries):

    n = 0
    while True:
        r = requests.get('http://hasher:8000/hash')
        if r.status_code == 200:
            logging.warning("Got hash=%s", r.text)
            n = 0
        else:
            if n == num_tries:
                logging.error("Call failed after %d retries", num_tries)
                n = 0
            else:
                logging.warn("request failed; re-trying %d", n)
                sleep((2**n)*1)
                n+=1

if __name__ == "__main__":
    logging.info(">>> Starting worker")
    get_hash(5)
    logging.info("<<< Ending worker")
    