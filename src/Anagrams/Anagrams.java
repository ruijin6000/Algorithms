

package Anagrams;


import java.util.*;


public class Anagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int p_length = p.length();
        int s_length = s.length();
        List<Integer> result= new ArrayList();

        if (p_length>s_length){
            return result;
        }

        for (int i=0 ; i<s_length; i++){

            if(i+p_length>s_length){
               break;
            }

            String s_sub = s.substring(i,i+p_length);

            if (match(s_sub,p)) {
                result.add(new Integer(i));
            }
        }

      return result;
    }


    public boolean match (String x, String y) {

        char[] sub = x.toCharArray();
        char[] p = y.toCharArray();
        Arrays.sort(sub);
        Arrays.sort(p);
       return  Arrays.equals(sub, p);

    }


    public static void main (String args[]) {

        System.out.print("HI There lalala \n");
        Anagrams arg = new Anagrams();

       // arg.findAnagrams("cbaebabacd","abc");

        System.out.print( arg.findAnagrams("cbaebabacd","abc"));

        System.out.print( arg.findAnagrams("baa","aa"));

    }
}


//    public boolean match (String x, String y) {
//
//        char[] sub = x.toCharArray();
//        char[] p = y.toCharArray();
//        boolean [] marks1 = new boolean[p.length];
//        boolean [] marks2 = new boolean[p.length];
//        Arrays.fill(marks1, Boolean.FALSE);
//        Arrays.fill(marks2, Boolean.FALSE);
//
//        for (int i = 0 ; i<p.length; i++){
//
//            for (int j= 0; j<sub.length; j++) {
//
//                if (p[i]== sub[j]){
//                    marks1[i]=true;
//                }
//            }
//        }
//
//
//        for (int i = 0 ; i<sub.length; i++){
//            for (int j= 0; j<p.length; j++) {
//                if (sub[i]==p[j]){
//                    marks2[i]=true;
//                }
//            }
//        }
//
//
//        for (int i=0; i<marks1.length; i++){
//            if (marks1[i]==false){
//                return false ;
//            }
//            if (marks2[i]==false){
//                return false ;
//            }
//        }
//
//        return true;
//    }



