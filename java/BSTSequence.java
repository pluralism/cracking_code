import java.util.*;

class BSTSequence {
    private TreeNode root;
    private ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();

    BSTSequence() {
        root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left = new TreeNode(5);
        //root.right = new TreeNode(15);
        //root.left.right = new TreeNode(7);
        //root.left.left = new TreeNode(3);
    }

    private ArrayList<ArrayList<TreeNode>> allPermutations(ArrayList<TreeNode> nodes, int start, int end) {
        if(start == end)
            res.add((ArrayList<TreeNode>) nodes.clone());
        else {
            for(int j = start; j <= end; j++) {
                Collections.swap(nodes, start, j);
                allPermutations(nodes, start + 1, end);
                Collections.swap(nodes, start, j);
            }
        }
        return res;
    }

    private ArrayList<ArrayList<TreeNode>> mergeSequences(ArrayList<ArrayList<TreeNode>> first, ArrayList<ArrayList<TreeNode>> second) {
        ArrayList<ArrayList<TreeNode>> results = new ArrayList<>();
        for(ArrayList<TreeNode> ff : first) {
            for(ArrayList<TreeNode> ss : second) {
                ArrayList<TreeNode> tmp = new ArrayList<>();
                tmp.addAll(ff);
                tmp.addAll(ss);
                results.add(tmp);
            }
        }
        return results;
    }

    private ArrayList<ArrayList<TreeNode>> buildSequences(HashMap<Integer, ArrayList<TreeNode>> levels) {
        ArrayList<ArrayList<TreeNode>> results = new ArrayList<>();
        HashMap<Integer, ArrayList<ArrayList<TreeNode>>> resLevels = new HashMap<>();
        Set<Integer> keys = levels.keySet();

        for(Integer level : keys) {
            results = allPermutations(levels.get(level), 0, levels.get(level).size() - 1);
            resLevels.put(level, (ArrayList<ArrayList<TreeNode>>) results.clone());
            results.clear();
        }

        if(resLevels.size() > 1) {
            results = mergeSequences(resLevels.get(0), resLevels.get(1));
            for(int i = 2; i < resLevels.size(); i++)
                results = mergeSequences(results, resLevels.get(i));
        }

        return results;
    }

    void allSequences() {
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<Integer, ArrayList<TreeNode>> levels = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.level = 0;
        visited.add(root);

        while (!q.isEmpty()) {
            TreeNode tmp = q.remove();
            if(levels.containsKey(tmp.level))
                levels.get(tmp.level).add(tmp);
            else
                levels.put(tmp.level, new ArrayList<>(Arrays.asList(tmp)));

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
        buildSequences(levels);
    }
}
