package mylambda.unit1;

public class Eg3Runnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("running... from Anon Inner class of Runnable implementation");
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(() -> System.out.println("running... from lambda expression"));
		
		t2.start();
	}
}
