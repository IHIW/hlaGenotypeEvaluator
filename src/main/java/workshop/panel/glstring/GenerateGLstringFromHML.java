/**
 * 
 */
package workshop.panel.glstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import workshop.panel.hml.ProjectSampleType;


/**
 * @author kazu
 *
 */
public class GenerateGLstringFromHML {

	/**
	 * 
	 */
	public GenerateGLstringFromHML(String filePath, String output) {
		// TODO Auto-generated constructor stub
		ProjectSampleType project = new ProjectSampleType(filePath);
		
		try {
			BufferedWriter out = 
					new BufferedWriter(new FileWriter(output));
			out.write("Sample,glstring\n");		// add header
			for (String sample : project.getSampleList()) {
				out.write(sample + ",");
				String glstring = "";
				for (String gene : project.getHlaGeneList()) {
					if (project.getSampleGeneType().get(sample).containsKey(gene)) {
						for (String type : project.getSampleGeneType().get(sample).get(gene)) {
							glstring += type + "^";							
						}
					}					
				}
				glstring = glstring.substring(0, glstring.length() - 1);
				out.write(glstring + "\n");
				
			}			
			out.close();			
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Cannot write in " + output);
		}	
	}

}
