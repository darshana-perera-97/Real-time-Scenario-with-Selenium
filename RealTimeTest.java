package realtimeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeTest {
	String url = "https://www.ebay.com/";
	WebDriver driver = new ChromeDriver();;
	public static void main(String []args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		RealTimeTest realTimeTest = new RealTimeTest();
		realTimeTest.openSiteOnBrowser();
		realTimeTest.searchProduct("Apple Watches", " Jewelry & Watches");
		
		
	}
	public void openSiteOnBrowser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void searchProduct(String product, String category) {
		WebElement search = driver.findElement(By.id("gh-ac"));
		search.sendKeys(product);
		driver.findElement(By.id("gh-cat")).sendKeys(category);
		driver.findElement(By.id("gh-btn")).click();
	}
	
}
