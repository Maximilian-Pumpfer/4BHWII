import json
from flask_restful import Api
from requests import request
#from model import Question, getRandomQuestion, getData, Service, AllQuests, getQuests
from rest import MusicInfo, Service, getMusicInfo
from flask import Flask, render_template, session
from pygame import mixer



app = Flask(__name__)
app.secret_key = "epjsmp2021/22"
api = Api(app)

@app.route('/')
def start():
    return render_template("startseite.html")

@app.route('/songs')
def showSongs():
    return render_template("songs.html", songs = getMusicInfo())

@app.route('/play')
@app.route('/play/<name>')
def play(name):
    print(name)
    mixer.init()
    mixer.music.load(name)
    mixer.music.play()
    return render_template("play.html")

@app.route('/stop')
def stop():
    
    mixer.music.stop()
    return render_template("play.html")

@app.route('/pause')
def pause():
    
    mixer.music.pause()
    return render_template("play.html")

@app.route('/unpause')
def unpause():
    
    mixer.music.unpause()
    return render_template("play.html")  

api.add_resource(Service, "/rest/<int:id>")

if __name__ == '__main__':
    app.debug = True
    app.run()