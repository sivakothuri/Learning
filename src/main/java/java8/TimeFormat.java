package java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeFormat {
	public static void main(String[] args) {

		// Get the local time based on the Zone
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

		// Format the date
		String dateString = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm a"));

		// Print the date
		System.out.println(dateString);
	}
}
