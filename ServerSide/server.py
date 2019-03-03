from classes import *
from methods import *
from flask import Flask, request, jsonify
import json
import os

people = []

notes = {}

idNumber = 0


app = Flask(__name__)



@app.route('/kill', methods = ['POST'])
def kill():
    global people
    global notes
    
    json_data = request.get_json()
    print(json_data)
    
    death = json_data['guy']
    
    uid = (death.split(","))[0]
    print(uid)
    try:
        del notes[uid]
    except:
        ...
    people = remove(people, uid)
    
    print("KOOOOOOOOOOOOOOOOOOBBBBBBBBBBBBBBBYYYYYYYYYYYYYYYYYYY")
    print(people)
    print(notes)
    print("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOB")
    
    return "Noice"
    
    


@app.route("/idMake", methods = ["GET"])
def make():
    global idNumber
    idNumber+=1
    print(idNumber)
    return str(idNumber)



@app.route('/')
def base():
    print("this is doing a thing")
    return 'test'
    
    ####

@app.route('/notifications', methods = ['POST'])
def notify():
    global people
    global notes
    holder = prune(people, notes)
   
    people = holder[0]
    notes = holder[1]
    #get user id from sender
    
    #uid = lsakjdl;kasdg;lkja
    
    #user id needs to be recieved via POST and processed into a usable form
    json_data = request.get_json()
    #check if user id has notifications
    #if user has notifications, remove notification from list and return notification
    print(json_data)
    uid = json_data['UID']
    
    if uid in notes and notes[uid] != "":
        
        #yeet it back
        temp = notes[uid]
        #remove notification
        #del notes[uid]
        #people = remove(people, uid)
        
        print("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOTTTTTTTTTTTTTTTTTTTTTTTTTTTTEEEEEEEEEEEEESSSSSSSSSSSSSS")
        print(people)
        print(notes)
        print(temp)
        print("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIISSSSSSSSSSSSSSSSSS")
        
        #dic = {}
        #dic["message"] = temp
        #dic = json.dumps(dic)
        #return dic
        return temp
    else:
        print("GOOCHI")
        print(people)
        print(notes)
        print("OOOOF")
    #dic = {}
    #dic["message"] = "no notifications"
    #dic = json.dumps(dic)
    #return dic
    return "no notifications"
    
    
    
    
@app.route('/search', methods = ['POST'])
def search():
    #print("DAB")
    global people
    global notes
    
    holder = prune(people, notes)
   
    people = holder[0]
    notes = holder[1]
    #get stuff
    json_data = request.get_json()
    #print(json_data)
    builder = json_data["person"]
    builder = builder.split(",")
    pid = builder[0]
    name = builder[1]
    exer = builder[2:]
    ex = []
    for thing in exer:
        thing = thing.split(":")
        thing[1] = int(thing[1])
        ex.append(Exercise(thing[0],thing[1]))
    person = Person(pid,name,ex)
    #print(person)
    
    #see if repeat person, if so overwrite
    
    
    rep = checkRepeat(people,person)
    if rep != -1:
        people[rep] = person

    #see if match if so connect and delete both
    
    match = findMatch(people, person)
    if match != False:
        
        #connect the fuckers
        notes[(people[match[0]]).ID] = "{}, {}, {}".format(person.ID, person.name, match[1])
    

    #add to list of people at the end of the list
    if rep == -1 and match == False:
        people.append(person)
        notes[person.ID] = ""
    elif rep == -1:
        people.append(person)
        notes[person.ID] = "{}, {}, {}".format((people[match[0]]).ID,(people[match[0]]).name, match[1])
    print("YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEET")
    print(people)
    print(notes)
    print("YOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOINK")
    return ""

app.run(host='0.0.0.0', port=8080)