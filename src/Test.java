public class Test {
    public static void main(String[] args) throws Exception {
        Campeonato campeonato = new Campeonato();
        campeonato.adicionaClube("flamengo");
        campeonato.adicionaClube("Palmeiras");
        campeonato.adicionaClube("Vasco da Gama");
        campeonato.adicionaClube("Fluminense");

        campeonato.jogarCampeonato();
    }
}
