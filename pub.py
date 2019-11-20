import redis
import time
import traceback
import random
import string
 
def WorkCheck():
    try:
	def randomStringDigits(stringLength=64):
	    Digits = string.digits
	    return ''.join(random.choice(Digits) for i in range(stringLength))
        r = redis.StrictRedis(host='localhost', port=6379)                
        p = r.pubsub()                                                   
 	while True: 
		kirim = randomStringDigits(5)
		print("Starting main scripts...")
		r.publish('startScripts', kirim) 
		print("Done")

    except Exception as e:
        print("!!!!!!!!!! EXCEPTION !!!!!!!!!")
        print(str(e))
        print(traceback.format_exc())

if __name__ == '__main__':
	WorkCheck()
