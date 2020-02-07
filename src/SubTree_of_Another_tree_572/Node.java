package SubTree_of_Another_tree_572;

public class Node {
    int val;
    Node left, right;

    public Node find(int num){

        return helper(this,num);
    }

    public Node helper(Node node, int num){


        if(num<this.val){
           return helper(left,num);
        }
        else if (num>this.val){
           return helper(right,num);
        }
        else {
            return this;
        }


    }

}
