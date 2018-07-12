/**
 * 
 */
package workshop.panel;

import java.util.List;

import junit.framework.TestCase;
import workshop.haplotype.organize.file.ChooseElement;
import workshop.panel.glstring.ChooseElementForGLString;

/**
 * @author kazu
 *
 */
public class ChooseElementForGLStringTest extends TestCase {
	public static final String SUPPLEMENTAL_TEST_FILE = "gl_string_consensus_PT.csv";
	
	public void testChooseElementForGLString() {
		ChooseElement ce = new ChooseElementForGLString(SUPPLEMENTAL_TEST_FILE);		
		for (List<String> tmpList : ce.getChosenElement()) {
			for (String str : tmpList) {
				System.out.println(str);				
			}
		}
	}

}
