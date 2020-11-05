public class onedimantionArray {
    public static void main(String[] args) {

        int [] array = {10,11,5,4,5,6,8,9,7,4,5,8};

        int minValue = array[0];
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++){
            if (array[i] < minValue) {
                minValue = array[i];
            }
            if (array[i] > maxValue) {
                maxValue = array[i];
            }

        }
        System.out.print("min Value: " + minValue +"max Value: " + maxValue);



    }
 }
