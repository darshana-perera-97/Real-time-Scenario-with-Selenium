package realtimeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeTest {
	String url = "https://www.ebay.com/";
	WebDriver driver = new ChromeDriver();;
	public static void main(String []args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
	}
	public void openSiteOnBrowser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
}
