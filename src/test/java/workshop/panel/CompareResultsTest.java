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
	public static final String SUPPLEMENTAL_TEST_FILE = "gl_string_consensus_PT.csv";
	
	public void testCompareResults() {

		CompareResults cr = new CompareResults(SUPPLEMENTAL_TEST_FILE, SUPPLEMENTAL_TEST_FILE);
		
		System.out.print("Sample\tCategory\t");
		for (String locus : cr.getHLAgene().getGeneList()) {
			System.out.print(locus + "\t");
		}
		System.out.println();
		for (String sample : cr.getScoreBySample().keySet()) {
			for (String score : cr.getScoreBySample().get(sample).keySet()) {
				System.out.print(sample + "\t" + score + "\t");
				for (String locus : cr.getHLAgene().getGeneList()) {
					if (cr.getScoreBySample().get(sample).get(score).containsKey(locus)) {
						for (String type : cr.getScoreBySample().get(sample).get(score).get(locus)) {
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
