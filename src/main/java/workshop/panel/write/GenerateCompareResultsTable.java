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
	public GenerateCompareResultsTable(String refFile, String resultFile, String outputFile) {
		// TODO Auto-generated constructor stub
		CompareResults cr = new CompareResults(refFile, resultFile);
		try {
			BufferedWriter out = 
					new BufferedWriter(new FileWriter(outputFile));
			
			out.write("Sample\tCategory\t");
			for (String locus : cr.getHLAgene().getGeneList()) {
				out.write(locus + "\t");
			}
			out.write("\n");
			for (String sample : cr.getScoreBySample().keySet()) {
				for (String score : cr.getScoreBySample().get(sample).keySet()) {
					out.write(sample + "\t" + score + "\t");
					for (String locus : cr.getHLAgene().getGeneList()) {
						if (cr.getScoreBySample().get(sample).get(score).containsKey(locus)) {
							for (String type : cr.getScoreBySample().get(sample).get(score).get(locus)) {
								out.write(type);
							}
						}
						out.write("\t");					
					}
					out.write("\n");
				}
				out.write("\n");
			}
			out.close();			
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Cannot write in " + outputFile);
		}	
	}


}
