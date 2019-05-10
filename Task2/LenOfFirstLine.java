import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LenOfFirstLine {
    public static void main(String[] args) {
        if(args.length == 1){
            try(var Buff = new BufferedReader(new FileReader(args[0]))){
                String text = Buff.readLine();
                if(text != null && text.length() > 0){
                    int len = text.trim().split("\\s+").length;
                    System.out.println(len);
                }
                else {
                    System.out.println(0);
                }
            }
            catch(IOException ex){
                System.out.println(-1);
            }
        }
        else {
            System.out.println(-1);
        }
    }
  }