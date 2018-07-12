/**
 * This class decompose a single phase ambiguity string to 
 * each possible ambiguity
 * and each element
 */
package workshop.panel.ambiguity;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author kazu
 * @version June 7 2016
 *
 */
public class DecomposePhaseAmbiguity {
	private Set<String> glStringSet;
	private Set<String> elements;

	/**
	 * 
	 */
	public DecomposePhaseAmbiguity(String str) {
		// TODO Auto-generated constructor stub
		glStringSet = new TreeSet<String>();
		elements = new TreeSet<String>();
		for (String str1 : str.split("\\|")) {	// escape is required
			glStringSet.add(str1);
			for (String str2 : str1.split("\\+")) {
				elements.add(str2);
			}
		}
		
	}
	
	public Set<String> getGlStringSet() {
		return glStringSet;
	}
	
	public Set<String> getElements() {
		return elements;
	}


}
