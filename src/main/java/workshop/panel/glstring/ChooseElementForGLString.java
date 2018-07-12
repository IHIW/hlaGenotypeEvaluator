/**
 * 
 */
package workshop.panel.glstring;

import java.util.ArrayList;
import java.util.List;

import workshop.haplotype.organize.file.ChooseElement;
import workshop.haplotype.organize.file.OrganizeElement;
import workshop.haplotype.organize.file.removeLine.RemoveFirstLine;
import workshop.haplotype.organize.file.removeLine.RemoveLine;

/**
 * @author kazutoyo
 * @December 18 2015
 *
 */
public class ChooseElementForGLString extends ChooseElement {
	protected List<String> removedList;		// added on October 28 2015

	/**
	 * @param filePath
	 */
	public ChooseElementForGLString(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
		removedList  = new ArrayList<String>();
		RemoveLine rel = new RemoveFirstLine(filePath);	// requires header
		removedList.addAll(rel.getRemovedList());
		OrganizeElement oe = new OrganizeElement(rel, ",");
		chooseElement(oe);
	}
	
	public List<String> getRemovedList() {	// This is added to check NMDP code file
		return removedList;
	}


}
