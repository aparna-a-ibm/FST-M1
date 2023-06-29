package activities;

import java.util.HashSet;
import java.util.Scanner;

public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Kerala");
        hs.add("Tamil Nadu");
        hs.add("Karnataka");
        hs.add("Telangana");
        hs.add("Andhra Pradesh");
        hs.add("Goa");
        System.out.println("Elements in Hashset:");
        for (String e:hs) {
            System.out.println(e);
        }

        System.out.println("Size of the hash set:"+hs.size());
        System.out.println("Enter the element to be removed from the hashset:");
        Scanner sc= new Scanner(System.in);
        String element=sc.nextLine();
        if(hs.contains(element)){
            hs.remove(element);
            System.out.println(element + " is removed from the hashset.");
        }
        else{
            System.out.println(element + " is not present in the hashset and cannot be removed.");

        }
        System.out.println("Enter the name of element to check in the Hashset:");
        String checkelement=sc.nextLine();
        if(hs.contains(checkelement)){
            System.out.println("Element "+checkelement+" is present in the Hashset.");

        }
        else{
            System.out.println("Element "+checkelement+" is not present in the Hashset.");
        }
        System.out.println("Elements in Hashset now:");
        for (String e:hs) {
            System.out.println(e);
        }
    }
}
