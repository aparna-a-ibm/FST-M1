package activities;

public class Activity2 {
    public static void main(String[] args){
        int[] array={10, 77, 10, 54, -11, 10};
        int sum=0;
        int targetSum=30;
        for (int element : array) {
            if (element == 10) {
                sum += element;
            }
        }
        if (sum == targetSum) {
            System.out.println("Sum is " + targetSum);
        } else if (sum > targetSum) {
            System.out.println("Sum is greater than " + targetSum);
        }

    }

}
