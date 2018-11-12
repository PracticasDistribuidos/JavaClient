package myclientpackage.requests;

public class SelectNick {
    private String tipo;
    private String nick;

    public SelectNick(String nick) {
        this.tipo = "CONECTAR";
        this.nick = nick;
    }
}
