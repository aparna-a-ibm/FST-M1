package activities;

public class Car {
    String color,transmission;
     int make,tyres,doors;
     public  Car(){
         this.doors=4;
         this.tyres=4;
     }
     public void displayCharacteristics(){
         System.out.println("Color of the car:"+color);
         System.out.println("Transmission of the car:"+transmission);
         System.out.println("Number of tyres in the car:"+tyres);
         System.out.println("Number of doors in the car:"+doors);
    }
    public void accelarate(){
        System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }
}
