package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaExamples {
	
	private enum Status {
		OPEN, CLOSED
	};
	
	private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }
        
        public Integer getPoints() {
            return points;
        }
        
        public Status getStatus() {
            return status;
        }
        
        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
	    
	public static void main(String[] args) {

		LambdaExamples test = new LambdaExamples();
		test.iteratingList();
		test.multiplyList();
		test.filterNames();
		test.sortElements();
		test.editElements();
		test.calculateSum();
		test.functionalInterface();
		test.joinStrings();
	}

	void iteratingList() {
		System.out.println("Java 8 Iteration");
		// Java 8 Iteration
		final String separator = ",";
		java.util.List<String> list2 = Arrays.asList("a", "b", "d");
		list2.forEach(e -> System.out.print(e + separator));
		System.out.println("\n----------------------");
	}

	void multiplyList() {
		System.out.println("Multiply the list elements");
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		System.out.println("Initial list items : " + list);
		List<Integer> newList = list.stream().map((Integer n) -> n * 5).collect(Collectors.toList());
		System.out.println("List after multipying with 5 : " + newList);
		System.out.println("----------------------");
	}

	void filterNames() {
		System.out.println("Filter example");
		List<String> names = Arrays.asList("laxman", "Aanand", "Santosh", "Siva", "Sudhi", "Venu", "Seshu", "Sruthi",
				"Ramaya");
		System.out.println("Initial Values : " + names);
		List<String> namesAfterFiler = names.stream().filter((String name) -> name.startsWith("S"))
				.filter((String name) -> name.endsWith("i")).collect(Collectors.toList());
		System.out.println("List after filtering, starts with 'S' and Ends with 'i' : " + namesAfterFiler);
		System.out.println("----------------------");
	}

	void sortElements() {
		System.out.println("Sorting the lements");
		List<Integer> list = Arrays.asList(3, 2, 1, 6, 5, 4);
		System.out.println("Initial list : " + list);
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List  : " + sortedList);
		List<Integer> sortedList2 = list.stream().sorted((Integer a, Integer b) -> b.compareTo(a))
				.collect(Collectors.toList());
		System.out.println("Sorted List in Reverse Order  : " + sortedList2);
		System.out.println("----------------------");
	}

	void editElements() {
		System.out.println("Editing the elements");
		List<String> lang = Arrays.asList("Java","Groovy","Python");
		System.out.println("Initial Values : "+lang);
		List<String> editedLang =lang.stream().map(LambdaExamples::editing).collect(Collectors.toList());
		System.out.println("List after editing : "+editedLang);
		System.out.println("----------------------");
	}
	
	static String editing(String lang) {
		return lang + "is a programming language";
	}
	
	void calculateSum() {
		System.out.println("Sum and percentage functions test");
		Collection<Task> tasks = getTasks();
		
		System.out.println("Initial Values : "+tasks);
		
		// Calculate total points of all active tasks using sum()
		final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();
		System.out.println( "Sum of open task points : " + totalPointsOfOpenTasks );
		
		//calculate total points
		double totalPoints = tasks.stream().map(Task::getPoints).reduce(0, Integer::sum);
		System.out.println("Sum of all task points : "+totalPoints);
		
		// Group tasks by their status
		final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
		System.out.println("Grouping the taks by status : "+ map );
		
		// Group tasks by their points
		final Map<Integer, List<Task>> map2 = tasks.stream().collect(Collectors.groupingBy(Task::getPoints));
		System.out.println("Grouping the taks by points : "+ map2 );
		
		// Calculate the weight of each tasks (as percent of total points) 
		final Collection< String > result = tasks
		    .stream()                                        // Stream< String >
		    .mapToInt( Task::getPoints )                     // IntStream
		    .asLongStream()                                  // LongStream
		    .mapToDouble( points -> points / totalPoints )   // DoubleStream
		    .boxed()                                         // Stream< Double >
		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
		    .collect( Collectors.toList() );                 // List< String > 
		        
		System.out.println("Weight of each task : "+ result );
		System.out.println("----------------------");
	}
	
	Collection<Task> getTasks() {
		return Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));
	}
	
	void functionalInterface()
	{
		Functional addition = (a, b) -> a + b;
		System.out.println("Addition of two numbers :"+addition.apply(5, 2));
		Functional subtraction = (a, b) -> a - b;
		System.out.println("Subtraction of two numbers :"+subtraction.apply(5, 2));
		Functional multiplication = (a, b) -> a * b;
		System.out.println("Multiplication of two numbers :"+multiplication.apply(5, 2));
		Functional division = (a, b) -> a / b;
		System.out.println("Division of two numbers :"+division.apply(5, 2));
		
		System.out.println("----------------------");
	}
	
	@FunctionalInterface
	public interface Functional {
	    Integer apply(Integer a,Integer b);
	}
	
	void joinStrings()
	{
		System.out.println("Concat Strings");
		List<String> names = Arrays.asList("siva","anand","sudhi");
		System.out.println("Initial values : "+names);
		
		System.out.println("String After concatination : " + names.stream().collect(Collectors.joining(",")));
		System.out.println("----------------------");
	}
}
