package signal.spotter;

import java.util.List;

public class GlobalState {
    private static GlobalState instance = null;
    private String jwt = "";
    private List<Report> reports;

    public static synchronized GlobalState getInstance() {
        if (instance == null) {
            instance = new GlobalState();
        }
        return instance;
    }

    public synchronized String getJWT() {
        return jwt;
    }

    public synchronized void setJWT(String jwt) {
        this.jwt = jwt;
    }

    public synchronized List<Report> getReports() {
        return reports;
    }

    public synchronized void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
