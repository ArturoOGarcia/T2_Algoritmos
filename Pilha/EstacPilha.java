import java.util.Scanner;

public class EstacPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Digite a capacidade maxima: ");
        int capacidade = sc.nextInt();
        Pilha pilha = new Pilha(capacidade);
        System.out.println("Digite o que fazer\n1. Adicionar um carro\n" +
            "2. Retirar um carro\n3. Consultar um carro\n4. Consultar estacionamento\n0. Encerra");
        n = sc.nextInt();
        do {
            String placa;
            switch(n) {
                case 1:
                    sc.nextLine();
                    System.out.println("Digite a placa do veiculo");
                    placa = sc.nextLine();
                    pilha.push(placa);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Digite a placa do veiculo, nada para remover o primeiro");
                    placa = sc.nextLine();

                    long permanencia = pilha.pop(placa);
                    int minutos = (int) (permanencia/1000)/60;
                    int segundos = (int) permanencia/1000;
                    // System.out.println("Pilha = " + pilha);
                    if (!placa.equals("")){
                        System.out.println("Carro de placa " + placa + " ficou " + minutos + " minutos e " + segundos + " segundos");
                    }
                    else {
                        System.out.println("Carro do topo da fila retirado, permaneceu " + minutos + " minutos e " + segundos + " segundos");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Digite a placa do veiculo");
                    placa = sc.nextLine();
                    System.out.println("placa = " + placa);
                    pilha.consulta(placa);
                    break;
                case 4: 
                    System.out.println("Estacionamento possui " + capacidade + " vagas no total. " + pilha.getTamanho() + " vagas estão sendo utilizadas. " + String.valueOf(capacidade-pilha.getTamanho()) + " vagas estão disponíveis.");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
            System.out.println("Digite o que fazer\n1. Adicionar um carro\n" +
            "2. Retirar um carro\n3. Consultar um carro\n4. Consultar estacionamento\n0. Encerra");
            n = sc.nextInt();
        } while (n != 0);
        sc.close();
    }
}