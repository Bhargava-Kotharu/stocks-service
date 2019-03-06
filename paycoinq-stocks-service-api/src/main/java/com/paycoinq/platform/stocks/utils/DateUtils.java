package com.paycoinq.platform.stocks.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.paycoinq.platform.stocks.constants.ApplicationConstants;

public class DateUtils {

	public static String getDateInReadableFormat(Timestamp timestamp) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ApplicationConstants.DATABASE_DATE_FORMAT);
		return sdf.format(timestamp);

	}
}
