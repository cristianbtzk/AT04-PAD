package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplicacaoDNA {

	public boolean cadeiaValida(char[] cadeia) {
		for (char l : cadeia) {
			if (l != 'A' && l != 'C' && l != 'G' && l != 'T')
				return false;
		}
		return true;
	}

	public String cadeiaComplementar(char[] cadeia) {
		String cadeiaComplementar = "";
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('A', 'T');
		map.put('T', 'A');
		map.put('G', 'C');
		map.put('C', 'G');

		for (char c : cadeia) {
			cadeiaComplementar += map.get(c);
		}

		return cadeiaComplementar;
	}

	public void geraCadeiaComplementar(String nomeArquivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/" + nomeArquivo + ".txt"));
			PrintWriter writer = new PrintWriter("src/main/" + nomeArquivo + "_resultado.txt", "UTF-8");
			String line = br.readLine();
			int currentLine = 0;

			List<String> linhasInvalidas = new ArrayList<String>();

			while (line != null) {
				currentLine++;
				char[] chars = line.toCharArray();

				if (!cadeiaValida(chars)) {
					writer.println("****FITA INVALIDA - " + line);
					linhasInvalidas.add(Integer.toString(currentLine));
				} else {
					String cadeiaComplementar = cadeiaComplementar(chars);
					writer.println(cadeiaComplementar);
				}

				line = br.readLine();
			}
			System.out.println("Arquivo " + nomeArquivo);
			System.out.println("O total de fitas é " + currentLine);
			System.out.println("O total de fitas válidas é " + (currentLine - linhasInvalidas.size()));
			System.out.println("O total de fitas inválidas é " + linhasInvalidas.size());
			if (linhasInvalidas.size() > 0) {
				System.out.println("As linhas inválidas são: [" + String.join(", ", linhasInvalidas) + "]");
			}
			System.out.println("Fim - " + nomeArquivo);

			br.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
