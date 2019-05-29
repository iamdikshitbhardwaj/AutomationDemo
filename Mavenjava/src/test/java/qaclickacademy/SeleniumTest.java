package qaclickacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

	public WebDriver driver;
	public String url = "https://www.google.com/";
	public String googleSearchBar = ".//*[@name='q' and @type='text']";
	public String secondIndexGoogleSuggestion = "//li[@role='presentation'][2]";
	public String googleProductsButton = "//a[@title='Google apps']";

	@BeforeTest
	public void initialConfig() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\52087137\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\3.141.5\\chromedriver_win32\\chromedriver.exe");
	
	}

	@Test (priority=1)	
	public void openBrowser(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
		WebElement googleSearchText = driver.findElement(By.xpath((googleSearchBar)));
		googleSearchText.sendKeys("Find xpath using selenium");

	}

	@Test(priority=2)	
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondIndexGoogleSuggestion)));
		driver.findElement(By.xpath(secondIndexGoogleSuggestion)).click();
	}

	 @Test(priority=3)	
	 public void openApps() {
		WebElement googleProducts = driver.findElement(By.xpath(googleProductsButton));
		googleProducts.click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
