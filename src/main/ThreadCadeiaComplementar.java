package main;

public class ThreadCadeiaComplementar implements Runnable {
	private String nomeArquivo;
	ReplicacaoDNA rd;
	
	public ThreadCadeiaComplementar(String nomeArquivo, ReplicacaoDNA rd) {
		this.nomeArquivo = nomeArquivo;
		this.rd = rd;
	}
	
	@Override
	public void run() {
		rd.geraCadeiaComplementar(nomeArquivo);
	}
}
