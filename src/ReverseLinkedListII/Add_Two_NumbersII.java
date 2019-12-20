/**  445. Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7**/

package ReverseLinkedListII;

import java.util.Stack;

public class Add_Two_NumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        int sum = 0;
        int digit = 0;

        ListNode head = new ListNode(0);
        ListNode cur;
        ListNode pre = null;

        // pop them and add them while one of them is not null
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int n1 = (stack1.isEmpty() ? 0 : stack1.pop().val);
            int n2 = (stack2.isEmpty() ? 0 : stack2.pop().val);

            sum = n1 + n2;
            digit = ( sum + carry) % 10;
            carry = ( sum + carry) / 10;

            // head - T2- T1 - null
            //
            //         c
            //         p
            head.next = new ListNode(digit);
            cur = head.next;
            cur.next = pre;
            pre = cur;

        }
        if(carry == 1){
            // h - 1- 0
            //     c
            head.next = new ListNode(carry);
            cur = head.next;
            cur.next = pre;
            pre = cur;


        }

        // reverse resultH;

        return head.next;
    }
}
