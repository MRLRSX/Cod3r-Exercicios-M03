import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program_01 {
	public static void main(String[] args) {
       
		List<Produto> produtos = new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lucas\\OneDrive\\Documentos\\produto.txt"))){
			String line = bufferedReader.readLine();
			while(line != null) {
				String[] lines = line.split(",");
				produtos.add(new Produto(lines[0], Double.parseDouble(lines[1].trim()), Double.parseDouble(lines[2].trim())));
				line = bufferedReader.readLine();
			}
		}catch(IOException error) {
			error.printStackTrace();
		}
		
		System.out.println("EXEMPLO #1 CLASSE ANONIMA \n");
		
		Collections.sort(produtos, new Comparator<Produto>(){
			public int compare(Produto p1, Produto p2){
				return p1.getPreco().compareTo(p2.getPreco());
			}
		});
		produtos.forEach(System.out::println);
		
		System.out.println("\n\nExemplo #2 METHOD REFERENCE \n\n");
		
		Collections.sort(produtos, Comparator.comparing(Produto::getPreco));
		
		System.out.println("\n\nEXEMPLO IMPLEMENTANDO COMPARABLE #3");
		Collections.sort(produtos);
		produtos.forEach(System.out::println);
		
		produtos.sort(new Comparator<Produto>(){
			public int compare(Produto p1, Produto p2) {
				return p1.getPreco().compareTo(p2.getPreco());
			}
		});
		
		produtos.sort((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));
	}
}
