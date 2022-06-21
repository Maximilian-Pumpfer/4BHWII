import json
from flask_restful import Api
#from model import Question, getRandomQuestion, getData, Service, AllQuests, getQuests
from rest import MusicInfo, Service, getMusicInfo
from flask import Flask, render_template, session



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
@app.route('/play/<string:id>')
def panel():
    return render_template("startseite.html")

api.add_resource(Service, "/rest/<int:id>")

if __name__ == '__main__':
    app.debug = True
    app.run()