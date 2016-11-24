package foo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HelloWorldTest {

	private HelloWorld helloWorld = new HelloWorld();

	@Test
	public void testHelloWorld() {
		final String name = "Esteban";
		final String response = this.helloWorld.sayHello(name);
		Assert.assertEquals("Hello, Esteban!", response);
	}

}
