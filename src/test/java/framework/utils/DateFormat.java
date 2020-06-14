package framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(new Date());
    }
}
