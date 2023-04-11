package signal.spotter;

import java.util.List;

public class GraphqlResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

class Data {
    private ListReports listReports;

    public ListReports getListReports() {
        return listReports;
    }

    public void setListReports(ListReports listReports) {
        this.listReports = listReports;
    }
}

class ListReports {
    private List<Report> items;

    public List<Report> getItems() {
        return items;
    }

    public void setItems(List<Report> items) {
        this.items = items;
    }
}

class Report {
    private String datetime;
    private double x;
    private double y;

    public Report(String datetime, double x, double y) {
        this.datetime = datetime;
        this.x = x;
        this.y = y;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}