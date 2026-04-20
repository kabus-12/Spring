package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		int total = numbers.stream()
				.mapToInt(a->a)
				.sum();
		System.out.println(total);
		int total2 = numbers.stream()
				.filter(a -> a % 2 == 0)
				.mapToInt(a->a)
				.sum();
		System.out.println(total2);
	}
}
