package junit;

import java.util.Random;

import org.junit.rules.ExternalResource;

public class ExternalResourceRule extends ExternalResource {

	Integer number = 0;

	@Override
	protected void before() throws Throwable {
		number = new Random().nextInt();
		super.before();
	}

	@Override
	protected void after() {
		number = 0;
		super.after();
	}

	public Integer getRandomNumber() {
		return number;
	}
}
