package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main (String[] args){
        Scanner scan= new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        Random indexGen=new Random();
        System.out.println("Enter list of integers(Type non-integer to terminate):");
        while(scan.hasNextInt()) {

            list.add(scan.nextInt());
        }
        Integer nums[] = list.toArray(new Integer[0]);
        Integer rand=indexGen.nextInt(nums.length);
        System.out.println("Index value generated: " +rand);
        System.out.println("Value in array at generated index: " + nums[rand]);
        scan.close();
    }
}
