/**
 * This drive can take arguments with gl string format reference and test files
 * or directory that contains reference 7 test HML
 */
package workshop.panel.driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import workshop.panel.write.GenerateCompareResultsTable;
import workshop.panel.write.RunValidation;

/**
 * @author kazu
 * @version September 18 2019
 *
 */
public class DriverSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		num = args.length;
		
		if ( num == 1 ) {
			new RunValidation(args[0]);
		}
		else if (num == 3) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String today = dateFormat.format(date);
			new GenerateCompareResultsTable(args[0], args[1], args[2] + "_" + today + ".csv");
		}
		else {
			System.err.println("Please select correct file path! Bye!!");
			System.exit(1);
		}

	}

}
