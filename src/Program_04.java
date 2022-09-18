import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


public class Program_04 {
	public static void main(String[] args) {
		Map<String, Integer> candidatos = new HashMap<>();

		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader("C:\\Users\\lucas\\OneDrive\\Documentos\\vota.txt"))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] lines = line.split(",");
				
				if(candidatos.containsKey(lines[0])) {
					int acumulador = candidatos.get(lines[0]);
					candidatos.put(lines[0], acumulador + Integer.parseInt(lines[1].trim()));					
				}else {
					candidatos.put(lines[0], Integer.parseInt(lines[1].trim()));
				}
				line = bufferedReader.readLine();
			}
			
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		candidatos.forEach((p1, p2) -> System.out.println(p1 + " " + p2));
		
		List<String> marcas = Arrays.asList("BMW", "AUDI", "HONDA", "FERRARI");
		Consumer<String> print = System.out::println;
		
		UnaryOperator<String> maiuscula = n -> n.toLowerCase();
		UnaryOperator<String> primeiraLetra = n -> n.charAt(0)+ "";
		UnaryOperator<String> grito = n -> n + "!!!";
		
	    marcas.stream().map(maiuscula).map(primeiraLetra).map(grito).forEach(print);
		
		
		
	}
}
