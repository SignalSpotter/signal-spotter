package signal.spotter;

public class App {

    public static void main(String[] args) {

        try {
            Database db = new Database();

            // System.out.println(db.createReport(new Report("2023-04-10T08:15:30.000000Z",
            // 0.3, 0.4)));
            System.out.println(db.queryReports());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
