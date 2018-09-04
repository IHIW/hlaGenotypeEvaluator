/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;
import workshop.panel.write.GenerateCompareResultsTable;

/**
 * @author kazu
 *
 */
public class GenerateCompareResultsTableTest extends TestCase {
	public static final String SUPPLEMENTAL_REF_FILE = "gl_string_consensus_PT.csv";
	public static final String SUPPLEMENTAL_RESULT_FILE = "gl_strings_TEST.csv";
	
	public void testGenerateCompareResultsTable() {
		
		new GenerateCompareResultsTable(SUPPLEMENTAL_REF_FILE, SUPPLEMENTAL_RESULT_FILE, "TestResult.csv");
	}

}
