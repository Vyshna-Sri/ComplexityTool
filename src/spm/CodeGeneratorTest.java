package spm;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodeGeneratorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CodeGenerator codeGenerator = new CodeGenerator();
		String code = null;
		
		try {
			code = codeGenerator.convert_file_to_string("C:/Users/Sanjula/Desktop/2018al/vhh.txt");
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
