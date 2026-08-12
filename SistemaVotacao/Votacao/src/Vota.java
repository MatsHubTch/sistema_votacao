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

        int[] votos = new int[candidatos.size()];

        System.out.println("\n\n=== INICIAR VOTAÇÃO ===");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.print("\n\n");                 //Nessa parte ele exibe os candidatos.
            System.out.println("Candidato: " + i + "");
            System.out.print("Nome: " + candidatos.get(i));
        }
        System.out.print("\n");
//-------
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println("\nFaça o seu voto de 0 a " + (candidatos.size() - 1) + ":");
            escolha_voto = Integer.parseInt(scanner.nextLine());        //Escolher o voto, looping dependendo da quantia de candidatos.

            if (escolha_voto >= 0 && escolha_voto < candidatos.size()) {
                votos[escolha_voto]++;
            } else {                                         //verifica se existe o candidato. caso não, vota dnv.
                System.out.println("Candidato inexistente! Digite um número válido.");
                i--;
            }
        }
//-------------------------------------------------------------------------------------------------------
        int maiorQtdVotos = -1;
        String nomeVencedor = "";

        for (int i = 0; i < candidatos.size(); i++) {
            int votosDoCandidato = votos[i];

            if (votosDoCandidato > maiorQtdVotos) {
                maiorQtdVotos = votosDoCandidato;
                nomeVencedor = candidatos.get(i);
            }
        }

        System.out.println("\nO candidato vencedor foi: " + nomeVencedor);

        scanner.close();
    }
}
