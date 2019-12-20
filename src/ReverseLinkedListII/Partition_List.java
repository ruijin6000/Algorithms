/**
 * 86  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 **/
/** Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 Example:
 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5**/

package ReverseLinkedListII;

public class Partition_List {


    public ListNode partition(ListNode head, int x) {
        // 1->4->3->2->3->5->2 x=3
        // L: node.val < 3 L: 0->1-> 2-> 2,
        //                    lh
        //                    l
        // R: node.val >= 3 R: 0->4 3 3 5

        ListNode lh = new ListNode(0);
        ListNode rh = new ListNode(0);

        ListNode lnode = lh;
        ListNode rnode = rh;

        ListNode node = head;
        while(node != null){
            if(node.val < x){
                lnode.next = new ListNode(node.val);
                lnode = lnode.next;

            } else {
                rnode.next = new ListNode(node.val);
                rnode = rnode.next;
            }
            node = node.next;
        }

        // connect L tail with R head
        lnode.next = rh.next;
        return lh.next;
    }


}
