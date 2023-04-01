public class Clube {
	String nome;
	int pontos;
	int saldoGols;

    public Clube(String nomeClube){
        this.nome = nomeClube;
        this.pontos = 0;
        this.saldoGols = 0;
    }
	
	public void ganhar(int numeroGols) {
		this.saldoGols += numeroGols;
		this.pontos += 3;
	}
	
	public void empatar(int numeroGols) { 
        this.saldoGols += numeroGols;
		this.pontos += 1;	
	}
	
    public void perder(int numeroGols) { 
		this.saldoGols += numeroGols ;
	}

    public int mostraPontos(){
        return this.pontos;
    }

    public int mostraSaldoGols(){
        return this.saldoGols;
    }

}
