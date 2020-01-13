package com.github.curriculeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Students extends People<Student>{

    private final static Students INSTANCE = new Students();

    private Students() {
        List<String> names = new ArrayList<>(Arrays.asList(
                "Sana Abdulateef",
                "Will Ancona",
                "James Choi",
                "Erjon Dervishaj",
                "Fernando Forte",
                "Richard Grant",
                "Pranathi Gutta",
                "Nick Hoffman",
                "Ryan Jamison",
                "George Kamau",
                "Buzuayehu Kassa",
                "Kyoung Kim",
                "Grayson Mameniskis",
                "Tierney Mellen",
                "Ngu Nguyen",
                "Tatsiana Odebunmi",
                "Antonio Perdigoto",
                "Divyalakshmi Rajamanickam",
                "Montaniz Stills Jr",
                "Susan Tabassum",
                "Chris Vo",
                "Kevin Wang",
                "Hui Zheng",
                "Ming Zhou"
                ));
        long idNum = 1L;

        for (String name : names) {
            
        }
        
    }

    public static Students getInstance(){
        return INSTANCE;
    }
}

