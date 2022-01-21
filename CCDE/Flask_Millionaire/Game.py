from random import randint
import random


class Question:
    
    def __init__(self, question, level, answers, ind):
        self.question=question
        self.level=level
        self.answers=answers
        self.index=ind
    
    def __str__(self):
        
       return self.question+" "+" "+str(self.level)+" "+str(self.answers)+" "+str(self.index)
    

def read_questions(filename):
    f = open (filename,"r")
    f.readline()
    lines=f.readlines()
    questions=[]
    for item in lines:
        question=item.split("\t")
        answers=[question[2],question[3],question[4],question[5]]
        random.shuffle(answers)
        correct=answers.index(question[2])
        q1= Question(question[1],question[0],answers,correct)
        questions.append(q1)

    return questions
    
   
    
def get_rand_question(level, questions):
    questionsOfLevel = []
    for question in questions:
        if int(question.level) == level:
            questionsOfLevel.append(question)
    random = randint(0, len(questionsOfLevel) - 1)
    return questionsOfLevel[random]    
