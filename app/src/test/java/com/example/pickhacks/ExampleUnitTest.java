package com.example.pickhacks;

import BackEnd.Person;
import BackEnd.Processing;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    Processing pro = new Processing();

    @Test
    public void addition_isCorrect() {
        Person test = new Person( "Gene Paulsen");
        test.addExercise("Bench Press", 75);
        test.addExercise("Squats", 120);
        //System.out.println(test.getAllExercises());
        System.out.println(test.toString());
        pro.go(test);
        pro.goGo(test);
    }

    @Test
    public void json(){

        Person test = new Person( "Gene Paulsen");
        test.addExercise("Bench Press", 75);
        test.addExercise("Squats", 120);

        Person test2 = new Person( "Randrwyn Win");
        test2.addExercise("Bench Press", 5);
        test2.addExercise("Squats", 600);

        Person test3 = new Person( "Testy McTestFace");
        test3.addExercise("Bench Press", 75);
        test3.addExercise("Squats", 500);

        pro.go(test);
        pro.go(test2);
        pro.go(test3);
        test3.addExercise("Dead Lift", 120);
        pro.go(test3);



    }

    @Test
    public void notiJson()
    {
        Person test = new Person("Gene Paulsen");
        test.addExercise("Bench Press", 75);
        test.addExercise("Squats", 120);

        Person test2 = new Person("Gene Paulsen");
        test.addExercise("Bench Press", 75);
        test.addExercise("Squats", 120);

        //Processing.goGo(test);
        pro.goGo(test2);
    }

    @Test
    public void idGeter()
    {
        Person test = new Person("Gene Paulsen");
        test.addExercise("Bench Press", 75);
        test.addExercise("Squats", 120);

        System.out.println(test.toString());
    }
}