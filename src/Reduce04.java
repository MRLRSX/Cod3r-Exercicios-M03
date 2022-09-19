import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reduce04 {
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

		Predicate<Aluno> aprovado = p -> media(p.getNotas()) >= 7;
		Function<Aluno, Double> apenasNota = p -> media(p.getNotas());
		BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);
		BinaryOperator<Media> combinarMedias = (m1, m2) -> Media.combinar(m1, m2);
		
		Media media = alunos.stream().filter(aprovado).map(apenasNota).reduce(new Media(), calcularMedia, combinarMedias);
		System.out.println(media.getValor());
		alunos.stream().filter(aprovado).map(apenasNota).forEach(System.out::println);
	}

	public static Double media(List<Double> nota) {
		return nota.stream().mapToDouble(p -> p).average().getAsDouble();
	}
	
	
}
