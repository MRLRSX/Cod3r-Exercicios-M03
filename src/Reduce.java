import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Reduce {
   
	public static void main(String[] args) {
    
		List<Integer> nums = Arrays.asList(10, 10, 15, 100, 200, 50, 100, 200, 300, 400, 500, 600);
		BinaryOperator<Integer> soma = (x, y) -> x + y;
		Consumer<Object> print = System.out::println;
		Integer total = nums.stream().reduce(soma).get();
		System.out.println(total);
		
		Integer total02 = nums.stream().reduce(0, soma);
		System.out.println(total02);
		
		nums.stream().filter(n -> n > 100).reduce(soma).ifPresent(print);
	}
}
