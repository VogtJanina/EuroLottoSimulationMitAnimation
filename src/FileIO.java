import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

  public static String read(String filename) {
    String content = "";
    String line;
    try {
      BufferedReader filereader = 
          new BufferedReader(
              new FileReader(filename));
      while ((line = filereader.readLine())
          != null){
        content += line + '\n';
      }
      filereader.close();
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  } 
  
  public static void write(String filename, 
                           String content){
    
    try {
      FileWriter writer = 
          new FileWriter(filename);
      writer.write(content);
      writer.close();
    } 
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    
  }
}
