public class revers {
    public static void main(String[] args) {
        int[] array = {1,1,0,0,1,0,1,1,0,1};
        for (int i = 0; i < array.length; i++){
            array[i] = array[i] == 1 ? 0 : 1;
            System.out.print (array[i] + " ");
        }
    }
}
