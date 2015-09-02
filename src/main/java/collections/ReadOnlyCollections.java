package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyCollections {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list = Collections.unmodifiableList(list);
		list.remove(2);
		
		System.out.println(list);
		

	}
}
