import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Program_05 {
	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader("C:\\Users\\lucas\\OneDrive\\Documentos\\Pessoa.txt"))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] lines = line.split(",");
				pessoas.add(new Pessoa(lines[0], lines[1].trim(), Integer.parseInt(lines[2].trim())));
				line = bufferedReader.readLine();
			}

		} catch (IOException error) {
			error.printStackTrace();
		}
		Function<Pessoa, String> amor = p -> p.getNome() + " VOCÊ E O AMOR DO PAPAI !!!! ";
		pessoas.stream().filter(p -> p.getNome().charAt(0) == 'A').map(amor).forEach(System.out::println);
	}
}
