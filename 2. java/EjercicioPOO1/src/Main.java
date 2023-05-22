import javax.imageio.stream.FileImageInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try{
            FileImageInputStream fileImageInputStream = new FileImageInputStream("prueba.txt");

        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }
}