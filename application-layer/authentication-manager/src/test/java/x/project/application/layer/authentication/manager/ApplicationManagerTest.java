package x.project.application.layer.authentication.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/authentication-manager.xml",
		"classpath:/spring/authentication-manager-test.xml" })
public class ApplicationManagerTest {
	
	@Test
	public void test() {
		Assert.fail("Not yet implemented");
	}

}
