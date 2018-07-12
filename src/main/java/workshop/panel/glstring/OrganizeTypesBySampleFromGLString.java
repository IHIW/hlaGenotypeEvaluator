/**
 * This is to organize typing from result GL string table
 */
package workshop.panel.glstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import workshop.haplotype.family.organize.OrganizeBySample;
import workshop.haplotype.organize.file.ChooseElement;



/**
 * @author kazu
 * @version December 24 2015
 *
 */
public class OrganizeTypesBySampleFromGLString extends OrganizeBySample {

	public OrganizeTypesBySampleFromGLString(ChooseElement ce) {
		super(ce);
		// TODO Auto-generated constructor stub
		Set<String> sampleSet = new HashSet<String>();	// use set
		for (List<String> tmpList : ce.getChosenElement()) {
			List<String> linkedList = new LinkedList<String>();
			for (String str : tmpList) {
				linkedList.add(str);
			}
			String sample = linkedList.remove(0);	// extract sample ID
			if (!sampleSet.contains(sample)) {	// remove redundancy
				sampleList.add(sample);
				sampleSet.add(sample);
			}	
												
			for (String gl : linkedList) {
				String [] list = gl.split("\\^");	// need to escape here
				Map<String, List<String>> locusType = new TreeMap<String, List<String>>();
				for (String type : list) {	
//					System.out.println(type);
					type = type.replaceAll(" ", "");	// remove space if any					
					if ((type.length() != 0) && (!type.contains("HLA-"))) {	// add HLA- if missing
						type = "HLA-" + type;
						type = type.replace("+", "+HLA-");
						type = type.replace("/", "/HLA-");
						type = type.replace("|", "|HLA-");
					}
					
					for (String locus : hlaGene.getGeneList()) {	// go through gene list
						List<String> tmpTypeList = new ArrayList<String>();	
						if (type.contains(locus)) {	// this step remove empty space	
							tmpTypeList.add(type);
						}
												
						if (!tmpTypeList.isEmpty()) {
							locusType.put(locus, tmpTypeList);					
						}
					}					
				}
				hlaTypeBySample.put(sample, locusType);				
			}			
		}				
	}
}
