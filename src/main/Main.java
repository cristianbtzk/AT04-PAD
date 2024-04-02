package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	public static void main(String[] args) {
		
		
		ReplicacaoDNA rd= new ReplicacaoDNA();
		ThreadCadeiaComplementar t1 = new ThreadCadeiaComplementar("dna-0", rd);
		ThreadCadeiaComplementar t2 = new ThreadCadeiaComplementar("dna-1", rd);
		ThreadCadeiaComplementar t3 = new ThreadCadeiaComplementar("dna-2", rd);
		ThreadCadeiaComplementar t4 = new ThreadCadeiaComplementar("dna-3", rd);
		ThreadCadeiaComplementar t5 = new ThreadCadeiaComplementar("dna-4", rd);
		ThreadCadeiaComplementar t6 = new ThreadCadeiaComplementar("dna-5", rd);
		ThreadCadeiaComplementar t7 = new ThreadCadeiaComplementar("dna-6", rd);
		ThreadCadeiaComplementar t8 = new ThreadCadeiaComplementar("dna-7", rd);
		ThreadCadeiaComplementar t9 = new ThreadCadeiaComplementar("dna-8", rd);
		ThreadCadeiaComplementar t10 = new ThreadCadeiaComplementar("dna-9", rd);
		
		System.out.println("Início - executor");
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(t1);
		executorService.execute(t2);
		executorService.execute(t3);
		executorService.execute(t4);
		executorService.execute(t5);
		executorService.execute(t6);
		executorService.execute(t7);
		executorService.execute(t8);
		executorService.execute(t9);
		executorService.execute(t10);
		executorService.shutdown();
		System.out.println("Fim - executor");;
	}
}
