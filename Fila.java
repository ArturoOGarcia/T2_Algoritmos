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
    public String desenfileira () {
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
        return "Foram necessárias 0 manobras para remover o carro de placa " + temp.getPlaca() + " que ficou por " + permanencia + " minutos no estacionamento";
    }

    public String desenfileira(String placa){
        if (estaVazia()) {
            return "Estacionamento vazio!";
        }
        NodeCarro atual = primeiro;
        NodeCarro anterior = null;
        int manobras = 0;

        while (atual != null && !atual.getPlaca().equals(placa)) {
            anterior = atual;
            atual = atual.getProximo();
            manobras++;
        }
        if (atual != null) {
            atual.setHoraSaida(LocalDateTime.now());
            if (anterior != null) {
                anterior.setProximo(atual.getProximo());
            } else {
                primeiro = atual.getProximo();
            }
            if (atual == ultimo) {
                ultimo = anterior;
            }
            tamanho--;
            long permanencia = java.time.Duration.between(atual.getHoraEntrada(), atual.getHoraSaida()).toMinutes();
            return "Foram necessárias " + manobras + " manobras para remover o carro de placa " + atual.getPlaca() + " que ficou por " + permanencia + " minutos no estacionamento";
        }
        return "Carro de placa " + placa + " não encontrado";
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