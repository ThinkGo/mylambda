package mylambda.unit1;

	@FunctionalInterface
	public interface JavaHungry<A, B, C> {

	    public C apply(A a, B b);
	 
	    default void printString2() {
	        System.out.println("javahungry222");
	    }
	    default void printString() {
	        System.out.println("javahungry");
	    }
	}