package solving;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {
	public static void main(String[] args) throws ParseException {

		String s = "02:00:00PM";

		SimpleDateFormat given = new SimpleDateFormat("hh:mm:ssaa");
		SimpleDateFormat expected = new SimpleDateFormat("HH:mm:ss");

		Date date = given.parse(s);

		String s1 = expected.format(date);
		System.out.println(s1);

	}
}