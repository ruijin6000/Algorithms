package Q394_Decode_String;

import java.util.Stack;

public class Decode_String {

    public String decodeString(String s) {
        /**
         3 [ a 2 [ b c ] ]
         i

          100 [a] 0[cs]
              i
          j
         s1: "abcbcabcbcabcbc"
         s2:
         cur =[    SB1= abcbc    SB1=abcbcabcbcabcbc
         **/
        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        char[] chars = s.toCharArray();
        int size = chars.length;
        int i = 0;

        while(i < size){

            if( Integer.valueOf(chars[i])>=48 && Integer.valueOf(chars[i])<=57 ){
                 String buffer = "";

                 while (Integer.valueOf(chars[i])>=48 && Integer.valueOf(chars[i])<=57) {
                     buffer = buffer+chars[i];
                     i++;
                 }
                  i--;
                s2.push( Integer.parseInt(buffer) ); // 3 2
            }
            else {
                if(chars[i] != ']'){

                    s1.add(Character.toString(chars[i]));
                }
                else{ // == ']'
                    StringBuilder sb = new StringBuilder();
                    String cur = s1.pop(); // c
                    while(!cur.equals("[")){
                        sb.insert(0, cur); // b c
                        cur = s1.pop(); // b
                    }
                    // cur == '['
                    String result = repeat(sb, s2.pop()); // bcbc
                    s1.push(result);
                }
            }
            i++;
        }

        StringBuilder temp = new StringBuilder();
        while (!s1.isEmpty()) {
            temp.insert(0, s1.pop());
        }
        return temp.toString();
    }


    public String repeat(StringBuilder sb,int curNumber){
        String temp = sb.toString();
        String result="";
        for (int i= 0 ; i<curNumber ; i++) {
            result = temp + result;
        }
        return result;
    };


    public static void main(String[] args) {
        String str=  "3[a]2[bc]";
        String str2= "100[leetcode]";
        Decode_String app = new Decode_String();
        System.out.println(app.decodeString(str2));
    }
}
