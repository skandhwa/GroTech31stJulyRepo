package Utilities;

public class CommonFunctions {
	
	public static String getRandomEmail()
	{
		int length = 10; 
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        String email = "";
        for (int i = 0; i < length; i++) {
            int idx = (int) (Math.random() * chars.length());
            email += chars.charAt(idx);   //
        }
        email += "@gmail.com";
        return email;
	}
	
	

}
