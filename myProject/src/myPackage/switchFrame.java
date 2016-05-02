package myPackage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class switchFrame {
 
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
 
        driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
        driver.quit();
        
    }
}