package Chapter4.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hnastevska on 6/22/2017.
 */
public class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Project> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDependencies() {
        return dependencies;
    }

    public void setDependencies(int dependencies) {
        this.dependencies = dependencies;
    }
}
