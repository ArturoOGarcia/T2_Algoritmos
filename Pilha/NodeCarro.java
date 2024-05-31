public class NodeCarro {
    private String placa;
    private int hora;
    private int minuto;
    private long millis;
    private NodeCarro proximo;

    public NodeCarro (String placa, int hora, int minuto, long millis) {
        this.placa = placa;
        this.hora = hora;
        this.minuto = minuto;
        this.millis = millis;
        this.proximo=null;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public NodeCarro getProximo() {
        return proximo;
    }

    public void setProximo(NodeCarro proximo) {
        this.proximo = proximo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "[placa=" + placa + "]";
    }
}