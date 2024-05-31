import java.util.Calendar;

public class Pilha {
    private NodeCarro topo;
    private int tamanho;
    private int capacidade;

    public Pilha (int capacidade) {
        this.capacidade = capacidade;
    }

    public Pilha () {
        //capacidade padrao 100
        capacidade = 100;
        tamanho = 0;
    }

    public NodeCarro getTopo() {
        return topo;
    }

    public void setTopo(NodeCarro topo) {
        this.topo = topo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public boolean estaCheia() {
        return tamanho >= capacidade;
    }

    public void push (String placa) {
        // checar se esta cheia
        if (estaCheia()) {
            System.out.println("Estacionamento cheio");
        } 
        else {
            // pegar hora e minutos atuais
            Calendar agora = Calendar.getInstance();
            int hora = agora.get(Calendar.HOUR_OF_DAY);
            int minutos = agora.get(Calendar.MINUTE);
            long millis = System.currentTimeMillis();
            NodeCarro novo = new NodeCarro(placa, hora, minutos, millis);

            if (!estaVazia()) novo.setProximo(topo); 
            topo = novo;
            tamanho++;
        }
    }

    public void push (NodeCarro carro) {
        //checar se esta cheia
        if (estaCheia()) {
            System.out.println("Estacionamento cheio");
        }
        else if (!estaVazia()) {
            carro.setProximo(topo);
        }
        topo = carro;
        tamanho++;
    }

    public NodeCarro pop() {
        // remove o do topo da pilha e retorna o carro
        if (estaVazia()) return null;
        NodeCarro aux = topo;
        topo = topo.getProximo();
        aux.setProximo(null);
        tamanho--;
        return aux;
    }

    public long pop(String placa) {
        //remove um carro especifico e retorna o tempo de permanencia em ms
        //printa o numero de manobras necessarias (sair e voltar = 1 manobra)
        if (estaVazia()) return -1;
        if (placa.equals("")) {
            long saida = System.currentTimeMillis();
            NodeCarro aux = pop();
            long tempo = saida - aux.getMillis();
            return tempo;
        }
        System.out.println(tamanho);
        NodeCarro aux = topo;
        int manobras = 0;
        Pilha temporaria = new Pilha();
        long tempo = 0;
        while (aux != null && !aux.getPlaca().equals(placa)) {
            temporaria.push(pop());
            aux = topo;
            manobras++;
        }
        if (aux != null) {
            // esta no carro a remover
            long saida = System.currentTimeMillis();
            tempo = saida - aux.getMillis();
            pop();
            // System.out.println("temporaria = " + temporaria);
            while (!estaCheia() && !temporaria.estaVazia()) {
                push(temporaria.pop());
            }
        }
        tamanho--;
        System.out.println("Foram necessarias " + manobras + " manobras para remover o carro de placa " + placa);
        return tempo;
    }

    public NodeCarro peek() {
        // verifica o topo
        if (estaVazia()) return null;
        return topo;
    }
    
    public NodeCarro consulta(String placa) {
        if(estaVazia()) {
            System.out.println("Estacionamento vazio");
            return null;
        }
        NodeCarro aux = topo;
        int posicao = 1;
        while (aux != null && !aux.getPlaca().equals(placa)) {
            aux = aux.getProximo();
            posicao++;
        }
        if (aux != null) {
            // achou o carro
            System.out.println("Carro de placa " + aux.getPlaca() + " esta na posicao " + posicao + 
            " da fila e entrou as " + aux.getHora() + ":" + aux.getMinuto());
        }
        else {
            // nao achou
            System.out.println("Carro nao encontrado");
        }
        return aux;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "pilha vazia"; 
        String s = "";
        NodeCarro aux = topo;
        while (aux != null) {
            s += aux + " ";
            aux = aux.getProximo();
        }
        return s;
    }
}