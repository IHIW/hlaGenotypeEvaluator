/**
 * compare phase ambiguities
 */
package workshop.panel.ambiguity;



/**
 * @author kazu
 * @version January 18 2017
 *
 */
public class PhaseAmbiguity extends AmbiguityScore {


	/**
	 * @param locusType1
	 * @param locusType2
	 */
	public PhaseAmbiguity(String locusType1, String locusType2, String locus) {
		// TODO Auto-generated constructor stub
		super(locusType1, locusType2, locus);
		
		DecomposePhaseAmbiguity dp0 = new DecomposePhaseAmbiguity(locusType1);
		DecomposePhaseAmbiguity dp1 = new DecomposePhaseAmbiguity(locusType2);	
		int size = dp0.getGlStringSet().size();
		if (dp0.getElements().equals(dp1.getElements())) {	// compare element level
			identical = true;			
			for (int index = 0; index < size; index++) {
				if (index != 0) {
					score += "|";
				}				
				score += "Identical+Identical";
			}
		}
		else {	// not identical	
			int count = 0;
			for (String str1 : dp1.getGlStringSet()) {	// go through result GL string					
				if (count != 0) {
					score += "|";
				}
				
				String tmp = "";
				for (String str0 : dp0.getGlStringSet()) {
					NoPhaseAmbiguity npa = new NoPhaseAmbiguity(str1, str0, locus);
					if (!npa.getScore().contains("Discordant")) {	// not Discordant
						tmp = npa.getScore();
					}
				}
				
				if (tmp.length() == 0) {		// nothing is captured
					score += "Discordant+Discordant";
				}
				else {
					score += tmp;
				}
				count++;
			}						
		}			
	}

}
