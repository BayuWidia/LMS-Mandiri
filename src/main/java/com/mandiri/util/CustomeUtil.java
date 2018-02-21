package com.mandiri.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomeUtil {

	public String changeMonthToString(BigDecimal setVal) {
		String strResult = "";
		System.out.println("=================>>setVal::" + setVal);
		if (setVal != null) {
			if (setVal.compareTo(new BigDecimal(1)) == 0) {
				strResult = "Januari";
			} else if (setVal.compareTo(new BigDecimal(2)) == 0) {
				strResult = "Februari";
			} else if (setVal.compareTo(new BigDecimal(3)) == 0) {
				strResult = "Maret";
			} else if (setVal.compareTo(new BigDecimal(4)) == 0) {
				strResult = "April";
			} else if (setVal.compareTo(new BigDecimal(5)) == 0) {
				strResult = "Mei";
			} else if (setVal.compareTo(new BigDecimal(6)) == 0) {
				strResult = "Juni";
			} else if (setVal.compareTo(new BigDecimal(7)) == 0) {
				strResult = "Juli";
			} else if (setVal.compareTo(new BigDecimal(8)) == 0) {
				strResult = "Agustus";
			} else if (setVal.compareTo(new BigDecimal(9)) == 0) {
				strResult = "September";
			} else if (setVal.compareTo(new BigDecimal(10)) == 0) {
				strResult = "Oktober";
			} else if (setVal.compareTo(new BigDecimal(11)) == 0) {
				strResult = "November";
			} else if (setVal.compareTo(new BigDecimal(12)) == 0) {
				strResult = "Desember";
			}
		}
		return strResult;
	}

	public String changeMonthToString2(String setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.equalsIgnoreCase("1")) {
				strResult = "Januari";
			} else if (setVal.equalsIgnoreCase("2")) {
				strResult = "Februari";
			} else if (setVal.equalsIgnoreCase("3")) {
				strResult = "Maret";
			} else if (setVal.equalsIgnoreCase("4")) {
				strResult = "April";
			} else if (setVal.equalsIgnoreCase("5")) {
				strResult = "Mei";
			} else if (setVal.equalsIgnoreCase("6")) {
				strResult = "Juni";
			} else if (setVal.equalsIgnoreCase("7")) {
				strResult = "Juli";
			} else if (setVal.equalsIgnoreCase("8")) {
				strResult = "Agustus";
			} else if (setVal.equalsIgnoreCase("9")) {
				strResult = "September";
			} else if (setVal.equalsIgnoreCase("10")) {
				strResult = "Oktober";
			} else if (setVal.equalsIgnoreCase("11")) {
				strResult = "November";
			} else if (setVal.equalsIgnoreCase("12")) {
				strResult = "Desember";
			}
		}
		return strResult;
	}

	public String changeStatusFakturToString(BigDecimal setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.compareTo(new BigDecimal(0)) == 0) {
				strResult = "Aktif";
			} else if (setVal.compareTo(new BigDecimal(1)) == 0) {
				strResult = "Dibatalkan";
			} else if (setVal.compareTo(new BigDecimal(2)) == 0) {
				strResult = "Diganti";
			}
		}
		return strResult;
	}

	public String changeStatusLaporToString(BigDecimal setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.compareTo(new BigDecimal(0)) == 0) {
				strResult = "Belum Dilaporkan";
			} else if (setVal.compareTo(new BigDecimal(1)) == 0) {
				strResult = "Sudah Dilaporkan";
			}
		}
		return strResult;
	}

	public String changeKreditToString(BigDecimal setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.compareTo(new BigDecimal(0)) == 0) {
				strResult = "Tidak Dikreditkan";
			} else if (setVal.compareTo(new BigDecimal(1)) == 0) {
				strResult = "Dikreditkan";
			}
		}
		return strResult;
	}

	public String changeRoleToString(BigDecimal setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.compareTo(new BigDecimal(1)) == 0) {
				strResult = "DJP";
			} else if (setVal.compareTo(new BigDecimal(2)) == 0) {
				strResult = "ADMINISTRATOR";
			} else if (setVal.compareTo(new BigDecimal(3)) == 0) {
				strResult = "PKP";
			} else if (setVal.compareTo(new BigDecimal(4)) == 0) {
				strResult = "ASP";
			} else if (setVal.compareTo(new BigDecimal(5)) == 0) {
				strResult = "Anggota ASP";
			}
		}
		return strResult;
	}

	public String formatRupiah(BigDecimal setVal) {
		String strResult = "";
		if (setVal != null) {
			DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
			DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

			formatRp.setCurrencySymbol("Rp. ");
			formatRp.setMonetaryDecimalSeparator(',');
			formatRp.setGroupingSeparator('.');

			kursIndonesia.setDecimalFormatSymbols(formatRp);
			strResult = kursIndonesia.format(setVal);
		}
		return strResult;
	}

	public String formatDate(Date setVal) {
		String dtResult = null;
		if (setVal != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dtResult = sdf.format(setVal);
		}
		return dtResult;
	}

	public String monthIndo(String setVal) {
		String strResult = "";
		if (setVal != null) {
			if (setVal.equalsIgnoreCase("January")) {
				strResult = "1";
			} else if (setVal.equalsIgnoreCase("February")) {
				strResult = "2";
			} else if (setVal.equalsIgnoreCase("March")) {
				strResult = "3";
			} else if (setVal.equalsIgnoreCase("April")) {
				strResult = "4";
			} else if (setVal.equalsIgnoreCase("May")) {
				strResult = "5";
			} else if (setVal.equalsIgnoreCase("June")) {
				strResult = "6";
			} else if (setVal.equalsIgnoreCase("July")) {
				strResult = "7";
			} else if (setVal.equalsIgnoreCase("August")) {
				strResult = "8";
			} else if (setVal.equalsIgnoreCase("September")) {
				strResult = "9";
			} else if (setVal.equalsIgnoreCase("October")) {
				strResult = "10";
			} else if (setVal.equalsIgnoreCase("November")) {
				strResult = "11";
			} else if (setVal.equalsIgnoreCase("December")) {
				strResult = "12";
			}
		}
		return strResult;
	}

}
