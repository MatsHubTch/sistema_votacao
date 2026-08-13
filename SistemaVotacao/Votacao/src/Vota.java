import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Votacao {

    static int escolha_voto;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int quantia0 = 0;
        int quantia1 = 0;
        int quantia2 = 0;
        int quantia3 = 0;
        int quantia4 = 0;
        int rodando = 1;
        int escolha_quantia_candidatos = -1;
//----------------------------------------------------------------------------------------------------------------
while(rodando == 1) {


            System.out.print("\n\n===============================\n    CADASTRO DE CANDIDATOS    \n===============================\n\n");
            System.out.print("Quantos candidatos deseja cadastrar? no máximo 5 ");
            escolha_quantia_candidatos = scanner.nextInt();
            scanner.nextLine();

            if (escolha_quantia_candidatos < 6) {

                escolha_quantia_candidatos = escolha_quantia_candidatos - 1;

                List<String> candidatos = new ArrayList<>();

                for (int i = 0; i <= escolha_quantia_candidatos; i++) {
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
//----------------------------------------------------------------------------------------------------------------
                int totalVotos = 0;

                for (int i = 0; i < 30; i++) {
                    escolha_voto = random.nextInt(5); //random dos votos

                    if (escolha_voto >= 0 && escolha_voto < candidatos.size()) {
                        votos[escolha_voto]++;

                        totalVotos += escolha_voto;

                        if (escolha_voto == 0) {
                            quantia0 = quantia0 + 1;
                        }
                        if (escolha_voto == 1) {
                            quantia1 = quantia1 + 1;
                        }
                        if (escolha_voto == 2) {
                            quantia2 = quantia2 + 1;    //guarda a quantia de votos.
                        }
                        if (escolha_voto == 3) {
                            quantia3 = quantia3 + 1;
                        }
                        if (escolha_voto == 4) {
                            quantia4 = quantia4 + 1;
                        }


                    } else {
                        System.out.println("Candidato inexistente! Digite um número válido.");
                        i--;
                    }
                }

                System.out.println("AAAAAAAAAA: " + totalVotos);
//----------------------------------------------------------------------------------------------------------------
                if (candidatos.size() > 0) {
                    System.out.println(candidatos.get(0));
                    System.out.println("votos: " + quantia0);
                    int morango = (quantia0 * 100) / candidatos.size();
                    System.out.println("Percentual: " + morango + "%");
                    System.out.print("\n");
                }
                if (candidatos.size() > 1) {
                    System.out.println(candidatos.get(1));
                    System.out.println("votos: " + quantia1);
                    int morango1 = (quantia1 * 100) / candidatos.size();
                    System.out.println("Percentual: " + morango1 + "% dos votos");
                    System.out.print("\n");
                }
                if (candidatos.size() > 2) {
                    System.out.println(candidatos.get(2));
                    System.out.println("votos: " + quantia2);
                    int morango2 = (quantia2 * 100) / candidatos.size();
                    System.out.println("Percentual: " + morango2 + "% dos votos");
                    System.out.print("\n");
                }
                if (candidatos.size() > 3) {
                    System.out.println(candidatos.get(3));
                    System.out.println("votos: " + quantia3);
                    int morango3 = (quantia3 * 100) / candidatos.size();
                    System.out.println("Percentual: " + morango3 + "% dos votos");
                    System.out.print("\n");
                }
                if (candidatos.size() > 4) {
                    System.out.println(candidatos.get(4));
                    System.out.println("votos: " + quantia4);
                    int morango4 = (quantia4 * 100) / candidatos.size();
                    System.out.println("Percentual: " + morango4 + "% dos votos");
                    System.out.print("\n");
                }

//-------------------------------------------------------------------------------------------------------
                int maiorQtdVotos = -1;
                String nomeVencedor = "";

                for (int i = 0; i < candidatos.size(); i++) {
                    int votosDoCandidato = votos[i];

                    if (votosDoCandidato > maiorQtdVotos) {
                        maiorQtdVotos = votosDoCandidato;    //decide quem venceu
                        nomeVencedor = candidatos.get(i);
                    }
                }

                System.out.println("\nO candidato vencedor foi: " + nomeVencedor);

                scanner.close();
                break;
            }
            System.out.print("Escolha um número abaixo de 1 a 5. tente novamente:");
        }



    }
}
