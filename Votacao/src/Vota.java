import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Votacao {

    static int escolha_voto;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("===============================\n    CADASTRO DE CANDIDATOS    \n===============================\n\n");
        System.out.print("Quantos candidatos deseja cadastrar? ");
        int escolha_quantia_candidatos = scanner.nextInt();
        scanner.nextLine();


        List<String> candidatos = new ArrayList<>();


        for (int i = 1; i <= escolha_quantia_candidatos; i++) {
            System.out.print("Digite o nome do candidato " + i + ": ");
            String nome = scanner.nextLine();
            candidatos.add(nome);
        }

        System.out.println("\n=== CANDIDATOS REGISTRADOS ===");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.print("\n");
            System.out.print("Nome: " + candidatos.get(i));
        }

//---------------------------------------------------------------------------------------------------------------

    System.out.println("\n\n=== INICIAR VOTAÇÃO ===");
    for (int i = 0; i < candidatos.size(); i++) {
        System.out.print("\n\n");
        System.out.println("Candidato: " + i + "");
        System.out.print("Nome: " + candidatos.get(i));
    }
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println("\nFaça o seu voto de 0 a " + escolha_quantia_candidatos +":");
            escolha_voto = Integer.parseInt(scanner.nextLine());
        }






        //String primeiroNome = candidatos.get(4);
        //System.out.println("\n\nPrimeiro: " + primeiroNome);

        scanner.close();
    }
}
