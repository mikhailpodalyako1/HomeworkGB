public class twodimantionArray {
    public static void main(String[] args) {
        int A = 5;
        int array [][] = new int [A][A];

        for (int i = 0; i < A; i++){
           array[i][i]=1;
        }
        for (int i = 0; i < A; i++){
            for (int j=0; j<A; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}
