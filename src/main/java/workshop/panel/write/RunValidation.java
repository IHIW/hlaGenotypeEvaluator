/**
 * 
 */
package workshop.panel.write;

import java.io.File;

/**
 * @author kazu
 *
 */
public class RunValidation {

	/**
	 * 
	 */
	public RunValidation(String validation) {
		// TODO Auto-generated constructor stub
		// better handling for directories when trailing slash not provided
		validation = validation.endsWith("/") ? validation : (validation + "/");
		
		String ref = validation + "ref/";
		File file1 = new File (ref);
		if (!file1.exists()) {	// check the presence of collective directory
			System.err.println(file1.getAbsolutePath() + " does not exist! Bye!!!");
			System.exit(1);
		}
		String refFile = ref + file1.list()[0];
		System.out.println(refFile);
		
		
		String test = validation + "test/";
		File file2 = new File (test);
		if (!file2.exists()) {	// check the presence of collective directory
			System.err.println(file2.getAbsolutePath() + " does not exist! Bye!!!");
			System.exit(1);
		}
		String testFile = test + file2.list()[0];
		System.out.println(testFile);
		
		String result = validation + "TestResult.csv";
		
		new GenerateValidationScore(refFile, testFile, result);
	}

}
