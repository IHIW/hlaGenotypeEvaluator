/**
 * 
 */
package workshop.panel.write;

import java.io.File;

import workshop.panel.glstring.GenerateGLstringFromHML;
import workshop.panel.write.GenerateCompareResultsTable;

/**
 * @author kazu
 *
 */
public class GenerateValidationScore {

	/**
	 * 
	 */
	public GenerateValidationScore(String ref, String result, String scoreOutput) {
		// TODO Auto-generated constructor stub
		
		String refcsv = "referenceGLstring.csv";
		File refFile = new File(ref);
		if ((refFile.getName().contains("xml")) || (refFile.getName().contains("hml"))) {
			new GenerateGLstringFromHML(ref, refcsv);
		}
		else {
			refcsv = ref;
		}
		
		String resultcsv = "resultGLstring.csv";
		File resultFile = new File(result);
		if ((resultFile.getName().contains("xml")) || (resultFile.getName().contains("hml"))) {
			new GenerateGLstringFromHML(result, resultcsv);
		}
		else {
			resultcsv = result;
		}
		
		new GenerateCompareResultsTable(refcsv, resultcsv, scoreOutput);
	}

}
