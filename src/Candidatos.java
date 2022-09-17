import java.util.Objects;

public class Candidatos implements Comparable<Candidatos> {

	private String name;
	private Integer votos;

	public Candidatos(String name, Integer votos) {

		this.name = name;
		this.votos = votos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, votos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidatos other = (Candidatos) obj;
		return Objects.equals(name, other.name) && Objects.equals(votos, other.votos);
	}
    
	public String toString() {
		return String.format("Candidato %s Votos: %d", name, votos);
	}
	
	
	@Override
	public int compareTo(Candidatos o1) {
		return this.votos.compareTo(o1.getVotos());
	}

}
