package activities;

import java.util.ArrayList;
import java.util.Scanner;

public class Activity9 {
    public static  void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ArrayList<String> myList=new ArrayList<>();

        myList.add("cherry");
        myList.add("strawberry");
        myList.add("apple");
        myList.add("banana");
        myList.add("mango");

        for (String i : myList){
            System.out.println(i);
        }
        System.out.println("Third element in the list:"+myList.get(3));
        System.out.println("Enter the name of the element to check:");
        String element= sc.nextLine();
        if(myList.contains(element)){
            System.out.println(element+" is there in the list.");
        }
        else{
                System.out.println("Element not found in list.");

        }
        System.out.println("Size of the list:"+myList.size());
        System.out.println("Enter the name of the element to remove:");
        String removeelement= sc.nextLine();
        if(myList.contains(removeelement)){
            myList.remove(removeelement);
            System.out.println(removeelement+" is removed from the list.");
        }
        else{
            System.out.println("Element not found in list.");
        }
        System.out.println("Size of the list now:"+myList.size());

    }
}
