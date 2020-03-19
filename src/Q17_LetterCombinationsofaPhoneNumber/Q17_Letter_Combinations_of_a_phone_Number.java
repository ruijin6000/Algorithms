package Q17_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Q17_Letter_Combinations_of_a_phone_Number {

    List<String> result;
    String[][] array = new String[][]{
            {"", "", "", ""},
            {"", "", "", ""},
            {"a", "b", "c", ""},
            {"d", "e", "f", ""},
            {"g", "h", "i", ""},
            {"j", "k", "l", ""},
            {"m", "n", "o", ""},
            {"p", "q", "r", "s"},
            {"t", "u", "v", ""},
            {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {

        result = new ArrayList<String>();
        char[] dis = digits.toCharArray();

        if (digits.length() == 0) {
            return result;
        }

        helper(0, dis, "");
        return result;
    }

    public void helper(int index, char[] dis, String buffer) {

        if (index == dis.length) {
            result.add(buffer);
            return;
        }

        String tt = Character.toString(dis[index]);
        int curNum = Integer.parseInt(tt);


        if (curNum != 7 && curNum != 9) {
            String buffer1 = buffer + array[curNum][0];
            String buffer2 = buffer + array[curNum][1];
            String buffer3 = buffer + array[curNum][2];
            helper(++index, dis, buffer1);
            index--;
            helper(++index, dis, buffer2);
            index--;
            helper(++index, dis, buffer3);
            index--;
        } else {
            String buffer1 = buffer + array[curNum][0];
            String buffer2 = buffer + array[curNum][1];
            String buffer3 = buffer + array[curNum][2];
            String buffer4 = buffer + array[curNum][3];
            helper(++index, dis, buffer1);
            index--;
            helper(++index, dis, buffer2);
            index--;
            helper(++index, dis, buffer3);
            index--;
            helper(++index, dis, buffer4);
            index--;
        }
    }

    public static void main(String args[]) {
        Q17_Letter_Combinations_of_a_phone_Number app = new Q17_Letter_Combinations_of_a_phone_Number();
        List<String> result = app.letterCombinations("23");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
