///**206 *
// **/
//package ReverseLinkedListII.Reverse_Linked_List;
//
//import ReverseLinkedListII.ListNode;
//
//public class Reverse_Linked_List {
//
//    public class Q206_Reverse_Linked_List {
//        // -1- 2- 3- 4- 5
//        // c
//        //   n
////    public ListNode reverseList(ListNode head) {
////        // ------------ 定义 ---------------
////        ListNode pre = null;   // 定义 pre
////        ListNode cur = head;   // 定义 cur
////        ListNode nex; // 定义 nextN
////
////        while(cur != null){
////            // 保存cur的下一个节点 so that when the cur points to other nodes,
////            // the nextN is not missing
////            // KEY: USE the right side to remember what need to be updated
////
////            nex = cur.next; // 确定next位置
////
////            // ----------- 更新 -----------------
////            cur.next = pre;   // 更新pre
////            pre = cur;        // 更新 cur
////            cur = nex;      // 更新 nextN
////
////        }
////        return pre;
////    }
//
//        public ListNode reverseList(ListNode head) {
//            if(head == null) return head;
//
//            ListNode cur = reverseList(head.next); // 5
//            cur.next = head; //null- 5
//            return null;
//        }
//        //    public ListNode helper(ListNode head){
////        if(head == null) return head;
////        head = helper(head.next);
////
////    }
//        public static void main(String[] args) {
//            ListNode head = new ListNode(1);
//            head.next = new ListNode(2);
//            head.next.next = new ListNode(3);
//            head.next.next.next = new ListNode(4);
//            head.next.next.next.next = new ListNode(5);
//
////        System.out.println(head);
//            Q206_Reverse_Linked_List q = new Q206_Reverse_Linked_List();
//            ListNode result = q.reverseList(head);
////        System.out.println(result);
//            while(result != null){
//                System.out.println(result.val);
//                result = result.next;
//            }
//        }
//    }
//}
