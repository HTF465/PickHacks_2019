from classes import *
import time


def prune(people, notes):
    for place,person in list(enumerate(people))[::-1]:
        if time.time() - person.postTime > person.postTime:
            del notes[person.ID]
            people.pop(place)
    return [people, notes]
    

def checkRepeat(people, person):
    for place,peep in enumerate(people):
        if peep.ID == person.ID:
            return place
    return -1


def findMatch(people, person):
    #print("Person: {}".format(person.exercises))
    for place,peep in enumerate(people):
        if peep.ID != person.ID:
            #print("Peep: {}".format(peep.exercises))
            for exercise in peep.exercises:
                for ex in person.exercises:
                    if exercise.exercise == ex.exercise:
                        if abs(exercise.weight - ex.weight) < (max(exercise.weight, ex.weight)*0.2):
                            return [place, ex.exercise]
    return False            

def remove(people, ID):
    for place, person in enumerate(people):
        if person.ID == ID:
            people.pop(place)
            return people
    return people


