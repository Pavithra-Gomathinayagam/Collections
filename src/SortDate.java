import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SortDate {
	
	private static Logger logger = Logger.getLogger(SortDate.class.getName());
	
	public static void main(String args[]) {
		
		int i=0;
		Scanner scanner = new Scanner(System.in);
		logger.log(Level.INFO, "Enter the number of dates: ");
		int number = scanner.nextInt();
		
		ArrayList<String> datesList = new ArrayList<String>();
		
		while(number-->0) {
			logger.log(Level.INFO, "Enter the date: ");
			String dates = scanner.next();
			
			datesList.add(dates);
		}
		
		sortDates(datesList, 0);
		

		for(String dat : datesList) {
			logger.log(Level.INFO,dat);
			
		}

		sortDates(datesList, 1);
		
		for(String dat : datesList) {
			logger.log(Level.INFO,dat);
		}
	}
	
	private static void sortDates(ArrayList<String> dates, int flag) {
		Collections.sort(dates, new Comparator<String> () {
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			@Override
			public int compare(String arg0, String arg1) {
				try {
					if(flag==0) {
					return dateFormat.parse(arg0).compareTo(dateFormat.parse(arg1));
					} else {
					return dateFormat.parse(arg1).compareTo(dateFormat.parse(arg0));
					}
				} catch(ParseException e) {
					throw new IllegalArgumentException(e);
				}
			}
			
		});
			
	}
	
}