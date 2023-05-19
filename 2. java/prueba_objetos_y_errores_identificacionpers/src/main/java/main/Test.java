package main;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        try{

        FileInputStream fis = new FileInputStream("prueba.txt");

        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
