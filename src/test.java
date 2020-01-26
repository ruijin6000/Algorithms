import java.util.Scanner;

class Test {
    public static boolean flag = true;
    static int B;
    static int H;

    static {
        Scanner input = new Scanner(System. in);

        while (input.hasNext()) {
            int B = input. nextInt();
            int H = input. nextInt();
        }

    }



    public static void main(String[] args){
     int n =100;
     Integer.toString(n);
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main
} 