/**
 * This is developed to compare HLA typings for two alleles that have 
 * no phase ambiguity
 * PROBLEM: REF homozygous & RESULT heterozygous => fixed
 * 
 */
package workshop.panel.ambiguity;

import java.util.Collections;
import java.util.List;

// import from haplObserve
import workshop.haplotype.family.ngs.CheckTwoFieldMatch;

/**
 * @author kazu
 * @version January 30 2017
 *
 */
public class NoPhaseAmbiguity extends AmbiguityScore {


	/**
	 * @param locusType1
	 * @param locusType2
	 */
	public NoPhaseAmbiguity(String locusType1, String locusType2, String locus) {
		// TODO Auto-generated constructor stub
		super(locusType1, locusType2, locus);
		
		locusType1 = locusType1.replaceAll("~", "+");		
		String [] tmpList1 = locusType1.split("\\+");		// separate two alleles	
		for (String str : tmpList1) {
			if (str.contains(locus)) {		// make sure to handle only target locus
				refList.add(str);
				refSet.add(str);
			}			
		}
		Collections.sort(refList);
		
		locusType2 = locusType2.replaceAll("~", "+");
		String [] tmpList2 = locusType2.split("\\+");		// separate two alleles				
		for (String str : tmpList2) {
			if (str.contains(locus)) {		// make sure to handle only target locus
				resultList.add(str);
				resultSet.add(str);
			}			
		}
		Collections.sort(resultList);
		
		String ref = "Ref";
		String result = "Result";
		
		//ref = "HLA-DPB1*04:01:01:01+HLA-DPB1*04:01:01:01";
		//result = "HLA-DPB1*02:01:02+HLA-DPB1*04:01:01:01";
		// to resolve this type of case
		if ((refSet.size() == 1) && (resultSet.size() != 1)) {
			goThroughLists(resultList, refList, result, ref);	// flip ref & result
		}
			
		else if (!refList.equals(resultList)) {	// not identical
			goThroughLists(refList, resultList, ref, result);
			
		}
		else {
			identical = true;
			score = "Identical+Identical";
		}
	}
	
	// go through list1 & list2, and decide how to classify
	public void goThroughLists(List<String> list1, List<String> list2, String ref, String result) {
		int index = 0;
		for (String type1 : list1) {	// go through reference
			int match = 0;
			for (String type2 : list2) {	// go through list2
				if (type1.equals(type2)) {
					match++;	// type1 is identical to type2
				}
			}
			if (match == 0) {	// no match
				int concordance = 0;
				boolean ambiguous = false;
				String ambRef = "";
				String ambResult = "";
				String unresolvedNull = "";
				for (String type2 : list2) {	// go through list2
					CheckTwoFieldMatch ctfm = new CheckTwoFieldMatch(type1, type2);	// check two fields
					if (ctfm.getResult()) {	// if two field concordance true
						concordance++;
						if ((type1.contains("/")) || (type2.contains("/"))) {	//allele1 or allele2 is ambiguous
							ambiguous = true;
							if (type1.contains("/")) {
								ambRef = "Amb" + ref;
							}
							if (type2.contains("/")) {
								ambResult = "Amb" + result;
								if (type2.contains("N")) {
									unresolvedNull = "UnresolvedNull";
								}
							}
						}															
					}
				}
										
				if (concordance == 0) {	//no concordance
					score += "Discordant";
				}
				else {			// concordance true			
					score += (ambiguous ? ambRef + unresolvedNull + ambResult + "Concordant" : "Concordant");						
				}						
			}
			else {	// match != 0
				score += "Identical";
			}
			if (index == 0) {
				score += "+";
			}
			index++;
		}
	}

}
