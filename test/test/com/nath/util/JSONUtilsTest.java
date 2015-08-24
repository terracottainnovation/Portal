package test.com.nath.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nath.util.JSONUtils;




public class JSONUtilsTest {
	@Test
	public void doTest(){
		JSONUtils jsonUtils = new JSONUtils();
		TestObject testObject = new TestObject();
		testObject.setName("RAM");
		testObject.setAge(23);
		testObject.setRate(5.6f);
		 String jonString = jsonUtils.convertToJson(testObject);

		 TestObject testObjectReformed = (TestObject) jsonUtils.convertToObject(jonString,TestObject.class);
		 
		 assertEquals(testObject.getName(), testObjectReformed.getName());
		 assertEquals(testObject.getAge(), testObjectReformed.getAge());
		
	}

}
