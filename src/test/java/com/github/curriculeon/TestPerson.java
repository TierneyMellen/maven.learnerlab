package com.github.curriculeon;

import org.junit.*;

public class TestPerson {

    private void testConstructor(Long userId, String userName)
    {
        Boolean hasId, hasName;

        //when
        Person tester = new Person(userId, userName);

        //then

        Assert.assertEquals(tester.getId(), userId);
        Assert.assertEquals(tester.getName(), userName);
    }

    private void testSetName(Long userId, String oldName, String newName) {
        //when
        Person person = new Person (userId, oldName);
        person.setName(newName);
        //then
        Assert.assertEquals(person.getName(), newName);
    }


    @Test
    public void test0() {
        //if
        testConstructor(50L, "Kimberly");
    }

    @Test
    public void test1() {
        //if
        testConstructor(893L, "Andrew");
    }

    @Test
    public void test2() {
        //if
        testConstructor(272L, "Tyler");
    }

    @Test
    public void test3() {
        //if
        testSetName(50L, "Kimberly", "Diane");
    }


    @Test
    public void test4() {
        //if
        testSetName(893L, "Andrew", "Andy");
    }

    @Test
    public void test5() {
        //if
        testSetName(272L, "Tyler", "Trinity");
    }

}
