import java.time.LocalDateTime;

public class Fila {
    private NodeCarro primeiro;
    private NodeCarro ultimo;
    private int tamanho;
    private int capacidade;
    
    public Fila (int capacidade) {
        this.capacidade = capacidade;
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    public int getTamanho() {
        return tamanho;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public boolean estaCheia() {
        return tamanho >= capacidade;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }



    public void enfileira(String placa) {
        if (estaCheia()) System.out.println("Estacionamento cheio!");
        else {
            NodeCarro novoC = new NodeCarro(placa, LocalDateTime.now());
            if (estaVazia()) {
                primeiro = novoC;
            }
            else {
                ultimo.setProximo(novoC);
            }
            ultimo = novoC;
            tamanho++;
        }
    }
    public NodeCarro desenfileira () {
        if (estaVazia()) {
            System.out.println("Estacionamento vazio!");
            return null;
        }
        NodeCarro temp = primeiro;
        temp.setHoraSaida(LocalDateTime.now());
        primeiro = primeiro.getProximo();
        if (primeiro == null) { //esvaziou a fila
            ultimo = null;
        }
        tamanho--;
        long permanencia = java.time.Duration.between(temp.getHoraEntrada(), temp.getHoraSaida()).toMinutes();
        System.out.println("Foram necessárias 0 manobras para remover o carro de placa " + temp.getPlaca() + " que ficou por " + permanencia + " minutos no estacionamento");
        return temp;
    }

    public NodeCarro desenfileira(int pos){
        if (estaVazia()) {
            System.out.println("Estacionamento vazio!");
            return null;
        }
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Posição inválida!");
            return null;
        }
        NodeCarro atual = primeiro;
        NodeCarro anterior = null;
        int index = 0;
        int manobras = 0;

        while (atual != null && index != pos) {
            anterior = atual;
            atual = atual.getProximo();
            index++;
            manobras++;
        }
    }


    public String consultaCarro(String placa) {
        if (estaVazia()) {
            System.out.println("Estacionamento vazio!");
            return null;
        }
        int cont = 0;
        NodeCarro aux = primeiro;
        while (aux != null) {
            if (aux.getPlaca().equals(placa)) {
                return "Carro de placa " + aux.getPlaca() + " com horário de entrada " + aux.formatarDataHora(aux.getHoraEntrada()) + " está na posição " + cont;
            }
            cont++;
            aux = aux.getProximo();
        }
        return null;
    }

    @Override
    public String toString () {
        if (estaVazia()) return "fila vazia";
        String s = "";
        NodeCarro aux = primeiro;
        while (aux != ultimo) {
            s += aux + " - ";
            aux = aux.getProximo();
        }
        s += aux;
        return s;
    }
}