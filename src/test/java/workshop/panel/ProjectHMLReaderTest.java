/**
 * 
 */
package workshop.panel;

import org.junit.Test;

import junit.framework.TestCase;
import workshop.panle.hml.StaxProjectHMLReader;

/**
 * @author kazu
 *
 */
public class ProjectHMLReaderTest extends TestCase {
	
	public static final String HML_TEST_FILE = "src/test/resources/test.xml";
	
	@Test
	public void testStaxProjectHMLReader() {
		
		StaxProjectHMLReader project = new StaxProjectHMLReader(HML_TEST_FILE);
		System.out.println(project.getDBversion());
		for (String sample : project.getSampleList()) {
			System.out.println(sample);
			for (String type : project.getSampleType().get(sample)) {
				System.out.println(type);
			}
		}
		
	}

}
