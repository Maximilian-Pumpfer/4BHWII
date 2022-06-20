import paho.mqtt.client as paho
import time

def on_publish(client, userdata, mid):
    print("mid: " + mid)
 
def on_subscribe(client, userdata, mid, granted_qos):
    print("Subscribed: "+str(mid)+" "+str(granted_qos))

def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.qos)+" " + str(msg), flush=True)
    
def on_log(client,userdata,level,buff):
    print(buff)    

client = paho.Client()
client.on_publish = on_publish
client.on_subscribe = on_subscribe
client.on_message = on_message
client.on_log = on_log
client.connect("cbe265c6cda342daa94ba67720ef1767.s2.eu.hivemq.cloud", 8883)
client.subscribe("encyclopedia/temperature", qos=1)

while True:
    if client.is_connected:
        (rc, mid) = client.publish("encyclopedia/temperature", "temp", qos=1)
        time.sleep(1)