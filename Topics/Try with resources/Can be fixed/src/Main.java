import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        String language;
        BufferedReader buffReader;
        buffReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            language = buffReader.readLine();
            System.out.println("I'm learning " + language);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buffReader.close();
        }
    }
}