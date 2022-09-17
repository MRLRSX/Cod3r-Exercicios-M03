import java.util.Objects;

public class Produto implements Comparable<Produto> {
	private String nome;
	private Double preco;
	private Double desconto;

	public Produto(String nome, Double preco, Double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return String.format("%s  US$ %.2f US$ %.2f FINAL: US$ %.2f", nome, preco, preco * (desconto),
				preco * (1 - desconto));
	}

	@Override
	public int hashCode() {
		return Objects.hash(desconto, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(desconto, other.desconto) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}

	@Override
	public int compareTo(Produto o1) {
		// TODO Auto-generated method stub
		return this.preco.compareTo(o1.getPreco());
	}

}
