import datetime
import os
from flask import Flask, request,jsonify
from flask_restful import Resource, Api
from werkzeug.utils import secure_filename
import sqlite3
from sqlalchemy.sql.expression import func

from sqlalchemy import Column, Integer, Text, DateTime, create_engine, LargeBinary
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from pathlib import Path

from dataclasses import dataclass

ALLOWED_EXTENSIONS = {'mp3', 'wav'}

app = Flask(__name__)
api = Api(app)

Base = declarative_base()
metadata = Base.metadata
engine = create_engine(r'sqlite:///D:\Apps\SQLite\musicinfo.sqlite3')
db_session = scoped_session(sessionmaker(autocommit=True, autoflush=True, bind=engine))
Base.query = db_session.query_property


def getMusicInfo():
    id = 1
    music = []
    for x in os.listdir():#Kann auch anderen Path eintragen, vllt wenn auf Raspberry, umändern
        if x.endswith('.mp3'):#vllt allowed_extensions
            m = MusicInfo(id, x, Path(x).resolve())
            music.append(m)
            id+=1
        if x.endswith('.wav'):
            m = MusicInfo(id, x, Path(x).resolve())
            music.append(m)
            id+=1
    return music
            

class MusicInfo(Base):
    __tablename__ = 'musicinfo'
    
    id = Column(Integer, primary_key=True)
    name = Column(Text, nullable=False)
    path = Column(Text, nullable=False)
    
    def __init__(self, id, name, path):
        self.id = id
        self.name = name
        self.path = path
    
    def serialize(self):
        return{
            "ID" : str(self.ID),
            "NAME" : self.name,
            "PATH" : self.PATH
        }
    
    
class Service(Resource):
    def get(self, id):
        #get all songs
        music = MusicInfo.query.get(id)
        if not music:
            return jsonify({"message" : "does not exist"})
        return music.serialize()
    
    def put(self, id):
        #play song
        music = MusicInfo.query.get(id)
        if request.form["EXTENSION"] not in ALLOWED_EXTENSIONS:
            return jsonify({"Message" : "extension is wrong"})
        
    def delete(self, id):
        music = MusicInfo.query.get(id)
        if not music:
            return jsonify({"message" : "file with this id does not exist %s" %id})
        db_session.delete(music)
        db_session.flush()
        
    def getByName(self, name):
        music = MusicInfo.query.get(name)
        if not music:
            return jsonify({"message" : "does not exist"})
        return music.serialize()
    
    def patch(self, id):
        return {"Result":"Nicht erfolgreich geändert!"}
    
    def post(self, id):
        #change volume
        return {"Result":"Daten konnten nicht gesendet werden"}
    
api.add_resource(Service, "/file/<string:id>")

def createDB():
    Base.metadata.create_all(bind = engine)
   
class AllMusic(Resource):
    def get(self):
        return {"Result" : "blablablablabla"}
           
#TODO: 
 
# if __name__ == '__main__':
#     createDB()
#     app.run(debug=True, host="0.0.0.0")


            