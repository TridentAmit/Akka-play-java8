package arrays_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A4 {
	static String s= "^(?!.*(?:\\.\\.))[^(<>(){}#$|?%*^.,-;:\"'=@)]+(([A-Za-z0-9._-]))+@(([[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,4}))$";
	
	static String f1 = "^(([^<>()[\\]\\\\.,;:$~!#%^&*{}\\s@\"]+";
	static String f2 = "(\\.[^<>()[\\]\\\\.,;:$~!#%^&*{}\\s@\"]+)*)|(\".+\"))";
	
	static String s3 = "([0-9-A-Za-z_-]+[.]*[A-Za-z-0-9_-]+)@(([[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,4}))$";
	
	
	static String s4 = "^(?!.*(?:\\.\\.))([A-Za-z-0-9_-]+[A-Za-z0-9._-]*)+@(([[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,4}))$";
	
	
	static String s5 ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@(([[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,4}))$";
	
	static String s6 = "/^(([^<>()\\.,;:$~!#%^&*{}\\s@\"]+(\\.[^<>()\\.,;:$~!#%^&*{}\\s@\"]+)*)|(\".+\"))@(([[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,4}))$";
	
	public static void main(String[] args) {
		//s = f1+f2+s3;
		System.out.println(s6);
		Pattern p = Pattern.compile(s6);
		Matcher m1 = p.matcher("amit@act.org");
		Matcher m2 = p.matcher("A_----_.b@gmail.com");
		System.out.println(m1.matches());
		//System.out.println(m2.matches());
		
	}
}
