/**
 * 
 */
package workshop.panel;

import junit.framework.TestCase;
import workshop.panel.ambiguity.PhaseAmbiguity;

/**
 * @author kazu
 *
 */
public class PhaseAmbiguityTest extends TestCase {
	
	public void testPhaseAmbiguity() {
		String str1 = "HLA-DPB1*04:01:01+HLA-DPB1*04:02:01|HLA-DPB1*105:01+HLA-DPB1*126:01";
		String str2 = "HLA-DPB1*105:01+HLA-DPB1*126:01|HLA-DPB1*04:01:01+HLA-DPB1*04:02:01";
		
		PhaseAmbiguity pa = new PhaseAmbiguity(str1, str2, "HLA-DPB1");
		System.out.println(pa.getIdentical());
		System.out.println(pa.getScore());
		
		str1 = "HLA-DPB1*03:01:01+HLA-DPB1*04:01:01:01|HLA-DPB1*124:01+HLA-DPB1*350:01";
		str2 = "HLA-DPB1*03:01:01+HLA-DPB1*04:01:01|HLA-DPB1*124:01+HLA-DPB1*350:01";
		PhaseAmbiguity pa1 = new PhaseAmbiguity(str1, str2, "HLA-DPB1");
		System.out.println(pa1.getIdentical());
		System.out.println(pa1.getScore());
		
		str1 = "HLA-DPB1*04:01:01+HLA-DPB1*13:01:01|HLA-DPB1*133:01+HLA-DPB1*350:01";
		str2 = "HLA-DPB1*04:01:01:01+HLA-DPB1*13:01:01|HLA-DPB1*04:01:01:01+HLA-DPB1*107:01|HLA-DPB1*133:01+HLA-DPB1*350:01";
		PhaseAmbiguity pa2 = new PhaseAmbiguity(str1, str2, "HLA-DPB1");
		System.out.println(pa2.getIdentical());
		System.out.println(pa2.getScore());
		
		str1 = "HLA-DRB4*01:03:01:01/HLA-DRB4*01:03:01:03+HLA-DRB4*01:03:02";
		str2 = 
		"HLA-DRB4*01:03:01:01+HLA-DRB4*01:03:01:02N|HLA-DRB4*01:03:01:01+HLA-DRB4*01:03:02|HLA-DRB4*01:03:01:03+HLA-DRB4*01:03:02|HLA-DRB4*01:03:01:02N+HLA-DRB4*01:03:01:03";
		PhaseAmbiguity pa3 = new PhaseAmbiguity(str1, str2, "HLA-DRB4");
		System.out.println(pa3.getIdentical());
		System.out.println(pa3.getScore());
		
		str1 = "HLA-DQB1*03:01:01:03+HLA-DQB1*03:01:01:03";	
		str2 = 
		"HLA-DQB1*03:01:01:02+HLA-DQB1*03:01:01:02|HLA-DQB1*03:01:01:02+HLA-DQB1*03:01:01:03|HLA-DQB1*03:01:01:03+HLA-DQB1*03:01:01:03";
		PhaseAmbiguity pa4 = new PhaseAmbiguity(str1, str2, "HLA-DQB1");
		System.out.println(pa4.getIdentical());
		System.out.println(pa4.getScore());
		
		str1 = "HLA-DQB1*06:03:01+HLA-DQB1*06:04:01";
		str2 = "HLA-DQB1*06:03:01+HLA-DQB1*06:04:01|HLA-DQB1*06:39+HLA-DQB1*06:41";
		PhaseAmbiguity pa5 = new PhaseAmbiguity(str1, str2, "HLA-DQB1");
		System.out.println(pa5.getIdentical());
		System.out.println(pa5.getScore());
	}

}
