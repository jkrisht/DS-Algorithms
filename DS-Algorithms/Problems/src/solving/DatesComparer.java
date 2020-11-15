package solving;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesComparer {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = sdf.parse("2019-12-22");
	}
}
