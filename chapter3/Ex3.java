import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Ex3 {
    public static ArrayList<LinkedList<TreeNode>> createLevel(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);



        while(current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }

                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }


    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;

        for(LinkedList<TreeNode> ll : result) {
            Iterator<TreeNode> i = ll.listIterator();
            System.out.println(depth++);

            while(i.hasNext())
                System.out.println(i.next().data);
            System.out.println();
        }
    }
}
