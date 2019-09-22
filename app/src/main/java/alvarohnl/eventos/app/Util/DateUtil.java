package alvarohnl.eventos.app.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatFromLong(Long dateLong) {

        Date date = new Date(dateLong);
        return DATE_FORMAT.format(date);

    }


}
