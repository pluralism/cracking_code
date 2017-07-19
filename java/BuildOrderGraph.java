import java.util.ArrayList;

public class BuildOrderGraph {
    public Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for(String[] dependency : dependencies) {
            // First must be compiled before second
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    public Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        // Insert first non dependent element
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            if(current == null)
                return null;

            ArrayList<Project> children = current.getChildren();
            for(Project child : children)
                child.decrementDependencies();

            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    // Insert projects with zero dependencies
    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for(Project project : projects)
            if(project.getNumberDependencies() == 0)
                order[offset++] = project;

        return offset;
    }
}
