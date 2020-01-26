/** 133 Clone Graph
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 *
 * Note:
 *
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.**/


package Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Clone_Graph_133 {
    public Node cloneGraph(Node node) {
        // 0. remember the first node of copy nodes as the return node
        Node copy = new Node(node.val, new ArrayList<>());
        Node dummyCopy = copy;

        HashMap<Node, Node> map = new HashMap<>();


        Queue<Node> q = new LinkedList<>(); // contains ori nodes
        q.add(node); //1

        while(!q.isEmpty()){
            Node ori = q.remove(); // 1， 2

            if(!map.containsKey(ori)){
                copy = new Node(ori.val, new ArrayList<>()); //1
                // but since using n.val, so it gets updated every time

                // 1. create both nodes and put both in the map <ori, copy>
                // so every time ori go to the next nodes, copy can get that node as well
                map.put(ori, copy);

            } else {
                copy = map.get(ori); // 2
            }

            // 2. for every neis of ori node, for loop neis,
            // 2： 1 + 3
            for(Node nei: ori.neighbors){ // 2 4
                // 3. to add to copy node's neis, create a node with empty neis first,
                // --> so that not reference to the ori node

                if(!map.containsKey(nei)){
                    Node copyNei = new Node(nei.val, new ArrayList<>());
                    q.add(nei);// 2 4
                    map.put(nei, copyNei); // 2 4
                }
                copy.neighbors.add(map.get(nei)); // 1 -- 2 +4


            }
        }
        return map.get(node);
    }





    public static void main (String[] args) {
        System.out.println("test1");
        Clone_Graph_133 myApp = new Clone_Graph_133();
        Node one = new Node ();
        Node two = new Node ();
        Node three = new Node();
        Node four = new Node();

        one.val= 1;
        one.neighbors.add(two);
        one.neighbors.add(four);

        two.val= 2;
        two.neighbors.add(one);
        two.neighbors.add(three);

        three.val= 3;
        three.neighbors.add(two);
        three.neighbors.add(four);

        four.val= 4;
        four.neighbors.add(one);
        four.neighbors.add(three);

       myApp.cloneGraph(one);


    }

}
