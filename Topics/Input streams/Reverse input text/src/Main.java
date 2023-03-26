import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] lineInChars = reader.readLine().toCharArray();
        for (int i = lineInChars.length - 1; i >= 0; i--) {
            System.out.print(lineInChars[i]);
        }
    }
}