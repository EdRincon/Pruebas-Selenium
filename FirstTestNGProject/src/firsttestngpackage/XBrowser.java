package firsttestngpackage;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class XBrowser {
	WebDriver driver;
	 /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")){
			//create firefox instance
			driver = new FirefoxDriver();
		}
		//Check if parameter passed from TestNG is 'Chrome'
		else if (browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","C:\\IEdriver.exe");
            //create internet explorer instance
		driver = new InternetExplorerDriver();
	}
	
	else{
		//If no browser passed throw exception
		throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
    public void XBrowserTest() throws InterruptedException{
        driver.get("http://demo.guru99.com/V4/");
        //Find user name
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.name("uid")));
        //WebElement userName = driver.findElement(By.name("uid"));
        //Fill user name
        userName.sendKeys("guru99");
        //Find password
        WebElement password = driver.findElement(By.name("password"));
        //Fill password
        password.sendKeys("guru99");
        driver.quit();
    }
}

/**

package Selenium.gittest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Hello world!
 *

public class App 
{
	protected WebDriver driver;
	
	@Test
	public void tutorial() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String eTitle = "Meet Guru99";
		String aTitle = "";
		//
		//Launch browser and go to URL
		//
		driver.get("http://www.guru99.com/");
		//Maximizes the browser window
		driver.manage().window().maximize();
		//Get the actual value of the title
		aTitle = driver.getTitle();
		//Compare the actual title with the expected title
		if (aTitle.contentEquals(eTitle)){
			System.out.println("Test Passed");
		} else{
			System.out.println("Test Failed");
		}
		//Close browser
		//driver.close();
		driver.close();
	}
	
}
*/
