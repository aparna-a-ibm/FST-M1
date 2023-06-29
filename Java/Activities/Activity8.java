package activities;

public class Activity8 {
    static void exceptionTest(String s) throws CustomException {
        if (s == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        try {
            Activity8.exceptionTest("Hello");
            Activity8.exceptionTest(null);
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }

    }



}
