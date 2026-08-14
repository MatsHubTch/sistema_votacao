import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Votacao {

    static int escolha_voto;

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            int escolha_quantia_candidatos;
            int votosRestantes = 30;

            System.out.print("===============================\n    CADASTRO DE CANDIDATOS    \n===============================\n\n");
            System.out.print("Quantos candidatos deseja cadastrar? Só são permitidos 5. ");

            escolha_quantia_candidatos = scanner.nextInt();
            scanner.nextLine();

            if (escolha_quantia_candidatos < 6 && escolha_quantia_candidatos > 0) {

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
                int[] votos = new int[candidatos.size()];

//---------------------------------------------------------------------------------------------------------------

                System.out.println("\n\n=== INICIAR VOTAÇÃO ===");
                for (int i = 0; i < candidatos.size(); i++) {
                    System.out.println("\nCandidato: " + i);
                    System.out.print("Nome: " + candidatos.get(i));
                }

                System.out.println("\n\nDigite 0 para sair e 1 para continuar a votação");
                double continuar = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("\n\n==== VOTAÇÃO SENDO FEITA ====");
                System.out.println("\n");
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print(".");
                    System.out.flush();
                }
                System.out.print("\n");
                Random random = new Random();
                if (continuar == 1) {
                    for (int i = 0; i < candidatos.size(); i++) {
                        if (i == candidatos.size() - 1) {
                            votos[i] = votosRestantes;
                        } else {
                            int numeroSorteado = random.nextInt(votosRestantes) + 1;
                            votos[i] = numeroSorteado;
                            votosRestantes = votosRestantes - numeroSorteado;
                        }
                        System.out.print("\n");
                        if (votos[i] == 0) {
                            System.out.println(candidatos.get(i) + " não ganhou nenhum voto.");
                        }
                        System.out.println("Candidato " + i + " " + candidatos.get(i) + " tem " + votos[i] + " votos");
                    }

//-------------------------------------------------------------------------------------------------------

                    System.out.println("\n=== PERCENTUAL DE VOTOS ===");
                    for (int i = 0; i < candidatos.size(); i++) {
                        int percentual = (votos[i] * 100) / 30;
                        System.out.println(candidatos.get(i) + ": " + percentual + "% dos votos");
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

                } else {
                    System.out.println("Saindo...");
                }

                scanner.close();
            } else {
                System.out.println("Só são permitidos de 1 a 5 candidatos");
            }

        } catch (Exception e) {
            System.out.println("Faça uma digitação valida, sem texto quando se usa só números e sem números quando se usa só texto.");
        }
    }
}