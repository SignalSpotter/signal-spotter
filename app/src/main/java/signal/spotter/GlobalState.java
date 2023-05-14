package signal.spotter;

public class GlobalState {
    private static GlobalState instance = null;
    private String jwt = "";

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
}
