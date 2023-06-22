package activities;

public class MountainBike extends Bicycle{
    public int seatHeight;
     MountainBike(int gears,int currentSpeed,int startHeight){
        seatHeight=startHeight;
        super.gears=gears;
        super.currentSpeed=currentSpeed;
;    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed+"\nHeight of the seat is "+seatHeight);
    }

}


