import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
	public static void main(String[] args) {
        /**
         * 1. Número para string binaria => 
         * 2. Reveter a string 110 => 011
         * 3. Converter e voltar para inteiro
         * 
         * */
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Function<Integer, String> operacao01 = p -> Integer.toBinaryString(p);
        UnaryOperator<String> operacao02 = p -> new StringBuffer(p).reverse().toString();
        Function<String, Integer> operacao03 = p -> Integer.parseInt(p, 2);
        
        nums.stream().map(operacao01).map(operacao02).map(operacao03).forEach(System.out::println);
	}
}
