from Question import Question
import random

questions = []
def setupgame(file):
    f=open(file, "r")
    lines = f.read()
    f.close()
    help = []
    help = lines.split("\n")
    for i in range(len(help)):
        questions.append(help[i].split("\t"))

def randomizeanswers():
    rand1 = random.randint(2,5)
    rand2 = random.randint(2,5)
    while rand2 == rand1:
        rand2 = random.randint(2,5)
    rand3 = random.randint(2,5)
    while rand3 == rand1 or rand3 == rand2:
        rand3 = random.randint(2,5)
    rand4 = random.randint(2,5)
    while rand4 == rand1 or rand4 == rand2 or rand4 == rand3:
        rand4 = random.randint(2,5)
    return rand1,rand2,rand3,rand4


def getquestion(rand):
    a1,a2,a3,a4 = randomizeanswers()
    question = Question(questions[rand][0],questions[rand][1],questions[rand][a1],questions[rand][a2],questions[rand][a3],questions[rand][a4])
    return question
        
setupgame("C:/Users/maxip/Downloads/millionaire.txt")
level1 = 60
level2 = 66
level3 = 50
level4 = 15
currentlevel = 40
substractor = 40
running = 1
correct = 0

while running == 1:
    rand = random.randint(currentlevel-substractor, currentlevel)
    q = getquestion(rand)
    print(q)
    answer = input("Your answer: ")
    if answer == questions[rand][2]:
        print("right\n")
        correct += 1
        if correct == 10:
            print("Winner Winner Chicken Dinner\t\tBut no million euros for you")
            running = 0
        else:
            match correct:
                case 2:
                    currentlevel += level1
                    substractor = level1
                case 4:
                    currentlevel += level2
                    substractor = level2
                case 6:
                    currentlevel += level3
                    substractor = level3
                case 8:
                    currentlevel += level4
                    substractor = level4
    else:
        print("wrong\n\n\n")
        correct = 0
        currentlevel = 40
        substractor = 40