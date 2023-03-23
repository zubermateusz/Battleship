import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] byteInput = inputStream.readAllBytes();
        inputStream.close();
        for (byte a : byteInput) {
            System.out.print(a);
        }
    }
}