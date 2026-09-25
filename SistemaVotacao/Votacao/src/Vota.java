import java.util.*;

class Vota {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int escolha = 0;
        int quantia = 0;
        Random random = new Random();
        int votosDisponiveís = 10;
        int quantidadeCandidatos = 0;
        int voto;
        int totalVotos = 0;
        int votos1 = 0;
        int votos2 = 0;
        int votos3 = 0;
        int votos4 = 0;
        int votos5 = 0;
        String[] candidatos = null;

//------------------------------------------------------------------------------------------

        do {

            System.out.println("================================");
            System.out.println("       SISTEMA DE VOTAÇÃO       ");
            System.out.println("================================");
            System.out.println("\n");
            System.out.println("1 - Cadastro de candidatos");
            System.out.println("2 - Iniciar votação");
            System.out.println("3 - Exibir resultado");
            System.out.println("4 - Exibir matriz de votos");
            System.out.println("5 - Encerrar sistema");
            System.out.print("\n");
            System.out.println("Selecione uma opção: ");
            System.out.print("\n");
            escolha = teclado.nextInt();
            System.out.print("\n");


//------------------------------------------------------------------------------------------

            if (escolha == 1) {
                try {
            do {

                    System.out.println("Quantos candidatos deseja cadastrar?");
                    System.out.print("\n");
                    quantia = teclado.nextInt();
                    quantidadeCandidatos = quantia;
                    teclado.nextLine();
                    if (quantia > 5) {
                        System.out.println("Só são permitidos 5 candidatos.");
                    }
                } while (quantia > 5 || quantia == 0) ;
            }catch(InputMismatchException e){
                    System.out.println("Só números por favor.");
                    break;
                }

                System.out.print("\n");

                candidatos = new String[quantia];
                for (int i = 0; i < quantia; i++) {
                    System.out.println("Qual o nome do candidato " + (i + 1) + "? ");
                    System.out.print("\n");
                    candidatos[i] = teclado.nextLine();
                    System.out.print("\n");
                }
                System.out.println("\nCandidatos cadastrados:");
                System.out.print("\n");
                for (int i = 0; i < quantia; i++) {
                    System.out.println(("Candidato " + (i + 1) + ":" + "\n") + ("Numero" + ": " + (i + 1) + "\n") + "Nome: " + candidatos[i] + "\n");
                }

                System.out.print("\n");
                System.out.println("Cadastro concluído com sucesso!");
                System.out.print("\n");


            }
            if (escolha == 2) {

                System.out.println("================================");
                System.out.println("       INÍCIO DA VOTAÇÂO        ");
                System.out.println("================================");
                System.out.println("\n");
                System.out.println("Candidatos cadastrados até agora:");
                if (quantia == 0) {
                    System.out.println("Nenhum candidato foi cadastrado até agora.");
                    break;
                }


                for (int i = 0; i < quantia; i++) {
                    System.out.println((i + 1) + " - " + candidatos[i]);

                }
                try {

                    System.out.print("\n");
                    System.out.println("Digite 0 para encerrar a votação e 1 para continuar: ");
                    System.out.print("\n");
                    escolha = teclado.nextInt();
                    System.out.print("\n");
                } catch (InputMismatchException e) {
                    System.out.print("Digite corretamente.");
                   break;
                }
                if (escolha == 1) {
                    try{
                    for (int i = 0; i < quantia; i++) {
                        System.out.println("Digite o número do candidato.");
                        voto = teclado.nextInt();

                        while (voto < 1 || voto > quantidadeCandidatos) {
                            System.out.println("Erro! Candidato inexistente.");
                            voto = teclado.nextInt();

                        }

                        if (voto == 1) votos1 = random.nextInt(votosDisponiveís);
                        if (voto == 2) votos2 = random.nextInt(votosDisponiveís);
                        if (voto == 3) votos3 = random.nextInt(votosDisponiveís);
                        if (voto == 4) votos4 = random.nextInt(votosDisponiveís);
                        if (voto == 5) votos5 = random.nextInt(votosDisponiveís);

                        totalVotos = votos1 + votos2 + votos3 + votos4 + votos5;
                        System.out.println("Voto registrado com sucesso.");
                    }
                    } catch (InputMismatchException e) {
                        System.out.println("Digite o número do candidato da proxima vez.");
                        break;
                    }
                }

            }


//------------------------------------------------------------------------------------------

            if (escolha == 3) {
                if(escolha == 3 && totalVotos == 0) {
                    System.out.println("Faça as etapas anteriores por favor.");
                    break;
                }
                int maiorNumeroDeVotos = votos1;

                if (votos2 > maiorNumeroDeVotos) maiorNumeroDeVotos = votos2;
                if (votos3 > maiorNumeroDeVotos) maiorNumeroDeVotos = votos3;
                if (votos4 > maiorNumeroDeVotos) maiorNumeroDeVotos = votos4; //ver quem ganhou
                if (votos5 > maiorNumeroDeVotos) maiorNumeroDeVotos = votos5;


                System.out.println("================================");
                System.out.println("       RESULTADO DA VOTAÇÃO     "); //exibe o resultado se n tiver empate
                System.out.println("================================");
                double percentual1 = (double) votos1 / totalVotos * 100;
                double percentual2 = (double) votos2 / totalVotos * 100;
                double percentual3 = (double) votos3 / totalVotos * 100;
                double percentual4 = (double) votos4 / totalVotos * 100;
                double percentual5 = (double) votos5 / totalVotos * 100;

                System.out.println(candidatos[0] + " -> " + votos1 + " votos" + "\n" + "percentual de votos: ");
                System.out.printf("%.2f%%%n", percentual1);

                if (quantidadeCandidatos >= 2) {
                    System.out.println(candidatos[1] + " -> " + votos2 + " votos" + "\n" + "percentual de votos: ");
                    System.out.printf("%.2f%%%n", percentual2);
                }
                if (quantidadeCandidatos >= 3) {
                    System.out.println(candidatos[2] + " -> " + votos3 + " votos" + "\n" + "percentual de votos: ");
                    System.out.printf("%.2f%%%n", percentual3);
                }
                if (quantidadeCandidatos >= 4) {
                    System.out.println(candidatos[3] + " -> " + votos4 + " votos" + "\n" + "percentual de votos: ");
                    System.out.printf("%.2f%%%n", percentual4);
                }
                if (quantidadeCandidatos >= 5) {
                    System.out.println(candidatos[4] + " -> " + votos5 + " votos" + "\n" + "percentual de votos: ");
                    System.out.printf("%.2f%%%n", percentual5);
                }

                System.out.println("Total de votos: " + totalVotos);

//------------------------------------------------------------------------------------------

                int quantidadeEmpates = 0;
                if (votos1 == maiorNumeroDeVotos) quantidadeEmpates++;
                if (votos2 == maiorNumeroDeVotos && quantidadeCandidatos >= 2) quantidadeEmpates++;
                if (votos3 == maiorNumeroDeVotos && quantidadeCandidatos >= 3)
                    quantidadeEmpates++; //defin se foi empate
                if (votos4 == maiorNumeroDeVotos && quantidadeCandidatos >= 4) quantidadeEmpates++;
                if (votos5 == maiorNumeroDeVotos && quantidadeCandidatos >= 5) quantidadeEmpates++;


                if (quantidadeEmpates > 1) {
                    System.out.println("\n================================");
                    System.out.println("       RESULTADO COM EMPATE     ");
                    System.out.println("================================");
                    System.out.println("RESULTADO DA VOTAÇÃO");
                    System.out.println(candidatos[0] + " -> " + votos1 + " votos" + "\n" + "percentual de votos: ");
                    System.out.printf("%.2f%%%n", percentual1);

                    if (quantidadeCandidatos >= 2) {
                        System.out.println(candidatos[1] + " -> " + votos2 + " votos" + "\n" + "percentual de votos: ");
                        System.out.printf("%.2f%%%n", percentual2);
                    }
                    if (quantidadeCandidatos >= 3) {
                        System.out.println(candidatos[2] + " -> " + votos3 + " votos" + "\n" + "percentual de votos: ");
                        System.out.printf("%.2f%%%n", percentual3);
                    }
                    if (quantidadeCandidatos >= 4) {
                        System.out.println(candidatos[3] + " -> " + votos4 + " votos" + "\n" + "percentual de votos: ");
                        System.out.printf("%.2f%%%n", percentual4);
                    }
                    if (quantidadeCandidatos >= 5) {
                        System.out.println(candidatos[4] + " -> " + votos5 + " votos" + "\n" + "percentual de votos: ");
                        System.out.printf("%.2f%%%n", percentual5);
                    }
                    System.out.println("\nTotal de votos: " + totalVotos);
                    System.out.println("\nEMPATE ENTRE:");

                    if (votos1 == maiorNumeroDeVotos) System.out.println("- " + candidatos[0]);
                    if (votos2 == maiorNumeroDeVotos && quantidadeCandidatos >= 2)
                        System.out.println("- " + candidatos[1]);
                    if (votos3 == maiorNumeroDeVotos && quantidadeCandidatos >= 3)
                        System.out.println("- " + candidatos[2]);
                    if (votos4 == maiorNumeroDeVotos && quantidadeCandidatos >= 4)
                        System.out.println("- " + candidatos[3]);
                    if (votos5 == maiorNumeroDeVotos && quantidadeCandidatos >= 5)
                        System.out.println("- " + candidatos[4]);
                } else {
                    System.out.println("\nVencedor:"); //mostra quem empatou ou quam venceu
                    if (votos1 == maiorNumeroDeVotos) System.out.println(candidatos[0]);
                    if (votos2 == maiorNumeroDeVotos && quantidadeCandidatos >= 2) System.out.println(candidatos[1]);
                    if (votos3 == maiorNumeroDeVotos && quantidadeCandidatos >= 3) System.out.println(candidatos[2]);
                    if (votos4 == maiorNumeroDeVotos && quantidadeCandidatos >= 4) System.out.println(candidatos[3]);
                    if (votos5 == maiorNumeroDeVotos && quantidadeCandidatos >= 5) System.out.println(candidatos[4]);
                }
            }
            if (escolha == 4) {

                System.out.println("================================");
                System.out.println("       MATRIZ DE VOTOS    ");
                System.out.println("================================");
                System.out.print("\n");

                int quantidadeTurmas = 3;
                int capacidadeTotal = quantidadeTurmas * votosDisponiveís;
                if (totalVotos > capacidadeTotal) {
                    System.out.println("Erro: total de votos (" + totalVotos + ") é maior que a capacidade das turmas (" + capacidadeTotal + ").");
                } else {


                    int[] votosFlat = new int[capacidadeTotal];
                    int pos = 0;


                    for (int i = 0; i < votos1; i++) votosFlat[pos++] = 1;
                    for (int i = 0; i < votos2; i++) votosFlat[pos++] = 2;
                    for (int i = 0; i < votos3; i++) votosFlat[pos++] = 3;
                    for (int i = 0; i < votos4; i++) votosFlat[pos++] = 4;
                    for (int i = 0; i < votos5; i++) votosFlat[pos++] = 5;


                    for (int i = capacidadeTotal - 1; i > 0; i--) {
                        int j = random.nextInt(i + 1);
                        int temp = votosFlat[i];
                        votosFlat[i] = votosFlat[j];
                        votosFlat[j] = temp;
                    }


                    int[][] matriz = new int[quantidadeTurmas][votosDisponiveís];
                    int idx = 0;
                    for (int t = 0; t < quantidadeTurmas; t++) {
                        for (int v = 0; v < votosDisponiveís; v++) {
                            matriz[t][v] = votosFlat[idx];
                            idx++;
                        }
                    }


                    for (int t = 0; t < quantidadeTurmas; t++) {
                        System.out.print("Turma " + (t + 1) + ": ");
                        for (int v = 0; v < votosDisponiveís; v++) {
                            System.out.print(matriz[t][v] + " ");
                        }
                        System.out.println();
                    }


                    System.out.print("\n");
                    System.out.println("================================");
                    System.out.println("       ESTATISTICAS DE TURMA    ");
                    System.out.println("================================");
                    System.out.print("\n");

                    for (int c = 1; c <= quantidadeCandidatos; c++) {

                        System.out.println(candidatos[c - 1] + ":");

                        for (int t = 0; t < quantidadeTurmas; t++) {
                            int contagem = 0;
                            for (int v = 0; v < votosDisponiveís; v++) {
                                if (matriz[t][v] == c) contagem++;
                            }
                            System.out.println("  Recebeu " + contagem + " votos da turma " + (t + 1));
                        }
                        System.out.println();
                    }
                }
                }
                if (escolha == 5) {
                    try {
                        System.out.println("Deseja mesmo sair? Digite 1 para voltar e 0 para sair.");
                        escolha = teclado.nextInt();
                        if (escolha == 1) {
                        }
                        if (escolha == 0) {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Escreva direito por favor:");
                        escolha = teclado.nextInt();
                    }
                }



//------------------------------------------------------------------------------------------

        }while (escolha != 6) ;
        teclado.close();

    }
}
