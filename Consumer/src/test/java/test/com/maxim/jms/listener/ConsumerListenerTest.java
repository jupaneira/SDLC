package test.com.maxim.jms.listener;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maxim.jms.listener.ConsumerListener;

public class ConsumerListenerTest {

	private TextMessage message;
	private ApplicationContext context;
	private ConsumerListener listener;
	private String json = "{vendorName:\"Microsoft3\",firstName:\"Bob3\",lastName:\"Smith3\",address:\"123 Main St\",city:\"Tulsa3\",state:\"OK\",zip:\"71345\",email:\"Bob@microsoft.com\",phoneNumber:\"734-123-4567\"}\r\n"
			+ "{vendorName:\"Microsofttest\",firstName:\"BobTest\",lastName:\"SmithTest\",address:\"123 Main test\",city:\"TulsaTest\",state:\"OKTest\",zip:\"71345Test\",email:\"Bob@microsoft.test\",phoneNumber:\"test-123-test\"}\r\n"
			+ "{vendorName:\\\"Microsofttest\\\",firstName:\\\"BobTest\\\",lastName:\\\"SmithTest\\\",address:\\\"123 Main test\\\",city:\\\"TulsaTest\\\",state:\\\"OKTest\\\",zip:\\\"71345Test\\\",email:\\\"Bob@microsoft.test\\\",phoneNumber:\\\"test-123-test\\\"}";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
		listener = (ConsumerListener) context.getBean("consumerListener");
		message = createMock(TextMessage.class);
	}

	@After
	public void tearDown() throws Exception {
		((ConfigurableApplicationContext) context).close();
	}

	@Test
	public void testOnMessage() throws JMSException {
		expect(message.getText()).andReturn(json);
		replay(message);
		listener.onMessage(message);
		verify(message);
	}

}
