public class Test {

    public static void main(String[] args) throws Exception {
        String[] nomesClubes = {
            "Atlético Mineiro",
            "Atlético Paranaense",  
            "Botafogo",
            "Vasco da Gama",
            "Corinthians",
            "Coritiba",
            "Cruzeiro",
            "Esporte Clube Juventude",
            "Figueirense",
            "Flamengo",
            "Fluminense",
            "Fortaleza",
            "Goiás",
            "Grêmio",
            "Guarani",
            "Internacional",
        };
        Campeonato campeonato = new Campeonato();

        for (int i = 0; i < nomesClubes.length; i++){
            campeonato.adicionaClube(nomesClubes[i]);
        }
        
        campeonato.jogarCampeonato();
    }
}
