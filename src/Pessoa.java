import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private String CPF;
	private Integer idade;

	public Pessoa(String nome, String cPF, Integer idade) {
		this.nome = nome;
		CPF = cPF;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s  CPF: %s Idade: %d", nome, CPF, idade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CPF, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Pessoa o1) {
		
		return this.CPF.compareTo(o1.getCPF());
	}


	

}
