/**
 * this class is able to take xml/hml or csv as file input format
 */
package workshop.panel.write;

import java.io.File;

import workshop.panel.glstring.GenerateGLstringFromHML;
import workshop.panel.write.GenerateCompareResultsTable;

/**
 * @author kazu
 * @version September 18 2019
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
		// if file extension is xml or hml
		if ((refFile.getName().contains(".xml")) || (refFile.getName().contains(".hml")) ||
				(refFile.getName().contains(".XML")) || (refFile.getName().contains(".HML"))) {
			new GenerateGLstringFromHML(ref, refcsv);
		}
		else {
			refcsv = ref;
		}
		
		String resultcsv = "resultGLstring.csv";
		File resultFile = new File(result);
		if ((resultFile.getName().contains(".xml")) || (resultFile.getName().contains(".hml")) ||
				(resultFile.getName().contains(".XML")) || (resultFile.getName().contains(".HML"))) {
			new GenerateGLstringFromHML(result, resultcsv);
		}
		else {
			resultcsv = result;
		}
		
		new GenerateCompareResultsTable(refcsv, resultcsv, scoreOutput);
		// added here to remove generated files on September 18 2019
		if (!refFile.delete()) {
			System.err.println("Could not delete " + refcsv);
		}
		if (!resultFile.delete()) {
			System.err.println("Could not delete " + resultcsv);
		}
	}

}
