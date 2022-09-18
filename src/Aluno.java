import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Aluno {
	private String nome;
	private List<Double> notas = new ArrayList<>();

	public Aluno(String nome, List<Double> notas) {
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Double> getNotas() {
		return notas;
	}
     
	public Double media() {
		return notas.stream().mapToDouble(p -> p).average().getAsDouble();
	}
	

}
