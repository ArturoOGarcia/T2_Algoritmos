import java.util.Scanner;

public class EstacFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Digite a capacidade maxima: ");
        int capacidade = sc.nextInt();
        Fila fila = new Fila(capacidade);
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
                    fila.enfileira(placa);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Digite a placa do veiculo, nada para remover o primeiro");
                    placa = sc.nextLine();
                    if (!placa.equals("")){
                        System.out.println(fila.desenfileira());
                    }
                    else {
                        System.out.println(fila.desenfileira(placa));
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Digite a placa do veiculo");
                    placa = sc.nextLine();
                    System.out.println(fila.consultaCarro(placa));                  
                    break;
                case 4:
                    System.out.println("Estacionamento possui " + capacidade + " vagas no total. " + fila.getTamanho() + " vagas estão sendo utilizadas. " + String.valueOf(capacidade-fila.getTamanho()) + " vagas estão disponíveis.");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
            System.out.println("Digite o que fazer\n1. Adicionar um carro\n" +
            "2. Retirar um carro\n3. Consultar um carro\n4. Consultar estacionamento\n0. encerra");
            n = sc.nextInt();
        } while (n != 0);
        sc.close();
    }
}