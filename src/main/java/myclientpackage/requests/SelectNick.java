package myclientpackage.requests;

public class SelectNick {
    private String type;
    private String nick;

    public SelectNick(String nick) {
        this.type = "CONNECT";
        this.nick = nick;
    }
}
