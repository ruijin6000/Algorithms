/** #2
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807. **/
package ReverseLinkedListII;


public class Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int digit = 0;
        int carry = 0;

        ListNode rNode = new ListNode(0);

        ListNode result = rNode;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val;
            digit = (sum + carry) % 10; //
            carry = (sum + carry) / 10;
            rNode.next = new ListNode(digit);
            rNode =rNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            sum = l1.val;
            digit = (sum + carry) % 10; //
            carry = (sum + carry) / 10;
            rNode.next = new ListNode(digit);
            rNode = rNode.next;
            l1 = l1.next;

        }
        while(l2 != null){
            sum = l2.val;
            digit = (sum + carry) % 10; //
            carry = (sum + carry) / 10;
            rNode.next = new ListNode(digit);
            rNode = rNode.next;
            l2 = l2.next;
        }


        if(l1 == null && l2 == null && carry == 1){
            rNode.next = new ListNode(1);

        }

        return result.next;
    }


    public static void main (String[] arg) {

        Add_Two_Numbers temp = new Add_Two_Numbers();
          //243+564 = 708 ==> 342+465 == 807  output :708
        ListNode l1, l2 ;
        l1= new ListNode(2);
        l1.next =new ListNode(4);
        l1.next.next = new ListNode (3);

        l2= new ListNode(5);
        l2.next =new ListNode(6);
        l2.next.next = new ListNode (4);



        ListNode cur;
        cur = temp.addTwoNumbers(l1,l2);


        while (cur != null) {
            System.out.print(cur.val);
            cur=cur.next;
        }




    }
}
