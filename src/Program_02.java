import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Program_02 {
	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader("C:\\Users\\lucas\\OneDrive\\Documentos\\produto.txt"))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] lines = line.split(",");
				produtos.add(new Produto(lines[0], Double.parseDouble(lines[1].trim()),
						Double.parseDouble(lines[2].trim())));
				line = bufferedReader.readLine();
			}
		} catch (IOException error) {
			error.printStackTrace();
		}
		
		System.out.println("\nUsando propria List ...");
		produtos.forEach(System.out::println);
		
		System.out.println("\nUsando Iterator ....");
		Iterator<Produto> produtosIterator = produtos.iterator();
		while(produtosIterator.hasNext()) {
			System.out.println(produtosIterator.next());
		}
		
		System.out.println("\nUsando Stream ...");
		Stream<Produto> produtosStream = produtos.stream();
		produtosStream.forEach(System.out::println);
 		
	}
}
