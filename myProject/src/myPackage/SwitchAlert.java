package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SwitchAlert {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait Seconds =  new WebDriverWait(driver, 3);
		String alertMessage = "";
		String verification = "";
		
		driver.get("http://jsbin.com/usidix/1");
		Seconds.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\"Go!\"]")));
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		alertMessage= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		verification = "This is an alert box.";
		
		System.out.println(alertMessage);
		if (alertMessage.equals(verification)){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		driver.quit();
		
	}

}
