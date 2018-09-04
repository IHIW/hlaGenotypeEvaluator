/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;

/**
 * @author kazu
 *
 */
public class CompareResultsTest extends TestCase {
	public static final String SUPPLEMENTAL_REF_FILE = "gl_string_consensus_PT.csv";
	public static final String SUPPLEMENTAL_RESULT_FILE = "gl_strings_TEST.csv";
	
	public void testCompareResults() {

		CompareResults cr = new CompareResults(SUPPLEMENTAL_REF_FILE, SUPPLEMENTAL_RESULT_FILE);
		
		System.out.print("Sample\tCategory\t");
		for (String locus : cr.getHLAgene().getGeneList()) {
			System.out.print(locus + "\t");
		}
		System.out.println();
		for (String sample : cr.getScoreBySample().keySet()) {
			for (String category : cr.getCategory()) {
				System.out.print(sample + "\t" + category + "\t");
				for (String locus : cr.getHLAgene().getGeneList()) {
					if (cr.getScoreBySample().get(sample).get(category).containsKey(locus)) {
						for (String type : cr.getScoreBySample().get(sample).get(category).get(locus)) {
							System.out.print(type);
						}
					}
					System.out.print("\t");					
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
