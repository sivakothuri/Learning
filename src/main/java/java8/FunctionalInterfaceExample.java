package java8;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {

		myInterface(() -> {
			System.out.println("FunctionalInterfaceExample.main()");
		});
	}

	static void myInterface(SingleMethod method) {
		method.print();
	}

	@FunctionalInterface
	interface SingleMethod {
		void print();
	}
}
