package myPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import java.util.Set;
import org.openqa.selenium.Cookie;

public class pruebaCookies {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// Go to the correct domain
		driver.get("http://www.youtube.com");

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		// And now output all the available cookies for the current URL
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
			System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
			}
		
		// You can delete cookies in 3 ways
		/* By name
		driver.manage().deleteCookieNamed("YSC");
		// By Cookie
		driver.manage().deleteCookie(loadedCookie);
		*/ // Or all of them
		driver.manage().deleteAllCookies();
		driver.close();
		}
	}