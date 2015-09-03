package java8;

interface Clickable {
	default void click() {
		System.out.println("click");
	}

	default void print() {
		System.out.println("Clickable");
	}
}

interface Accessible {
	default void access() {
		System.out.println("access");
	}

	default void print() {
		System.out.println("Accessible");
	}
}

public class MultipleInheritance implements Clickable, Accessible {

	public void print() {
		Clickable.super.print();
		Accessible.super.print();
	}

	public static void main(String[] args) {
		MultipleInheritance button = new MultipleInheritance();
		button.click();
		button.access();
		button.print();
	}
}
