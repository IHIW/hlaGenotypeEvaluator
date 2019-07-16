/**
 * This program was developed to compare results reference HLA typing vs. results from other lab
 * Input file requires header
 */
package workshop.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import workshop.haplotype.family.organize.OrganizeBySample;
import workshop.haplotype.gene.HLAgene;
import workshop.haplotype.organize.file.ChooseElement;
import workshop.haplotype.utilities.FileUtilities;
import workshop.panel.glstring.ChooseElementForGLString;
import workshop.panel.glstring.OrganizeTypesBySampleFromGLString;



/**
 * @author kazu
 * @version January 19 2017
 *
 */
public class CompareResults {
	// sample ID
	// ref, result, score
	// locus
	// type
	private Map<String, Map<String, Map<String, List<String>>>>scoreBySample;
	private Set<String> locusSet;	// not all lab test all loci
	private static final String [] category = {"Ref", "Result", "Score"};


	/**
	 * 
	 */
	public CompareResults(String refFile, String resultFile) {
		// TODO Auto-generated constructor stub
		scoreBySample = new TreeMap<String, Map<String, Map<String, List<String>>>>();
		locusSet = new TreeSet<String>();
				
		ChooseElement refCe = new ChooseElementForGLString(FileUtilities.readFile(refFile));
		OrganizeBySample refOs = new OrganizeTypesBySampleFromGLString(refCe);	// start from glstring
		
		ChooseElement resultCe = new ChooseElementForGLString(FileUtilities.readFile(resultFile));
		OrganizeBySample resultOs = new OrganizeTypesBySampleFromGLString(resultCe);	
		
		for (String sample : resultOs.getSampleList()) {	// go through result sample list
			if (!refOs.getHlaTypeBySample().containsKey(sample)) {
				System.err.println(sample + " does not exist in the reference!!!");
			}
			else {
				// result sample are part of reference sample
				Map<String, Map<String, List<String>>> diff = new HashMap<String, Map<String, List<String>>>();
				Map<String, List<String>> tmpMap = new HashMap<String, List<String>>();
				Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
				for (String locus : this.getHLAgene().getGeneList()) {		// go through gene	
								
					if (resultOs.getHlaTypeBySample().get(sample).containsKey(locus)) {
						locusSet.add(locus);
						List<String> tmpList = new ArrayList<String>();
						List<String> resultList = new ArrayList<String>();
						
						if (refOs.getHlaTypeBySample().get(sample).containsKey(locus)) {						
							for (String refType : refOs.getHlaTypeBySample().get(sample).get(locus)) {	// go through refType
								for (String resultType : resultOs.getHlaTypeBySample().get(sample).get(locus)) {	// go through result
									// compare result vs ref types
									CompareType ct = new CompareType(refType, resultType, locus);	// IMPORTANT LINE
									if (ct.getScore().endsWith("+")) {
										tmpList.add(ct.getScore().substring(0, ct.getScore().length() - 1));
									}
									else {
										tmpList.add(ct.getScore());
									}								
									resultList.addAll(ct.getResultList());
								}	
							}
						}							
						tmpMap.put(locus, tmpList);	
						resultMap.put(locus, resultList);
					}
					// No result, but ref present
					else if (refOs.getHlaTypeBySample().get(sample).containsKey(locus)) {
							List<String> tmpList = new ArrayList<String>();
							tmpList.add("Discordant");
							tmpMap.put(locus, tmpList);
					}	
								
				}
				diff.put("Ref", refOs.getHlaTypeBySample().get(sample));
				diff.put("Result", resultMap);
				diff.put("Score", tmpMap);
				scoreBySample.put(sample, diff);
			}						
		}		
	}
	
	public Map<String, Map<String, Map<String, List<String>>>> getScoreBySample() {
		return scoreBySample;
	}
	
	public Set<String> getLocusSet() {
		return locusSet;
	}
	
	public HLAgene getHLAgene() {
		HLAgene hlaGene = new HLAgene();
		return hlaGene;
	}
	
	public String [] getCategory() {
		return category;
	}

}
