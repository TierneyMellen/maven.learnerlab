package com.github.curriculeon;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPeople {

    private void testFindById(List<Person> testList, long idToFind){
        //given
        Person personFound;
        People<Person> group = new People(testList);

        //when
        personFound = group.findById(idToFind);

        //then
        Assert.assertEquals(idToFind, personFound.getId(), 0.0);

    }

    private void testAdd(List<Person> personsToAdd){
        People<Person> group = new People();
        for (Person person : personsToAdd) {
            group.add(person);
        }
        for (Person checkPerson : personsToAdd) {
            Assert.assertTrue(group.contains(checkPerson));
        }
    }

    private void testRemove(List<Person> persons, long id, Person person)
    {
        //if
        People<Person> group = new People(persons);
        //when
        group.remove(person);
        group.remove(id);

        Assert.assertNull(group.findById(id));
        Assert.assertFalse(group.contains(person));

    }

    @Test
    public void test0() {
        Person[] persons= {new Person(1L, "Jerry"),
                new Person(2L, "Anne"),
                new Person(3L, "Kris")};
        List<Person> personsToAdd = Arrays.asList(persons);
        testAdd(personsToAdd);
    }

    @Test
    public void test1() {
        Person[] persons= {new Person(4L, "Jess"),
                new Person(5L, "Morris"),
                new Person(6L, "Libby"),
                new Person(7L, "Trevor")};
        List<Person> personsToAdd = Arrays.asList(persons);
        testAdd(personsToAdd);
    }
    @Test
    public void test2() {
        Person[] persons= {new Person(8L, "Troy"),
                new Person(9L, "Bella")};
        List<Person> personsToAdd = Arrays.asList(persons);
        testAdd(personsToAdd);
    }

    @Test
    public void test3() {
        Person jim = new Person(4L, "Jim");
        Person[] persons= {new Person(1L, "Jerry"),
                new Person(2L, "Anne"),
                new Person(3L, "Kris"), jim};
        List<Person> personsToAdd = new ArrayList<>(Arrays.asList(persons));
        testRemove(personsToAdd, 1L, jim);
    }

    @Test
    public void test4() {
        Person[] persons= {new Person(1L, "Jerry"),
                new Person(2L, "Anne"),
                new Person(3L, "Kris")};
        List<Person> personsToAdd = new ArrayList<>(Arrays.asList(persons));
        testFindById(personsToAdd, 1L);
    }

}
