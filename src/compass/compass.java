package compass;

public class compass {
    int minstep = Integer.MAX_VALUE;
    int result ;

    public int output (int start, int end){
        int [] endpoints = new int[] {end,end+360,end-360};
        for(int i=0; i<endpoints.length ; i++) {

            if(endpoints[i]>start){
                int temp  = Math.min(minstep , endpoints[i]-start );
                if(temp< minstep) {
                    minstep = temp;
                    this.result = endpoints[i]-start;
                }
            }
            else if (endpoints[i]<start) {
                int temp = Math.min(minstep,Math.abs(endpoints[i]-start));
                if(temp<minstep) {
                    minstep = temp;
                    this.result = endpoints[i]-start;
                }
            }
            else  {

                return 0;
            }

        }

        return result;
    }
    public static void main (String[] args ) {
        compass app = new compass();
        System.out.println(app.output(10,350));
    }
}
