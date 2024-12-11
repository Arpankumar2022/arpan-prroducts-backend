package mistakes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadingResourcesFromDesktop {

    public static void main(String[] args) {

        try(FileInputStream fl = new FileInputStream( new File("./src/text.txt"))) {

            int data = fl.read();
            while(data!=1){
            System.out.print((char)data);
            data=fl.read();
            }
            fl.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
