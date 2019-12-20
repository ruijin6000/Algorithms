/** #92
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * **/


package ReverseLinkedListII;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**  m.pre -> n    m-> n.next **/

        if (head.next == null || m == n) {
            return head;
        }

        ListNode pre, cur, next;
        ListNode M = null;
        ListNode N = null;
        ListNode Mpre = null;

        cur=head;

        for (int i =1 ; i<n ; i++){
            if (i==m-1) { Mpre= cur; }
            if (i==m)  { M= cur;}
            cur = cur.next;
        }



        N=cur;
        /************* m.pre -> n    m-> n.next ******************/

        cur = M;
        pre = N.next;

        for (int i=0; i<=n-m ; i++){
            next = cur.next;
            cur.next = pre;
            pre= cur;
            cur = next;
        }

       if(Mpre !=null)
       {
         Mpre.next = N;
       }

        if (m==1) {
            return pre;
        }

      return head;
    };


    public static void main (String[] arg) {
        ReverseLinkedListII myList = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for (int i = 2 ; i<8 ;i++) {
              cur.next = new ListNode(i);
              cur = cur.next;
        }

//        cur = head;
//        for (int i = 0 ; i<7 ;i++) {
//            System.out.print(cur.val);
//            cur=cur.next;
//        }
//
//        System.out.println("");
//        cur =myList.reverseBetween(head,3,5);
//
//        for (int i = 1 ; i<=7 ;i++) {
//            System.out.print(cur.val);
//            cur=cur.next;
//        }

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(5);



        cur =myList.reverseBetween(head2,1,2);

        for (int i = 1 ; i<=2 ;i++) {
            System.out.print(cur.val);
            cur=cur.next;
        }


    }





}
