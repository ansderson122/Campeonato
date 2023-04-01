import java.util.Random;

public class Campeonato {
    Clube[] clubes = new Clube[20];
    int qtdClubes = 0;
    Random gerador = new Random();

    public void adicionaClube(String nomeClube){
        Clube clube = new Clube(nomeClube);
        clubes[qtdClubes] = clube;
        qtdClubes++; 
    }

    public void jogarCampeonato(){
        int numeroPartida =qtdClubes * (qtdClubes - 1);
        int[][] jogos = organizaPartidas(numeroPartida);
        //mostraArray(jogos, numeroPartida);

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

                String texto = "O " + m.nome + " ganho o partida contra o " + v.nome + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }else if(numeroGols2 >numeroGols1){
                v.ganhar(numeroGols2 - numeroGols1);
                m.perder(numeroGols1 - numeroGols2);

                String texto = "O " + v.nome + " ganho o partida contra o " + m.nome + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }else {
                m.empatar(numeroGols1 - numeroGols2);
                v.empatar(numeroGols2 - numeroGols1);

                String texto = "O " + v.nome + " empatou partida contra o " + m.nome + " de " + numeroGols1 + " x " + numeroGols2;
                System.out.println(texto);
            }
    }

    private void getClassificacao(){
        Clube aux;
        // Bubble Sort
        for(int i = 0; i < qtdClubes; i++){
            for(int j = 0; j < qtdClubes - 1 ; j++){
                if(clubes[j].mostraPontos() > clubes[j + 1].mostraPontos()){
                    aux = clubes[j];
                    clubes[j] = clubes[j+1];
                    clubes[j+1] = aux;
                }else if(clubes[j].mostraPontos() == clubes[j + 1].mostraPontos()){
                    if (clubes[j].mostraSaldoGols() > clubes[j + 1].mostraSaldoGols()){
                        aux = clubes[j];
                        clubes[j] = clubes[j+1];
                        clubes[j+1] = aux;
                    }
                }
            }
        }
    }

    private void getCampeao(){
        String vitoriaTexto = "O CAMPEÃO é " + clubes[qtdClubes-1].nome;
        System.out.println("");
        System.out.println(vitoriaTexto);
    }

    private void mostraResultado(){
        System.out.println("");
        System.out.println("O resultado final foi:");
        for(int i = qtdClubes - 1; i >= 0;i--){
            String texto = "O " + clubes[i].nome + " fez " + clubes[i].mostraPontos() + " pontos, com o total de " + clubes[i].mostraSaldoGols() + " de gols";
            System.out.println(texto);
        }
    }



}
