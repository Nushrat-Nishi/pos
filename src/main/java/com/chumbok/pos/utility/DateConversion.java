package com.chumbok.pos.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConversion {
    public Date stringToDate(String dateInString) throws Exception{
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateInString);
    };
}
