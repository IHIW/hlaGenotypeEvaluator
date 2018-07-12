/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;
import workshop.panel.ambiguity.DecomposePhaseAmbiguity;

/**
 * @author kazu
 *
 */
public class DecomposePhaseAmbiguityTest extends TestCase {
	
	public void testDecomposePhaseAmbiguity() {
		String test = "HLA-DPB1*04:01:01:01+HLA-DPB1*04:02:01:01|HLA-DPB1*105:01+HLA-DPB1*126:01";
		DecomposePhaseAmbiguity dp = new DecomposePhaseAmbiguity(test);
		for (String str : dp.getGlStringSet()) {
			System.out.println(str);
		}
		
		for (String str : dp.getElements()) {
			System.out.println(str);
		}
		
		System.out.println();
		String test1 = "HLA-DPB1*04:01:01:01+HLA-DPB1*04:02:01:01";
		DecomposePhaseAmbiguity dp1 = new DecomposePhaseAmbiguity(test1);
		for (String str : dp1.getGlStringSet()) {
			System.out.println(str);
		}
		
		for (String str : dp1.getElements()) {
			System.out.println(str);
		}
	}

}
