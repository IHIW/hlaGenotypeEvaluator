/**
 * This program compares two types
 */
package workshop.panel;

import workshop.haplotype.family.ngs.NormalizePhaseAmbiguity;
import workshop.haplotype.gene.IsLocusDRB345;
import workshop.panel.ambiguity.AmbiguityScore;
import workshop.panel.ambiguity.NoPhaseAmbiguity;
import workshop.panel.ambiguity.PhaseAmbiguity;

/**
 * @author kazu
 * @version February 1 2017
 *
 */
public class CompareType extends AmbiguityScore {


	/**
	 * @param locusType1
	 * @param locusType2
	 */
	public CompareType(String locusType1, String locusType2, String locus) {
		// TODO Auto-generated constructor stub
		super(locusType1, locusType2, locus);
				
		// do not escape "\\|"
		// no phase ambiguity, both types are identical
		if (((!locusType1.contains("|")) && (!locusType2.contains("|"))) && (locusType1.equals(locusType2))) {						
			identical = true;
			IsLocusDRB345 drb345 = new IsLocusDRB345(locusType1);	// reference locusType
			if ((drb345.getTestResult()) && (!locusType1.contains("+"))) {
				score = "Identical";	// DRB345, one allele
			}
			else {
				score = "Identical+Identical";	// score both allele together
			}
			resultList.add(locusType2);
		}
		
		else {	// if not identical
			if ((!locusType1.contains("|")) && (!locusType2.contains("|"))) {	// not phase ambiguity
				NoPhaseAmbiguity npa = new NoPhaseAmbiguity(locusType1, locusType2, locus);
				score = npa.getScore();
				identical = npa.getIdentical();
				String type = "";
				int count = 0;
				for (String str : npa.getResultList()) {
					if (count != 0) {
						type += "+";
					}
					type += str;
					count++;
				}
				resultList.add(type);
				
			}
			else {	// ambiguity				
				NormalizePhaseAmbiguity convert1 = new NormalizePhaseAmbiguity(locusType1);
				NormalizePhaseAmbiguity convert2 = new NormalizePhaseAmbiguity(locusType2);
				if (convert1.getResolved() && convert2.getResolved()) {
					NoPhaseAmbiguity npa = new NoPhaseAmbiguity(convert1.getGlString(), convert2.getGlString(), locus);
					score = npa.getScore();
					identical = npa.getIdentical();
					String type = "";
					int count = 0;
					for (String str : npa.getResultList()) {
						if (count != 0) {
							type += "+";
						}
						type += str;
						count++;
					}
					resultList.add(type);
				}
			else {	// phase ambiguity
					PhaseAmbiguity pa = new PhaseAmbiguity(convert1.getGlString(), convert2.getGlString(), locus);
					score = pa.getScore();
					identical = pa.getIdentical();
					resultList.add(locusType2);	
				}
			}
		}
				
	}

}
