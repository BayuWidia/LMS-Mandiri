package com.mandiri.util;

import java.math.BigDecimal;

public class StringUtil {
	
	public static <T> T nvl(T arg0, T arg1) {
		return (arg0 == null) ? arg1 : arg0;
	}

	public static BigDecimal getDecimal(Object bd) {
		return (BigDecimal) nvl(bd, BigDecimal.ZERO);
	}


}
