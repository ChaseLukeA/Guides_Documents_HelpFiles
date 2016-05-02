import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * This is my personal testing project for Java
 * <hr>
 * {@code // all my tests go here}
 * <br> 
 * &copy; 2016 lchase@menards.net
 */
public class Main {

	public static void main(String[] args) {
		
		System.out.println(javaDocExample("lchase", 2016));
		//System.out.println(javaDocExample("lchase", "2016"));
		
		System.out.println((Date) convertDateStringToDate("03/31/1980"));
		System.out.println((Date) convertDateStringToDate("03-31-1980"));
		System.out.println((Date) convertDateStringToDate("03 31 1980"));
		System.out.println((Date) convertDateStringToDate("3/31/1980"));
		System.out.println((Date) convertDateStringToDate("3/3/1980"));
		System.out.println((Date) convertDateStringToDate("1980-3-31"));
		System.out.println((Date) convertDateStringToDate("1980-03-31"));
		System.out.println((Date) convertDateStringToDate("1980/03/31"));
		System.out.println((Date) convertDateStringToDate("1980 03 31"));
		
		System.out.println(SomeType.Type1);
		System.out.println(SomeType.listAll());
		System.out.println("Invalid type provided, was expecting: [ " + SomeType.listAll() + " ]");

		String monkey = null;
		
		if (StringUtils.isNotBlank(monkey)) {
			System.out.println("Has value!");
		} else {
			System.out.println("Is null!");
		}

		monkey = "";
		
		if (StringUtils.isNotBlank(monkey)) {
			System.out.println("Has value!");
		} else {
			System.out.println("Is blank!");
		}

		monkey = "see";
		
		if (StringUtils.isNotBlank(monkey)) {
			System.out.println("Has value!");
		} else {
			System.out.println("Is blank!");
		}
		
		String type = "type_03";
		
		if (type.equals(SomeType.Type3.toString())) {
			System.out.println("type is " + SomeType.Type3);
		} else if (type.equals(SomeType.Type4.toString())) {
			System.out.println("type is " + SomeType.Type4);
		} else {
			System.out.println("type cannot be found");
		}
	}
	
    /**
    * <h1>javaDocExample</h1>	
    * <p>some example code</p>
    * 
    * {@code This is some code that goes in the app}
    * 
    * @param name - the author's name
    * @param year - the publication year
    * @return - string of the copyright year and author's name
    * @throws InvalidParameterException - if something you didn't want goes in
    */
	public static String javaDocExample(String name, int year) throws InvalidParameterException {
		try {
			return "\n© " + String.valueOf(year) + " " + name;
		} catch (InvalidParameterException e) {
			return "You've passed an invalid parameter into this method!!!";
		}
	}

	/**
	 * Convert date string to Date object
	 * 
	 * <h3>Valid String dates:</h3>
	 * <ul>
	 *   <li>'month > day > year' format using a 4-digit year</li>
	 *   <li>'year > month > day' format using a 4-digit year</li>
	 *   <li>allowed separators are '/', '-', ' ', '.'</li>
	 * </ul>
	 * 
	 * @param argDate - a String containing a formatted date
	 * @return Date with the specified month, day, and year
	 */
	public static Date convertDateStringToDate(final String argDate) {
		
		final String[] patterns = {
				"MM-dd-yyyy","MM/dd/yyyy","MM dd yyyy","MM.dd.yyyy",
				"yyyy-MM-dd","yyyy/MM/dd","yyyy MM dd","yyyy.MM.dd"};
		
		try {
			return DateUtils.parseDateStrictly(argDate, patterns);
		} catch (ParseException e) {
			return null;
		}
	}

	public static enum SomeType {
		Type1("type_01"), Type2("type_02"), Type3("type_03"), Type4("type_04");
		
		private final String type;

		private SomeType(String type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return this.type;
		}
		
		private static String listAll() {
			ArrayList<String> all = new ArrayList<String>(); 
			for (SomeType type : SomeType.values()) {
				all.add(type.toString());
			}
			return StringUtils.join(all, ", ");
		}
	};

}
