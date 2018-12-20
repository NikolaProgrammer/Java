package by.gsu.pms.constants;

public class Constants {
	public static final String DB_URL = "jdbc:mysql://localhost/orderservice" +
							   "?verifyServerCertificate=false"+
					            "&useSSL=false"+
					            "&requireSSL=false"+
					            "&useLegacyDatetimeCode=false"+
					            "&amp"+
					            "&serverTimezone=UTC";

	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "פגüרע";
	
	public static final String NO_SUCH_USER_EXCEPTION = "The user doesn't exist";
	public static final String INVALID_PASSORD_EXCEPTION = "Invalid password";
}
