package activities;

import java.util.HashMap;


public class Activity11{
    public static void main(String[] args){
        HashMap<Integer,String> colours=new HashMap<Integer,String>();
        colours.put(1,"Red");
        colours.put(2,"Blue");
        colours.put(3,"Green");
        colours.put(4,"Rose");
        colours.put(5,"Violet");
        System.out.println("Printing map:");
        System.out.println(colours);
        colours.remove(5);
        System.out.println("After removing violet:");
        System.out.println(colours);
        if(colours.containsValue("Green")){
            System.out.println("Green is present in map.");
        }
        System.out.println("Size of the map : "+colours.size());

    }
}
