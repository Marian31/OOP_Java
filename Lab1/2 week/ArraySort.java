public class ArraySort {

    public static void main(String[] args) {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;

        //PUT YOUR CODE HERE
        int swap;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(array[j] < array[i]){
                    swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        } 
        
        //PUT YOUR CODE HERE

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}       