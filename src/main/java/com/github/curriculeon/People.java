package com.github.curriculeon;


import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class People<SomeType extends Person> implements Iterable<SomeType>{
    private List<SomeType> personList;

    public People() {
        personList = new ArrayList<>();
    }

    public People(List<SomeType> personList) {
        this.personList = personList;
    }


    public void add(SomeType newPerson) {
        this.personList.add(newPerson);
    }

    public void addAll(List<SomeType> personList){
        this.personList.addAll(personList);
    }

    public SomeType findById(long id){

        for (SomeType person : personList) {

            if (id == person.getId()){
                return person;
            }

        }
        return null;
    }

    public boolean contains(SomeType person){
        for (SomeType listPerson : personList) {

            if (listPerson.getId()==person.getId()&&listPerson.getName().equals(person.getName())){
                return true;
            }

        }
        return false;
    }

    public boolean remove(SomeType person)
    {
        if(this.contains(person)) {
            return this.personList.remove(person);
       }
        return false;

    }

    public SomeType remove(long id){

        SomeType personLeaving = findById(id);
        //my removes might have redundant checks but w/e
        if (personLeaving != null) {
             remove(personLeaving);
            return personLeaving;
        }
        return null;
    }

    public SomeType[] removeAll(){
        SomeType[] temp = this.personList.toArray((SomeType[]) new Object[this.personList.size()]); //GENERIC CAST
        this.personList = new ArrayList<>();
        return temp;
    }

    public int count(){
        return this.personList.size();
    }

    public SomeType[] toArray(){
        return (SomeType[]) this.personList.toArray(); //GENERIC CAST
    }


    @Override
    public Iterator iterator() {
        return this.personList.iterator();
    }

    @Override
    public String toString(){
        String peopleContents = "";
        for (SomeType someType : personList) {
            peopleContents = peopleContents.concat(someType.toString() + " ");
        }
        return "Size: " + this.personList.size() + " CONTENTS: " + peopleContents;
    }
}
