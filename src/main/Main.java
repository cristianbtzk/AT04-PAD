package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	public static void main(String[] args) {
		
		String[] filenames = {"dna-0", "dna-1", "dna-2", "dna-3", "dna-4", "dna-5", "dna-6", "dna-7", "dna-8", "dna-9"};
		
		
		ReplicacaoDNA rd= new ReplicacaoDNA();
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (String file: filenames) {
			ThreadCadeiaComplementar t = new ThreadCadeiaComplementar(file, rd);
			executorService.execute(t);
		}
		
	}
}
