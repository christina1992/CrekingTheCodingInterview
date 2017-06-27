package Chapter4.TreesAndGraphs;

import java.util.ArrayList;

/**
 * Created by hnastevska on 6/21/2017.
 */
public class BuildOrder {
    //Find correct build order
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());

    }

    /*
        Return a list of the projects a correct build order
     */
    private Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        // Add "roots" to the build order first
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;

        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            //We have a circular dependency since there are no remaining projects with
            //zero dependency
            if (current == null) {
                return null;
            }
            //Remove myself as a dependency
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            //Add children that have no one depending on them
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    //A helper function to insert projects with zero dependencies into the order
    // array, starting at index offset
    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    /*
        Build the graph, adding the edge (a, b) if b is dependent on a.
        Assumes a pair is listed in "build order". The pair (a, b) in
        dependencies indicates that b depends on a and a must be build before b
     */
    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }
}
