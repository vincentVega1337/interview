package com.skylite.interview.shylov.task2.solution;

import java.io.*;
import java.util.ArrayList;

/**
 * Class assistant for read initial document
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class InputUnit {

    private static String FILE_PATH = "task2.txt";

    private static ArrayList<String> task;

    private InputUnit() {
    }

    /**
     * Create graph from initial document
     *
     * @return sad
     */
    public static Graph getGraph() {
        ArrayList<City> cities = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        String[] strings;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            strings = new String[Integer.parseInt(reader.readLine())];
            StringBuilder tmp = new StringBuilder();
            int edgeCount;
            for (int i = 0; i < strings.length; i++) {
                cities.add(new City(reader.readLine().toLowerCase()));
                edgeCount = Integer.parseInt(reader.readLine());
                for (int j = 0; j < edgeCount; j++) {
                    tmp.append(reader.readLine()).append("\n");
                }
                strings[i] = tmp.toString();
                tmp.setLength(0);
            }
            for (int i = 0; i < strings.length; i++) {
                String[] edgeDefinition = strings[i].split("\\s");
                for (int j = 0; j < edgeDefinition.length; ) {
                    edges.add(new Edge(cities.get(i), cities.get(Integer.parseInt(edgeDefinition[j++]) - 1), Integer.parseInt(edgeDefinition[j++])));
                }
            }
            task = new ArrayList<>();
            while (reader.ready()) {
                task.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Graph(cities, edges);
    }

    /**
     * Return tasks from file
     *
     * @return arrayList of tasks
     */
    public static ArrayList<String> getTasks() {
        getGraph();
        return task;
    }
}
