package wave21.Blog.exceptions;

public class NotExistsException extends RuntimeException{
    public NotExistsException() {
    }

    public NotExistsException (String message){
        super(message);
    }
}