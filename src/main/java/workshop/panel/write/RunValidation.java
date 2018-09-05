/**
 * This program takes validation directory as an argument
 */
package workshop.panel.write;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kazu
 * @version September 4 2018
 *
 */
public class RunValidation {

	/**
	 * 
	 */
	public RunValidation(String validation) {	// file path
		// TODO Auto-generated constructor stub
		// better handling for directories when trailing slash not provided
		validation = validation.endsWith("/") ? validation : (validation + "/");
		
		String ref = validation + "ref/";	// ref dir is required
		File file1 = new File (ref);
		if (!file1.exists()) {	// check the presence of ref directory
			System.err.println(file1.getAbsolutePath() + " does not exist! Bye!!!");
			System.exit(1);
		}
		String refFile = ref + file1.list()[0];	// only one file
//		System.out.println(refFile);
		
		
		String test = validation + "test/";	// test dir is required
		File file2 = new File (test);
		if (!file2.exists()) {	// check the presence of test directory
			System.err.println(file2.getAbsolutePath() + " does not exist! Bye!!!");
			System.exit(1);
		}
		String testFile = test + file2.list()[0];	// only one file
//		System.out.println(testFile);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();		
		String today = dateFormat.format(date);
		String result = validation + "TestResult_" + today + ".csv";
		
		new GenerateValidationScore(refFile, testFile, result);
	}

}
