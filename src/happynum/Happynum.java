package happynum;

import java.util.HashSet;
import java.util.Set;

public class Happynum {


    public int helper(int n){
        int result = 0;
        while(n != 0){// 19, 1
            // calculate the result go back to the loop if the result is not =1

            result += Math.pow(( n % 10 ), 2);// 9 + 1
            n = n / 10; // 1,

        }
        System.out.println(result);
        return result;
    }
    public boolean isHappy(int n) {
        boolean isH = false;
        // 1. use set to keep all the result to check if ever go to a loop
        Set<Integer> set = new HashSet<>();

        set.add(n); //19
        int answer = n; //19

        if(answer == 1){
            return true;
        }


        while(answer != 1){

            int temp = answer;// 19, 82
            answer = helper(temp);// 68
            // check if in the set
            // yes: return false

            if(answer == 1){
                isH = true;
                return isH;
            }


            if(set.contains(answer)){
                isH = false;
                return isH;
            }
            // no: add to the set

            else{
                set.add(answer);
            }
            // n == 1 return true;

        }


        return isH;
    }

    public static void main (String args[]) {

        Happynum temp = new Happynum();
        System.out.print(temp.isHappy(19));


    }

}
