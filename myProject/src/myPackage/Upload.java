package myPackage;

import java.io.IOException;      
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;    

public class Upload {
	
public static void main(String[] args) throws IOException {                             
    WebDriver driver=new FirefoxDriver();           
    driver.get("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload"); 
    driver.findElement(By.name("file_upload")).click();
    
    // below line execute the AutoIT script .
    Runtime.getRuntime().exec("Upload.exe");          
    String text = "grmpcat.jpg";
    
    try {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[4]/div[1]/form/table/tbody/tr[1]/td[2]/input"), text));
    } catch (NoSuchElementException h) {
    	System.out.println("No se encontró el texto");
    } catch (TimeoutException t) {
    	System.out.println("Se acabó el tiempo y el upload.exe no funcionó");
    }
    
    try {
    driver.findElement(By.xpath("/html/body/div/div[4]/div[1]/form/table/tbody/tr[3]/td[2]/input")).click();
    } catch (NoSuchElementException e) {
    	System.out.println("No se encontro el texto");
    } finally {
    	//driver.close();
    }
    }
}