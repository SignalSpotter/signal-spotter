package signal.spotter;

public class App {
    public static void main(String[] args) {
        try {
            Authentication.Authenticate("testuser@gmail.com", "testtest");
            new GUI();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
