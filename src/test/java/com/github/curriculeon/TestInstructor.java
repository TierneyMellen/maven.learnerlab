package com.github.curriculeon;

import org.junit.*;

public class TestInstructor {

    private Instructor mary = new Instructor(42L, "Mary");

    private void testTeach(Instructor instructor, Student student, double hoursTeaching){
        double oldHours;
        boolean isTrue;
        oldHours = student.getTotalStudyTime();
        instructor.teach(student, hoursTeaching);
        isTrue = student.getTotalStudyTime() == oldHours + hoursTeaching;
        Assert.assertTrue(isTrue);

    }

    private void testLecture(Instructor instructor, double totalHours, Student... students)
    {
        double[] initialTimes = new double[students.length];
        double endTimes;
        double expectedDifference = totalHours / students.length;

        for (int index = 0; index < students.length; index++) {
            initialTimes[index] = students[index].getTotalStudyTime();
        }

        //when
        instructor.lecture(students,totalHours);

        //then
        for (int index = 0; index < students.length; index++) {
            endTimes = students[index].getTotalStudyTime();
            Assert.assertEquals(endTimes - initialTimes[index], expectedDifference, 0.0);
        }
    }

    @Test
    public void testImplementation(){
        Assert.assertTrue(mary instanceof Teacher);
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(mary instanceof Person);
    }

    @Test
    public void test0(){
        Instructor dave = new Instructor(33L, "Dave");
        Student suzi = new Student(102L, "Suzie");
        testTeach(dave,suzi,12);
    }

    @Test
    public void test1(){
        Instructor darryl = new Instructor(48L, "Darryl");
        Student chris = new Student(3911L, "Chris");
        testTeach(darryl, chris,12);
    }

    @Test
    public void test2(){
        Instructor steve = new Instructor(90L, "Steve");
        Student chris = new Student(870L, "Chris");
        testTeach(steve, chris,14);
    }

    @Test
    public void test3(){
        Student[] students = {new Student(85L, "Rob"),
                new Student(93453L, "Karen"),
                new Student(34782423L, "Fred"),
                new Student(42L, "Lauren"),
                new Student(765L,"Niles")};
        Instructor jane = new Instructor(439837L, "Jane");
        testLecture(jane, 9.5, students);
    }

    @Test
    public void test4(){
        Student[] students = {new Student(85L, "Rob"),
                new Student(93453L, "Karen"),
                new Student(34782423L, "Fred")};
        Instructor jane = new Instructor(439837L, "Jane");
        testLecture(jane, 6, students);
    }

    @Test
    public void test5(){
        Student[] students = {new Student(85L, "Rob")};
        Instructor jane = new Instructor(439837L, "Jane");
        testLecture(jane, 5, students);
    }
}
