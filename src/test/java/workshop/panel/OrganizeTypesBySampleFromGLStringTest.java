/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;
import workshop.haplotype.family.organize.OrganizeBySample;
import workshop.haplotype.organize.file.ChooseElement;
import workshop.panel.glstring.ChooseElementForGLString;
import workshop.panel.glstring.OrganizeTypesBySampleFromGLString;

/**
 * @author kazu
 *
 */
public class OrganizeTypesBySampleFromGLStringTest extends TestCase {
	public static final String SUPPLEMENTAL_TEST_FILE = "gl_string_consensus_PT.csv";
	
	public void testOrganizeTypesBySampleFromGLString() {
		ChooseElement ce = new ChooseElementForGLString(SUPPLEMENTAL_TEST_FILE);
		OrganizeBySample os = new OrganizeTypesBySampleFromGLString(ce);
		for (String sample : os.getSampleList()) {
			System.out.print(sample + "\t");
			for (String locus : os.getHlaTypeBySample().get(sample).keySet()) {
//				System.out.print(locus + "\t");
				if (os.getHlaTypeBySample().get(sample).get(locus).isEmpty()) {
					System.out.print("\t\t\t");
				}
				for (String type : os.getHlaTypeBySample().get(sample).get(locus)) {
					System.out.print(type + "\t\t");
				}
			}
			System.out.println();
		}		
	}

}
