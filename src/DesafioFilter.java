import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DesafioFilter {
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
			System.out.println("FOR DE STREAM E MAIS LENTO QUE O FOR CONVENCIONAL \nTESTE FILTER #01");
			alunos.stream().filter(p -> p.getNome().equals("Anna Clara Bernardino")).forEach(p -> System.out
					.println(p.getNome() + " " + p.getNotas().stream().mapToDouble(c -> c).average().getAsDouble()));

			System.out.println("FOR DE STREAM E MAIS LENTO QUE O FOR CONVENCIONAL \nTESTE SEM FILTER #02");
			alunos.stream().forEach(p -> System.out
					.println(p.getNome() + " " + p.getNotas().stream().mapToDouble(c -> c).average().getAsDouble()));

		} catch (IOException error) {
			error.printStackTrace();
		}
	}

}
