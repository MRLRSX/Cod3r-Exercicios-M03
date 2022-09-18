import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce02 {
	public static void main(String[] args) {
		Aluno02 aluno01 = new Aluno02("LUCAS ROCHA", 8.1);
		Aluno02 aluno02 = new Aluno02("ANNA CLARA", 10.0);
		Aluno02 aluno03 = new Aluno02("HELENA RODRIGUES", 8.1);
		Aluno02 aluno04 = new Aluno02("SAMUEL ROCHA", 7.1);
		Aluno02 aluno05 = new Aluno02("ELISA ROCHA", 8.1);
		Aluno02 aluno06 = new Aluno02("THIAGO", 7.1);
		List<Aluno02> listaAluno = Arrays.asList(aluno01, aluno02, aluno03, aluno04, aluno05, aluno06);
      
		Function<Aluno02, Double> apenasNotas = a -> a.getNota();
		Predicate<Aluno02> aprovado = p -> p.getNota() >= 7.0;
		BinaryOperator<Double> somatorio = (x, y) -> x + y;
		Consumer<Object> print = System.out::println;
		
		listaAluno.stream().filter(aprovado).map(apenasNotas).reduce(somatorio).ifPresent(print);
		
		
		
		
	}
}
