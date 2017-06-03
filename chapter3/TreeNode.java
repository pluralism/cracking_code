public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    int size = 0;


    public TreeNode(int d) {
        data = d;
        size = 1;
    }


    private void setLeftChild(TreeNode left) {
        this.left = left;
        if(left != null)
            left.parent = this;
    }


    private void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null)
            right.parent = this;
    }


    private static TreeNode createMinimalBST(int array[], int start, int end) {
        if(end < start)
            return null;

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.setLeftChild(createMinimalBST(array, 0, mid - 1));
        n.setRightChild(createMinimalBST(array, mid + 1, end));
        return n;
    }


    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }
}
