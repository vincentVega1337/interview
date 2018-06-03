package com.skylite.interview.shylov.task2;

import com.skylite.interview.shylov.task2.solution.Graph;
import com.skylite.interview.shylov.task2.solution.InputUnit;

import java.util.ArrayList;

/**
 * Demo class, create graph from file and calculate some path
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.println("***PART 2***");
        Graph g = InputUnit.getGraph();
        ArrayList<String> tasks = InputUnit.getTasks();
        System.out.println(tasks);
        for (String string : tasks) {
            System.out.println(string + " minimal cost is " + g.calculateMinimalPath(string));
        }
        System.out.println("***********");
    }

}
