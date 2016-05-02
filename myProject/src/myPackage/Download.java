package myPackage;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Download {
 
public static void main(String[] args) {
String baseUrl = "http://www.hdwallpapers.in/firecracker_jinx_league_of_legends-wallpapers.html";
WebDriver driver = new FirefoxDriver();
 
driver.get(baseUrl);
WebElement downloadButton = driver.findElement(By.linkText("Original"));
String sourceLocation = downloadButton.getAttribute("href");
// after -P the "c:" is where the file will be downloaded   cmd.exe", "/c", "cd \"C:\\Program Files\\Microsoft SQL Server\" && dir
String wget_command = "cmd /c wget -P C:\\Users\\EdgarR\\Pictures\\GoPro --no-check-certificate " + sourceLocation;
 
try {
Process exec = Runtime.getRuntime().exec(wget_command);
int exitVal = exec.waitFor();
System.out.println("Exit value: " + exitVal);
switch (exitVal){
case 0: System.out.println("Descarga completa"); 
break;
default: System.out.println("Error en la descarga");
break;
}
} catch (InterruptedException | IOException ex) {
System.out.println(ex.toString());
}
driver.quit();
}
}