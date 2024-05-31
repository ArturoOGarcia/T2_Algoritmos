import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NodeCarro {
    private String placa;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private NodeCarro proximo;

    public NodeCarro (String placa, LocalDateTime horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSaida = null;
        this.proximo=null;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public NodeCarro getProximo() {
        return proximo;
    }

    public void setProximo(NodeCarro proximo) {
        this.proximo = proximo;
    }

    public String formatarDataHora(LocalDateTime dataHora) {
        return dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "[placa=" + placa + "horário de entrada=" + horaEntrada + "]";
    }
}