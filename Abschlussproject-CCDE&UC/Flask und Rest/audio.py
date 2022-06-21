# import pygame
#from unicodedata import decimal
from pygame import mixer
from flask import request

from flask_restful import Resource

#volume = 1

#print(isinstance(volume, float))

mixer.init()
#mixer.music.load("ChildrenOfTheOmnissiah.mp3")
mixer.music.load("Everything Black.mp3")#https://github.com/pygame/pygame/issues/2785
#mixer.music.set_volume(0.5)
#mixer.music.play()
def isFloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

while True:
    query = input("INPUT: ");
    if(query == "stop"):
        mixer.music.stop()
        break
    elif(query == "play"):
        mixer.music.play()
    elif(query == "pause"):
        mixer.music.pause()
    elif(query == "unpause"):
        mixer.music.unpause()
    elif(isFloat(query)):
        mixer.music.set_volume(float(query))
        print("volume changed")
    else:
        print("sei ned deppat, dua gscheid")




    
    
    