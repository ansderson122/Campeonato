import java.util.Random;

public class Campeonato {
    private Clube[] clubes = new Clube[20];
    private int qtdClubes = 0;
    private Random gerador = new Random();

    public void adicionaClube(String nomeClube){
        Clube clube = new Clube(nomeClube);
        clubes[qtdClubes] = clube;
        qtdClubes++; 
    }

    public void jogarCampeonato(){
        int numeroPartida =qtdClubes * (qtdClubes - 1);
        int[][] jogos = organizaPartidas(numeroPartida);

        for (int i = 0; i < numeroPartida; i++){
            jogarPartida(clubes[jogos[i][0]], clubes[jogos[i][1]]);
        }

        getClassificacao();
        getCampeao();
        mostraResultado();
    }

    private int[][] organizaPartidas(int numeroPartida){
        int[][] jogos = new int[numeroPartida][2];

        //ida
        int jogoIndex = 0 ;
        for(int i=0; i < qtdClubes - 1; i++){
            for (int j = i + 1; j < qtdClubes;j++ ){
                jogos[jogoIndex][0] = i;
                jogos[jogoIndex][1] = j;
                jogoIndex++;
            }
        }

        //volto
           for(int i=0; i < qtdClubes - 1; i++){
            for (int j = i + 1; j < qtdClubes;j++ ){
                jogos[jogoIndex][0] = j;
                jogos[jogoIndex][1] = i;
                jogoIndex++;
            }
        }
        return jogos;
    }

    private void jogarPartida(Clube m, Clube v){
            int numeroGols1 =  gerador.nextInt(5);
            int numeroGols2 =  gerador.nextInt(5);

            if (numeroGols1 > numeroGols2){
                m.ganhar(numeroGols1 - numeroGols2);
                v.perder(numeroGols2 - numeroGols1);

                String texto = "O " + m.NOME + " ganhou o partida contra o " + v.NOME + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }else if(numeroGols2 >numeroGols1){
                v.ganhar(numeroGols2 - numeroGols1);
                m.perder(numeroGols1 - numeroGols2);

                String texto = "O " + v.NOME + " ganhou o partida contra o " + m.NOME + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }else {
                m.empatar(numeroGols1 - numeroGols2);
                v.empatar(numeroGols2 - numeroGols1);

                String texto = "O " + v.NOME + " empatou partida contra o " + m.NOME + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }
    }

    private void getClassificacao(){
        Clube aux;
        // Bubble Sort
        for(int i = 0; i < qtdClubes; i++){
            for(int j = 0; j < qtdClubes - 1 ; j++){
                if(clubes[j].getPontos() > clubes[j + 1].getPontos()){
                    aux = clubes[j];
                    clubes[j] = clubes[j+1];
                    clubes[j+1] = aux;
                }else if(clubes[j].getPontos() == clubes[j + 1].getPontos()){
                    if (clubes[j].getSaldoGols() > clubes[j + 1].getSaldoGols()){
                        aux = clubes[j];
                        clubes[j] = clubes[j+1];
                        clubes[j+1] = aux;
                    }
                }
            }
        }
    }

    private void getCampeao(){
        String vitoriaTexto = "O CAMPEÃO é " + clubes[qtdClubes-1].NOME;
        System.out.println("");
        System.out.println(vitoriaTexto);
    }

    private void mostraResultado(){
        System.out.println("");
        System.out.println("O resultado final foi:");
        for(int i = qtdClubes - 1; i >= 0;i--){
            String texto = "O " + clubes[i].NOME + " fez " + clubes[i].getPontos() + " pontos, com o saldo total de gols: " + clubes[i].getSaldoGols();
            System.out.println(texto);
        }
    }



}
