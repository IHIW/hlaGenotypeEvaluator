/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;
import workshop.panel.ambiguity.NoPhaseAmbiguity;

/**
 * @author kazu
 *
 */
public class NoPhaseAmbiguityTest extends TestCase {
	
	public void testNoPhaseAmbiguity() {
		System.out.println("NoPhaseAmbiguityTest");
		String str1 = "HLA-A*68:01:02:01+HLA-A*02:11:01";
		String str2 = "HLA-A*02:11:01+HLA-A*68:01:02";		
		NoPhaseAmbiguity npa1 = new NoPhaseAmbiguity(str1, str2, "HLA-A");
		System.out.println(npa1.getScore());
		
		str1 = "HLA-B*35:05:01+HLA-B*40:04";
		str2 = "HLA-B*35:05:01+HLA-B*40:04";		
		NoPhaseAmbiguity npa2 = new NoPhaseAmbiguity(str1, str2, "HLA-B");
		System.out.println(npa2.getScore());
		
		str1 = "HLA-B*15:26N+HLA-B*15:26N";
		str2 = "HLA-B*15:01:01:01/HLA-B*15:01:14/HLA-B*15:26N+HLA-B*15:01:01:01/HLA-B*15:01:14/HLA-B*15:26N";		
		NoPhaseAmbiguity npa3 = new NoPhaseAmbiguity(str1, str2, "HLA-B");
		System.out.println(npa3.getScore());
		
		str1 = "HLA-DQB1*02:01:01+HLA-DQB1*05:01:01:02/HLA-DQB1*05:01:01:03";
		str2 = "HLA-DQB1*02:01:01+HLA-DQB1*05:01:01:03";		
		NoPhaseAmbiguity npa4 = new NoPhaseAmbiguity(str1, str2, "HLA-DQB1");
		System.out.println(npa4.getScore());
		
		str1 = "HLA-DPB1*04:01:01:01+HLA-DPB1*04:01:01:01";	
		str2 = "HLA-DPB1*02:01:02+HLA-DPB1*04:01:01:01";			
		NoPhaseAmbiguity npa5 = new NoPhaseAmbiguity(str1, str2, "HLA-DPB1");
		System.out.println(npa5.getScore());
		
		str1 = "HLA-DRB1*15:01:01:01/HLA-DRB1*15:01:01:02/HLA-DRB1*15:01:01:03+HLA-DRB1*14:07:01";	
		str2 = "HLA-DRB1*15:01:01~HLA-DRB5*01:01:01+HLA-DRB1*14:07:01~HLA-DRB3*02:02:01";
		NoPhaseAmbiguity npa6 = new NoPhaseAmbiguity(str1, str2, "HLA-DRB1");
		System.out.println(npa6.getScore() + "\n");
	}

}
