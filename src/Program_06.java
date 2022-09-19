import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program_06 {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		Function<String, Double> converte = p -> Double.parseDouble(p.trim());

		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader("C:\\Users\\lucas\\OneDrive\\Documentos\\notas.txt"))) {
			String linha = bufferedReader.readLine();
			while (linha != null) {
				String[] linhas = linha.split(",");
				List<Double> nums = Arrays.asList(linhas[1], linhas[2], linhas[3], linhas[linhas.length - 1]).stream()
						.map(converte).collect(Collectors.toList());
				alunos.add(new Aluno(linhas[0], nums));

				linha = bufferedReader.readLine();
			}
		} catch (IOException error) {
			error.printStackTrace();
		}

		Function<Aluno, Double> media = m -> media(m.getNotas());

		Predicate<Aluno> aluno = a -> media(a.getNotas()) >= 7.0;
        Consumer<Object> print = System.out::println;
		
        Comparator<Aluno> melhorNota = (m1, m2) -> media(m1.getNotas()).compareTo(media(m2.getNotas()));
		
        alunos.stream().filter(aluno).max(melhorNota).ifPresent(print);
        alunos.stream().filter(aluno).min(melhorNota).ifPresent(print);
	}

	public static Double media(List<Double> nota) {
		return nota.stream().mapToDouble(p -> p).average().getAsDouble();
	}
}
