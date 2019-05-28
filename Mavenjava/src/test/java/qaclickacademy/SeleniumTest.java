package qaclickacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumTest {
	@Test
	public void SeleniumMethod1() throws InterruptedException {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\52087137\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\3.141.5\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.google.com/";
		driver.get(url);

		// actions.contextClick().click().perform();
		WebElement element = driver.findElement(By.xpath((".//*[@name='q' and @type='text']")));
		element.sendKeys("Find xpath using selenium");
	
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='presentation'][2]")));
		driver.findElement(By.xpath("//li[@role='presentation'][2]")).click();

	}

	// @Test
	public void login() {

	}
}
