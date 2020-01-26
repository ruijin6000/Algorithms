package SubTree_of_Another_tree_572;

public class Q572_SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //Step1 : find all subnode
        //Step2 : compare is Subtree
        if (s == null) {
            return false;
        }

        if (s.val == t.val) {
            if (helpComapre(s,t)) {
                return true;
            }
            return isSubtree(s.left, t) || isSubtree(s.right,t);
        }
        else {
            return isSubtree(s.left, t) || isSubtree(s.right,t);
        }
    }


    public boolean helpComapre (TreeNode s, TreeNode t){
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }

        if(s.val == t.val){
            return helpComapre(s.left, t.left) && helpComapre(s.right, t.right);
        }

        return false;
    }


    public static void main (String[] args) {
        Q572_SubtreeofAnotherTree myApp = new Q572_SubtreeofAnotherTree();

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(0);

        TreeNode temp = new TreeNode(3);
        temp.left = node;
        temp.right = new TreeNode(5);

        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(2);

        TreeNode S1 = new TreeNode(1);
        S1.left = new TreeNode(1);

        TreeNode T1= new TreeNode(1);

        System.out.println(myApp.isSubtree(S1, T1));


    }
}
