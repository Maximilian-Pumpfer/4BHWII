#
# Copyright 2021 HiveMQ GmbH
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
import time
from urllib.parse import urlparse
import paho.mqtt.client as paho
from paho import mqtt

# setting callbacks for different events to see if it works, print the message etc.
def on_connect(client, userdata, flags, rc, properties=None):
    print("CONNACK received with code %s." % rc)
    client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-getSongs", qos=1)
    

# # with this callback you can see if your publish was successful
# def on_publish(client, userdata, mid, properties=None):
#     print("mid: " + str(mid))

# # print which topic was subscribed to
# def on_subscribe(client, userdata, mid, granted_qos, properties=None):
#     print("Subscribed: " + str(mid) + " " + str(granted_qos))

# print message, useful for checking if it was successful
allSongs = []

def on_message(client, userdata, msg):
    received = msg.payload.decode("utf-8").split("-");
    if(received[0] != "main"):
        print(received[0] + ": " + received[1])
        received[1].replace("[", "")
        received[1].replace("]", "")        
        received[1].replace("'", "")
        allSongs = received[1].split(",")
        for s in allSongs:
            print(s)
# def on_log(client,userdata,level,buff):
#     print(buff)  

# using MQTT version 5 here, for 3.1.1: MQTTv311, 3.1: MQTTv31
# userdata is user defined data of any type, updated by user_data_set()
# client_id is the given name of the client
client = paho.Client(client_id="test", userdata=None, protocol=paho.MQTTv5)
client.on_connect = on_connect

# enable TLS for secure connection
client.tls_set(tls_version=mqtt.client.ssl.PROTOCOL_TLS)
# set username and password
client.username_pw_set("project", "wasd1234")
# connect to HiveMQ Cloud on port 8883 (default for MQTT)
client.connect("cbe265c6cda342daa94ba67720ef1767.s2.eu.hivemq.cloud", 8883)

# setting callbacks, use separate functions like above for better visibility
# client.on_subscribe = on_subscribe
client.on_message = on_message
# client.on_publish = on_publish
# client.on_log = on_log

# subscribe to all topics of encyclopedia by using the wildcard "#"
client.subscribe("pro/music", qos=1)
# a single publish, this can also be done in loops, etc.
client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-play-Everything_Black.mp3", qos=1)

def isFloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

while True:
    i = input("Input: ")
    if(i == "stop"):
        client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-stop", qos=1)
        break
    elif(i == "play"):
        client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-" + i, qos=1)
    elif(i == "pause"):
        client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-pause", qos=1)
    elif(i == "unpause"):
        client.publish("pro/music", payload=client._client_id.decode("utf-8") + "-unpause", qos=1)
    elif(isFloat(i)):
        client.publish("pro/music", payload=client._client_id.decode("utf-8") + i, qos=1)
        print("volume changed")
    else:
        print("sei ned deppat, dua gscheid")
    

# loop_forever for simplicity, here you need to stop the loop manually
# you can also use loop_start and loop_stop
client.loop_forever()