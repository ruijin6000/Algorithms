package Sort;

public class Sort {

    /**** Insertion Sort ****/
    public int[] insertionSort(int[] A) {
        int key, i;


        for (int j = 1; j < A.length; j++) {
            key = A[j];
            i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
        return A;
    }

    /**** Merge Sort ****/
    public void mergeSort(int [] A, int p, int r) {
        if (p<r) {
          int q =(p+r)/2;
          mergeSort(A,p,q);
          mergeSort(A,q+1,r);
          merge(A,p,q,r);

       }
    }

    public void merge(int[] A, int p, int q ,int r) {
        int n1 = q-p+1;
        int n2 = r-q;

        int [] L = new int[n1];
        int [] R = new int[n2];

        for (int i =0 ; i<n1; i++) {
              L[i]= A[p+i-1];
        }

        for (int j=0; j<n2; j++) {
            R[j] = A[q+j];
        }


    }







    public static void main (String args[]) {
        System.out.print("HI There\n");
        Sort is = new Sort();


        int [] nums = {5,3,2,1,4,6,8,7,99};

        is.insertionSort(nums);

        for (int i=0 ; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }



    }
}
