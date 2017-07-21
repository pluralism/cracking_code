public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int level = 0;
    int size = 0;


    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof TreeNode))
            return false;

        TreeNode otherNode = (TreeNode) other;
        return data == otherNode.data;
    }
}
