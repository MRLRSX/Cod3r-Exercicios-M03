import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Program_03 {
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
		pessoas.sort((p1, p2) -> p1.getIdade().compareTo(p2.getIdade()));
		Consumer<String> print = System.out::println;
		
		Stream<Pessoa> pessoasStream = pessoas.stream();
		pessoasStream.forEach(System.out::println);
		
		Stream<String> langs = Stream.of("JAVA", "PYTHON", "GO", "JAVASCRIPT");
		langs.forEach(print);
		
		String[] maisLangs = {"PHP", "PERL", "LISP"};
		Arrays.stream(maisLangs).forEach(print);
		
		
		
		
		
	}
}
