/**
 * Validate alleles, capture illega alleles
 */
package workshop.panle.hml;

/**
 * @author kazu
 * @version May 3 2017
 *
 */
public class ValidAlleleTest {
	String validated;

	/**
	 * 
	 */
	public ValidAlleleTest(String sample, String type) throws IllegalAlleleException {
		// TODO Auto-generated constructor stub
		validated = "";
		IllegalAllele ia = new IllegalAllele();	// generate known illegal alleles
		if (ia.getIllegalAlleleList().contains(type)) {
			throw new IllegalAlleleException(sample + " contains " + type + " -> Suggested allele: "
					+ ia.getSuggestedAllele().get(type));
		}
		else {
			validated = type;
		}
		
	}
	
	public String getValidatedType() {
		return validated;
	}

}
