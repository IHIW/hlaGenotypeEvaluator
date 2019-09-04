/**
 * List of illegal alleles from MiaFora software
 */
package workshop.panel.hml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import workshop.haplotype.sirona.RemoveNotation;

/**
 * @author kazu
 * @version May 3 2017
 *
 */
public class IllegalAllele {
	private List<String> illelgalAllele;
	private Map<String, String> suggestedAllele;

	/**
	 * 
	 */
	public IllegalAllele() {
		// TODO Auto-generated constructor stub
		illelgalAllele = new ArrayList<String>();
		String [] list = {"HLA-A*02:30e1", "HLA-A*02:30", 
				"HLA-B*08:01:01e1", "HLA-B*08:01:01v1", "HLA-B*08:01:01", "HLA-B*15:18:01v1",
				"HLA-B*15:18:01", "HLA-C*07:04:01e1", "HLA-C*07:04:01e2", "HLA-C*07:04:01",	
				"HLA-B*07:05:01e1", "HLA-B*07:05:01",
				"HLA-C*03:03:01e1", "HLA-C*03:03:01", "HLA-DPB1*04:01", "HLA-DPB1*06:01e1", "HLA-DPB1*06:01", 
				"HLA-DQA1*01:01:01:01e1", "HLA-DQB1*05:03:01:01|HLA-DQB1*05:03:01:02",				
				"HLA-DRB3*02:02:01:02v1"};
		// removed , "HLA-DRB5*01:01:01:01"
		String [] suggestedAlleleList = {"HLA-A*02:30:01", "HLA-B*08:01:01:01", "HLA-B*15:18:01:01/HLA-B*15:18:01:02",
				"HLA-C*07:04:01:01", "HLA-B*07:05:01:01", "HLA-C*03:03:01:01","HLA-DPB1*06:01:01",
				"HLA-DPB1*04:01:01:01", "HLA-DQA1*01:01:01:02", "HLA-DRB3*02:02:01:01"};
		// removed , "HLA-DRB5*01:01:01"
		suggestedAllele = new HashMap<String, String>();
		
		for (String type : list) {
			illelgalAllele.add(type);	// populate original type
			RemoveNotation rn = new RemoveNotation(type);	// remove notation here
			
			for (String allele : suggestedAlleleList) {
				if (allele.contains(rn.getFixed())) {
					suggestedAllele.put(type, allele);
				}
			}
		}
//		suggestedAllele.put("HLA-DPB1*06:01e1", "HLA-DPB1*06:01:01");
		suggestedAllele.put("HLA-DQA1*01:01:01:01e1", "HLA-DQA1*01:01:01:02");
		suggestedAllele.put("HLA-DRB3*02:02:01:02v1", "HLA-DRB3*02:02:01:01");
		suggestedAllele.put("HLA-DQB1*05:03:01:01|HLA-DQB1*05:03:01:02", "HLA-DQB1*05:03:01:01/HLA-DQB1*05:03:01:02");
//		suggestedAllele.put("HLA-DRB5*01:01:01:01", "HLA-DRB5*01:01:01");
	}
	
	public List<String> getIllegalAlleleList() {
		return illelgalAllele;
	}
	
	public Map<String, String> getSuggestedAllele() {
		return suggestedAllele;
	}

}
