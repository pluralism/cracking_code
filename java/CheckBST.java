import org.jetbrains.annotations.Contract;

public class CheckBST {

    @Contract("null, _, _ -> true")
    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if(n == null)
            return true;

        if((min != null && n.data <= min) || (max != null && n.data > max))
            return false;

        // Check left and right branches
        if(!checkBST(n, min, n.data) || !checkBST(n, n.data, max))
            return false;

        return true;
    }
}
