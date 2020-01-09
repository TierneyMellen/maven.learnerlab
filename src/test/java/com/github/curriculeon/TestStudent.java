package com.github.curriculeon;

import org.junit.*;

public class TestStudent {
    private Student student = new Student(2L,"Diana");

    private void testLearn(double timeToAdd) {
        double oldTime, newTime;
        boolean isTrue;

        oldTime = student.getTotalStudyTime();
        student.learn(timeToAdd);
        newTime = student.getTotalStudyTime();
        isTrue = oldTime + timeToAdd == newTime;

        Assert.assertEquals(oldTime + timeToAdd ,newTime, 0);
    }

    @Test
    public void testImplementation(){
        Assert.assertTrue(student instanceof Learner);
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(student instanceof Person);
    }

    @Test
    public void test0(){
        testLearn(2.5);
    }

    @Test
    public void test1(){
        testLearn(50.5);
    }

    @Test
    public void test2(){
        testLearn(0.0);
    }

}
