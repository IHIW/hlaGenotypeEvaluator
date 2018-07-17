/**
 * 
 */
package workshop.panel.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import workshop.panel.write.GenerateCompareResultsTable;

/**
 * @author kazu
 * @version January 20 2017
 *
 */
public class DriverForGenerateCompareResultsTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		new GenerateCompareResultsTable(args[0], args[1], args[2] + "_" + today + ".csv");

	}

}
