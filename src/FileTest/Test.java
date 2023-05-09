package FileTest;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args){
        File f1 = new File("document/test1.txt");
        File f2 = new File("document/test2.txt");
        decrypt(f1,f2);

    }
    public static void decrypt(File f1, File f2){
        char[] ch = new char[(int) f1.length()];
        try (FileReader fr = new FileReader(f1); FileWriter fw = new FileWriter(f2)){
            fr.read(ch);
            for (int i = 0; i < ch.length; i++){
                if(isLetterOrDigit(ch[i])){
                    switch(ch[i]){
                        case 'a':
                            ch[i] = 'z';
                            break;
                        case 'A':
                            ch[i] = 'Z';
                            break;
                        case '0':
                            ch[i] = '9';
                            break;
                        default:
                            ch[i]++;
                    }
                }else{
                    ch[i] = ch[i];
                }
            }
            System.out.println(new String(ch).trim());
            fw.write(new String(ch).trim());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean isLetterOrDigit(char ch){
        String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return -1 == str.indexOf(ch)?false:true;
    }
}
