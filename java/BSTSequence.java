import java.util.*;

public class BSTSequence {
    private TreeNode root;

    public BSTSequence() {
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
    }

    public void allPermutations(ArrayList<TreeNode> nodes, int start, int end) {
        if(start == end) {
            System.out.println(nodes);
        } else {
            for(int j = start; j <= end; j++) {
                Collections.swap(nodes, start, j);
                allPermutations(nodes, start + 1, end);
                Collections.swap(nodes, start, j);
            }
        }
    }

    private void buildSequences(HashMap<Integer, ArrayList<TreeNode>> levels) {

    }

    public void allSequences() {
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<Integer, ArrayList<TreeNode>> levels = new HashMap<>();
        ArrayList<ArrayList<TreeNode>> nodesLevel = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.level = 0;
        visited.add(root);

        while (!q.isEmpty()) {
            TreeNode tmp = q.remove();
            if(levels.containsKey(tmp.level)) {
                levels.get(tmp.level).add(tmp);
            } else {
                levels.put(tmp.level, new ArrayList<>(Arrays.asList(tmp)));
            }

            if(tmp.left != null && !visited.contains(tmp.left)) {
                q.add(tmp.left);
                tmp.left.level = tmp.level + 1;
                visited.add(tmp.left);
            }
            if(tmp.right != null && !visited.contains(tmp.right)) {
                q.add(tmp.right);
                tmp.right.level = tmp.level + 1;
                visited.add(tmp.right);
            }
        }
    }
}
