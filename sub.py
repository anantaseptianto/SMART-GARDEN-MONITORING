import redis
import time
import traceback

def RedisCheck():
    try:
        r = redis.StrictRedis(host='localhost', port=6379)                    
        p = r.pubsub()                                                        
        p.subscribe('startScripts')                                                 

        while True:                                                               
            message = p.get_message()                                              
            if message:
                command = message['data']                                       
		print(command)
                if command == b'START':                                             
                    PAUSE = False                                                   
            time.sleep(0.5)
        print("Permission to start...")

    except Exception as e:
        print("!!!!!!!!!! EXCEPTION !!!!!!!!!")
        print(str(e))
        print(traceback.format_exc())

if __name__ == '__main__':
	RedisCheck()
