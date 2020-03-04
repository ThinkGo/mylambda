package mylambda.unit1;

public class Eg2TyperInterfrence {
	public static void main(String[] args) {
		StringUtilLambdaFunction strLambdaFun = s -> s.length();
		String str = "Kiran Chitrada";
		
		System.out.println("lenght of x="+str+"\t=" +strLambdaFun.getLength(str));
		
	}

}

interface StringUtilLambdaFunction {
	int getLength(String str);
}