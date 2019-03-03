import time

class Exercise:
    
    def __init__(self, exercise = "", weight = 0):
        self.exercise = exercise
        self.weight = weight


    def __str__(self):
        return "{}:{}".format(self.exercise, self.weight)
        #return "yeet"
    def __repr__(self):
        return "{}:{}".format(self.exercise, self.weight)
        #return "yeet"
class Person:
    
    def __init__(self, ID, name, exercises = []):
        self.ID = ID
        self.name = name
        self.exercises = exercises
        self.timeOut = 2700
        self.postTime = time.time()


    def __str__(self):
        return "{},{},{}".format(self.ID,self.name,self.exercises)
        
    def __repr__(self):
        return "{},{},{}".format(self.ID,self.name,self.exercises)
