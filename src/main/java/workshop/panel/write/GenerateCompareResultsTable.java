/**
 * 
 */
package workshop.panel.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import workshop.panel.CompareResults;

/**
 * @author kazu
 * @version January 20 2017
 *
 */
public class GenerateCompareResultsTable {

	/**
	 * 
	 */
	public GenerateCompareResultsTable(String refFile, String resultFile, String outputFileName) {
		// TODO Auto-generated constructor stub
		CompareResults cr = new CompareResults(refFile, resultFile);
		try {
			BufferedWriter out = 
					new BufferedWriter(new FileWriter(outputFileName));
			
			out.write("Sample,Category,");
			int count = 0;
			for (String locus : cr.getHLAgene().getGeneList()) {
				out.write(locus);
				if (count < cr.getHLAgene().getGeneList().size() - 1) {
					out.write(",");
				}				
				count++;
			}
			out.write("\n");
			for (String sample : cr.getScoreBySample().keySet()) {				
				for (String category : cr.getCategory()) {
					out.write(sample + "," + category + ",");
					int index = 0;
					for (String locus : cr.getHLAgene().getGeneList()) {
						if (cr.getScoreBySample().get(sample).get(category).containsKey(locus)) {
							for (String type : cr.getScoreBySample().get(sample).get(category).get(locus)) {
								out.write(type);
							}
						}
						if (index < cr.getHLAgene().getGeneList().size() - 1) {
							out.write(",");
						}
											
					}
					out.write("\n");
				}
				out.write("\n");
			}
			out.close();			
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Cannot write in " + outputFileName);
		}	
	}


}
