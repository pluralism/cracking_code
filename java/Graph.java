import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if(!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String starName, String endName) {
        Project start = getOrCreateNode(starName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }

    public void createNode(String p) { }
}

class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if(!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public String getName() {
        return name;
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

    public int getNumberDependencies() {
        return dependencies;
    }
}
