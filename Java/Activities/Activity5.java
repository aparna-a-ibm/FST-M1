package activities;

public class Activity5 {
    public static void main(String[] args){
        MyBook newNovel = new MyBook();
        //Set title
        newNovel.setTitle("A man called Ove");

        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }
}
