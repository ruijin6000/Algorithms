/** 49. Group Anagrams
 *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *   Output:
 *  [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 *  ]
 * **/

package GroupAnagrams;
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();


        Map<String,List<String>> myMap = new HashMap<String, List<String>>();

          for (int i= 0 ; i<strs.length; i++) {

                 char[] tempkey = strs[i].toCharArray();

                        Arrays.sort(tempkey);

                  String key =  new String(tempkey);
               System.out.print("temp key is "+ key +"\n");

                 if (!myMap.containsKey(key)){
                     List<String> tempList = new ArrayList<String>();
                     tempList.add(strs[i]);
                     myMap.put(key,tempList);
                 }

                 else {
                       myMap.get(key).add(strs[i]);
                 }


    }




            for(String key: myMap.keySet()) {

                result.add( myMap.get(key));
            }

        return result;
    }

    public static void main(String[] arg) {
          GroupAnagrams temp = new GroupAnagrams();
          String [] arr = new String [] {"eat", "tea", "tan", "ate", "nat", "bat"};

          System.out.print( temp.groupAnagrams(arr));

    }

}
