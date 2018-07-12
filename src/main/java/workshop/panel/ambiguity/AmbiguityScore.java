/**
 * to reduce code redundancy in NoPhaseAmbiguity & PhaseAmbiguity classes
 */
package workshop.panel.ambiguity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author kazu
 * @version January 20 2017
 *
 */
public abstract class AmbiguityScore {
	protected boolean identical;
	protected String score;
	protected List<String> refList;
	protected Set<String> refSet;
	protected List<String> resultList;
	protected Set<String> resultSet;

	/**
	 * 
	 */
	public AmbiguityScore(String locusType1, String locusType2, String locus) {
		// TODO Auto-generated constructor stub
		identical = false;
		score = "";
		refList = new ArrayList<String>();
		refSet = new TreeSet<String>();
		resultList = new ArrayList<String>();
		resultSet = new TreeSet<String>();
	}
	
	public boolean getIdentical() {
		return identical;
	}
	
	public String getScore() {
		return score;
	}
	
	public List<String> getRefList() {
		return refList;
	}
	
	public List<String> getResultList() {
		return resultList;
	}

}
