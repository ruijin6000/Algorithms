/**  #777
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform one string to the other.

 Example:
 Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 Output: True
 Explanation:
 We can transform start to end following these steps:
 RXXLRXRXL ->
 XRXLRXRXL ->
 XRLXRXRXL ->
 XRLXXRRXL ->
 XRLXXRRLX

 XL->LX  RX->XR
 **/

package SwapAdjacentInLR_String;

public class Swap_Adjacent_in_LR_String {


    public boolean canTransform(String start, String end) {
        int index1=0;
        int index2=2;

        if (start.length()!= end.length()) { return false ; }


        while (true) {


           String tempStart = start.substring(index1,index2);
           String tempEnd = end.substring(index1,index2);
           String revseStart = tempStart.substring(1)+tempStart.substring(0);

           if (revseStart == tempEnd) {
               index1 +=2;
               index2 +=2;
           }

           else {
               return false ;
           }
            return false ;
        }

    }

    public static void main (String arg[]){

        Swap_Adjacent_in_LR_String temp = new Swap_Adjacent_in_LR_String();
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        System.out.println(temp.canTransform(start,end));

        System.out.println(start.substring(0,2));

    }

}
