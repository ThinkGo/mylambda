package mylambda.unit1;

public class Eg1LambdasVsInterfaceImplementations {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.perform();
		
		Greetings_AnnotatedAsFi lambdaGreeting = () -> System.out.println("hello world");
		lambdaGreeting.perform();

	}

}
