public class Clube {
	final public String NOME;
	private int pontos;
	private int saldoGols;

    public Clube(String nomeClube){
        this.NOME = nomeClube;
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

    public int getPontos(){
        return this.pontos;
    }

    public int getSaldoGols(){
        return this.saldoGols;
    }

}
