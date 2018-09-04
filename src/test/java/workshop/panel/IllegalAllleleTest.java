/**
 * 
 */
package workshop.panel;

import org.junit.Test;

import junit.framework.TestCase;
import workshop.panle.hml.IllegalAllele;

/**
 * @author kazu
 *
 */
public class IllegalAllleleTest extends TestCase {

	@Test
	public void test() {
		IllegalAllele ia = new IllegalAllele();
		
		for (String allele : ia.getSuggestedAllele().keySet()) {
			System.out.println(allele + " -> " + ia.getSuggestedAllele().get(allele));
		}
	
	}

}
