package algo.java.graph;

import algo.java.data.structure.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CourseScheduler {
    public ArrayList<Integer> scheduleCourses(int[][] courses) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        Stack<Integer> result = new Stack<>();
        for(int index = 0; index < courses.length; index++) {
            List<Integer> adj = new ArrayList<>();
            for(int j = 1; j < courses[index].length; j++) {
                adj.add(courses[index][j]);
            }
            graph.put(courses[index][0], adj);
            visited.put(courses[index][0], 0);
        }

        for(Integer course: graph.keySet()) {
            if (visited.get(course) == 0) {
                dfsSort(course, graph, visited, result);
            }
        }

        ArrayList<Integer> courseOrder = new ArrayList<>();
        while(!result.isEmpty()) {
            courseOrder.add(result.pop());
        }
        return courseOrder;
    }

    private void dfsSort(Integer course, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> visited,
        Stack<Integer> result) {
        visited.replace(course, 1);

        for (Integer adj: graph.get(course)) {
            if (visited.get(adj) == 0) {
                dfsSort(adj, graph, visited, result);
            }
        }

        result.push(course);
    }

    public Boolean canSchedule(int[][] courses) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int index = 0; index < courses.length; index++) {
            List<Integer> adj = new ArrayList<>();
            for(int j = 1; j < courses[index].length; j++) {
                adj.add(courses[index][j]);
            }
            graph.put(courses[index][0], adj);
            visited.put(courses[index][0], 0);
        }

        for(Integer course: graph.keySet()) {
            if (!dfsCanSchedule(course, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private Boolean dfsCanSchedule(Integer course, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> visited) {

        if (visited.get(course) == 2) {
            return true;
        }

        if ( visited.get(course) == 1) {
            return false;
        }

        visited.replace(course, 1);

        for (Integer adj: graph.get(course)) {
            if (!dfsCanSchedule(adj, graph, visited)) {
                return false;
            }
        }
        visited.replace(course, 2);
        return true;
    }
}
