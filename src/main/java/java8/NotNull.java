package java8;

import java.util.Objects;

public class NotNull {
	
	public static void main(String[] args) {
		String name = null;
		Objects.requireNonNull(name, ()->{
			return "Name should not be null";});
	}

}
