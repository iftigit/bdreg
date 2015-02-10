package org.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
	
	public static boolean isValidDate(String datetooconvert, String format,String separator) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		Date testDate = null;
		try {
			testDate = formatter.parse(datetooconvert);
			String[] f = format.split(separator);
			String[] d = datetooconvert.split(separator);
			String k = "";
			for (int i = 0; i < f.length; i++) {
				if (f[i].equalsIgnoreCase("dd")) {
					if (d[i].length() == 1)
						d[i] = "0" + d[i];
				}
				if (f[i].equalsIgnoreCase("mm")) {
					if (d[i].length() == 1)
						d[i] = "0" + d[i];
				}

				k += d[i] ;
				if(i < (f.length-1))
					k+=separator;
			}

			if (!formatter.format(testDate).equals(k))
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	 private static final Random RANDOM = new SecureRandom();
	  /** Length of password. @see #generateRandomPassword() */
	  public static final int PASSWORD_LENGTH = 8;
	  /**
	   * Generate a random String suitable for use as a temporary password.
	   *
	   * @return String suitable for use as a temporary password
	   * @since 2.4
	   */
	  public static String generateTmpRegId(int idLength)
	  {
	      // Pick from some letters that won't be easily mistaken for each
	      // other. So, for example, omit o O and 0, 1 l and L.
	      //String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";
		  String letters = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";

	      String pw = "";
	      for (int i=0; i<idLength; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          pw += letters.substring(index, index+1);
	      }
	      return pw;
	  }

}
