import java.util.Scanner;

public class EstacFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fila fila = new Fila(10);
        fila.enfileira("ABC");
        fila.enfileira("DEF");
        System.out.println(fila.consultaCarro("ABC"));
        fila.desenfileira();
        fila.desenfileira();
        fila.desenfileira();
    //     System.out.println("Digite a capacidade máxima: ");
    //     int capacidade = sc.nextInt();
    //     int n;
    //     Fila fila = new Fila(capacidade);
    //     do {
    //         System.out.println("Digite o que fazer\n1. Adicionar um carro\n" +
    //         "2. Retirar um carro\n3. Consultar um carro\n0 encerra");
    //         n = sc.nextInt();
    //         switch (n) {
    //             case 1:
    //                 sc.nextLine();
    //                 System.out.println("Digite a placa do carro: ");
    //                 String placa = sc.nextLine();
    //                 break;
            
    //             case 2:
    //                 sc.nextLine();
    //                 System.out.println("Digite a placa do carro: ");
    //                 placa = sc.nextLine();

    //                 break;
                
    //             case 3:

    //                 break;
                
    //             default:
    //                 System.out.println("Opção inválida!");
    //                 break;
    //         }

    //     } while(n!=0);
        sc.close();
    }
}
