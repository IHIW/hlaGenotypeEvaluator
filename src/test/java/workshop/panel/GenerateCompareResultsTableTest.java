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
	public static final String SUPPLEMENTAL_TEST_FILE = "gl_string_consensus_PT.csv";
	
	public void testGenerateCompareResultsTable() {
		
		new GenerateCompareResultsTable(SUPPLEMENTAL_TEST_FILE, SUPPLEMENTAL_TEST_FILE, "TestResult.txt");
	}

}
