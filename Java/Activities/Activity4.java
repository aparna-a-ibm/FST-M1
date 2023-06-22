package activities;

public class Activity4 {
    public static void main(String[] args) {
        int[] insertionSortArray = {5, 6, 3, 1, 4, 2, 8, 9, 7, 10, 60, 20};
        System.out.println("Array before sorting:");
        for (int element : insertionSortArray) {
            System.out.print(" " + element);
        }
        insertionSort(insertionSortArray);
        System.out.println("\nArray after sorting:");
        for (int element : insertionSortArray) {
            System.out.print(" " + element);
        }
    }

        public static void insertionSort ( int[] inputArray){
        for(int i=1;i<inputArray.length;i++){
            int key=inputArray[i];
            int j=i-1;
            while(j>=0 && inputArray[j]>key){
                inputArray[j+1]=inputArray[j];
                j--;
            }
            inputArray[j+1]=key;
        }
    }
}


