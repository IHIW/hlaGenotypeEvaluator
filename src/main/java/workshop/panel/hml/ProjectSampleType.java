/**
 * This the second layer above StaxProjectHMLReader
 * allele validation step was added on May 3 2017
 */
package workshop.panel.hml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import workshop.haplotype.gene.HLAgene;
import workshop.haplotype.sirona.RemoveNotation;

/**
 * @author kazu
 *
 */
public class ProjectSampleType extends StaxProjectHMLReader {
	// key: sample
	// key: gene
	// value: typeLIst
	private Map<String, Map<String, List<String>>> sampleGeneType;
	private HLAgene hlaGene = new HLAgene();

	/**
	 * @param filePath
	 */
	public ProjectSampleType(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
		hlaGene = new HLAgene();
		sampleGeneType = new HashMap<String, Map<String, List<String>>>();
		List<String> tmpSampleList = new ArrayList<String>();
		String regex = "DRB[3-5]";
		Pattern pattern = Pattern.compile(regex);
				
		for (String sample : sampleList) {	// go through sampleList
			Map<String, List<String>> tmpMap = new HashMap<String, List<String>>();
			
			for (String type : sampleType.get(sample)) {	// go through type
				List<String> tmpList = new ArrayList<String>();
				Matcher matcher = pattern.matcher(type);				
				if (matcher.find()) {		// if DRB345			
					for (String str : type.split("\\^")) {	// escape character was needed
						tmpList.add(str);
					}
				}
				else {	// not DRB345
					tmpList.add(type);
				}		
								
				for (String gene : hlaGene.getGeneList()) {	// go through gene
					List<String> list = new ArrayList<String>();
					for (String tmpType : tmpList) {	// go through type, but both alleles						
						// from here to validate allele
						String [] alleleList = tmpType.split("\\+");	// separate alleles
						for (String allele : alleleList) {
							try {
								new ValidAlleleTest(sample, allele);	// test allele
							}
							catch (IllegalAlleleException iae) {
								iae.printStackTrace();		
								System.err.println("Terminating program!");
								System.exit(1);	// if illegal allele found stop here								
							}									
						}	// up to here					
						
						if (tmpType.contains(gene)) {
							RemoveNotation rn = new RemoveNotation(tmpType);	// remove notation here
							list.add(rn.getFixed());
						}						
					}
					if (!list.isEmpty()) {
						tmpMap.put(gene, list);
					}	
				}		
			}		
			if (!tmpMap.isEmpty()) {
				sampleGeneType.put(sample, tmpMap);
				tmpSampleList.add(sample);
			}	
		}		
		sampleList.clear();
		sampleList.addAll(tmpSampleList);
		
	}
	
	public Map<String, Map<String, List<String>>> getSampleGeneType() {
		return sampleGeneType;
	}
	
	public List<String> getHlaGeneList() {		// put this function at the top of the class of the tree		
		return hlaGene.getGeneList();
	}

}
