package activities;
public class CustomException extends Exception{
    private String message="";
    CustomException(String expmessage){
        message=expmessage;

    }
    @Override
    public String getMessage() {
        return message;
    }
}
