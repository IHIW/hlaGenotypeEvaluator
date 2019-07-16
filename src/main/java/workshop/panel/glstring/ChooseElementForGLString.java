/**
 * Input file requires header
 */
package workshop.panel.glstring;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import workshop.haplotype.organize.file.ChooseElement;
import workshop.haplotype.organize.file.OrganizeElement;
import workshop.haplotype.organize.file.removeLine.RemoveFirstLine;
import workshop.haplotype.organize.file.removeLine.RemoveLine;

/**
 * @author kazutoyo
 * @version July 16 2019
 *
 */
public class ChooseElementForGLString extends ChooseElement {
	protected List<String> removedList;		// added on October 28 2015

	/**
	 * @param filePath
	 */
//	public ChooseElementForGLString(String filePath) {
	public ChooseElementForGLString(BufferedReader reader) {
//		super(filePath);
		super();
		// TODO Auto-generated constructor stub
		removedList  = new ArrayList<String>();
		RemoveLine rel = new RemoveFirstLine(reader);	// requires header
		removedList.addAll(rel.getRemovedList());
		OrganizeElement oe = new OrganizeElement(rel, ",");
		chooseElement(oe);
	}
	
	public List<String> getRemovedList() {	// This is added to check NMDP code file
		return removedList;
	}


}
