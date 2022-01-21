from Game import Question, read_questions, get_rand_question
from flask import Flask, render_template, session

app= Flask(__name__)
app.secret_key= '_5#y2L”F4Q8z\n\xec]/'

@app.route('/')
def start():
    session["level"]=0
    return render_template("start.html")

@app.route('/question')
def showQuests():
    return render_template("questions.html", question=read_questions("C:/Users/maxip/Downloads/millionaire.txt"))


@app.route('/game')
@app.route('/game/<int:answer>')
def game(answer=-1):
    if answer != -1:
        if answer == (session["right"]+1):
            if session["level"]==4:
                # level auf 0; korrekte Antwort löschen; gewinner seite anzeigen
                session["level"] = 0
                session.pop('correct', None)
                return render_template("win.html", result=dict,text="Sie haben gewonne")
            session["level"] +=1
        else:
            session["level"] = 0
            return render_template("win.html", result=dict,text="Sie haben verloren")
        
    q= get_rand_question(session["level"], read_questions("C:/Users/maxip/Downloads/millionaire.txt"))
    session["right"]= q.index
    return render_template("game.html", lev=session["level"], question=q)



if __name__ == '__main__':
       app.run(debug=True)

