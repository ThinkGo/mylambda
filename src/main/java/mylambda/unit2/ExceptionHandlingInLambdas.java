//https://www.youtube.com/watch?v=SEGEbGoH4LI&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=17
package mylambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambdas {
	public static void main(String[] args) {
		int[] someNumbers = {1, 2, 3, 4, 5};
		int key = 4;
		int keyExeption = 0;
		//target //proces(someNumbers, key, __<comput with number,key >__)
		
		//1. tradtional
		process(someNumbers, key);

		//2. lambda > process(someNumbers, key, mylambda);
		process(someNumbers, key, (x, y) -> System.out.println(x/y));
		
		//3. won't work
		//process(someNumbers, keyExeption , (x, y) -> System.out.println(x/y));
		
		//4. better than 3 but still verbose instead singleline lambda 
		process(someNumbers, keyExeption , (x, y) -> {
			try {
				System.out.println(x/y);
			} catch (Exception e) {
				System.out.println("verbose coding"+e.getMessage());
			}
		});
		
		//5. instead inline try wraper the whole function into another lambda
		//let hand side is input/output both are BiConsumer FunInt so write a wrapper fun of same biConsumer
/*		BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
			try {
				System.out.println(x/y);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		process(someNumbers, keyExeption , biConsumer);
*/
		BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x/y);
		process(someNumbers, keyExeption, wrapperLambda(biConsumer));//later you can inline

	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		//don't implement behavour here but pass asis/original behaviour that was input input
		//return (a, b) -> biConsumer.accept(a, b); 
		//but Just hanlde exception only. 
		return (x, y) -> {
			try {
				biConsumer.accept(x, y);
			} catch (Exception e) {
				System.out.println("decent singline calling program"+e.getMessage());
			}
		}; 
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : someNumbers) {
			biConsumer.accept(i, key);
		}
	}

	private static void process(int[] someNumbers, int key) {
		for (int i : someNumbers) {
			System.out.println(i/key);
		}
	}
}
