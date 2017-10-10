package test.com.maxim.jms.adapter;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.maxim.jms.adapter.ConsumerAdapter;

public class ConsumerAdapterTest {

	private String json = "{vendorName:\"Microsoft\",firstName:\"Bob\",lastName:\"Smith\",address:\"123 Main St\",city:\"Tulsa\",state:\"OK\",zip:\"71345\",email:\"Bob@microsoft.com\",phoneNumber:\"734-123-4567\"}\r\n"
			+ "{vendorName:\"Microsofttest\",firstName:\"BobTest\",lastName:\"SmithTest\",address:\"123 Main test\",city:\"TulsaTest\",state:\"OKTest\",zip:\"71345Test\",email:\"Bob@microsoft.test\",phoneNumber:\"test-123-test\"}\r\n"
			+ "{vendorName:\\\"Microsofttest\\\",firstName:\\\"BobTest\\\",lastName:\\\"SmithTest\\\",address:\\\"123 Main test\\\",city:\\\"TulsaTest\\\",state:\\\"OKTest\\\",zip:\\\"71345Test\\\",email:\\\"Bob@microsoft.test\\\",phoneNumber:\\\"test-123-test\\\"}";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws UnknownHostException {
		ConsumerAdapter adapter = new ConsumerAdapter();
		adapter.sendToMongo(json);
		assertNotNull(json);
	}

}
