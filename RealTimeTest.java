package realtimeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeTest {
	String url = "https://www.ebay.com/";
	WebDriver driver = new ChromeDriver();;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		RealTimeTest realTimeTest = new RealTimeTest();
		realTimeTest.openSiteOnBrowser();
		realTimeTest.searchProduct("Apple Watches", " Jewelry & Watches");
		realTimeTest.printResult();
		realTimeTest.printnthItem(3);
		realTimeTest.printItemOnScreen();
		realTimeTest.screenScroll();

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

	public void printResult() {
		String noOfItems = driver
				.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span"))
				.getAttribute("textContent");
		System.out.print("No Of Products : ");
		System.out.print(noOfItems);
	}

	public void printnthItem(int n) {
		String t = "//*[@id=\"srp-river-results\"]/ul/li[".concat(String.valueOf(n)).concat("]/div/div[2]/a/div/span");
		// String t
		// ="//*[@id=\"srp-river-results\"]/ul/li["+n+"]/div/div[2]/a/div/span";
		String nthitem = driver.findElement(By.xpath(t)).getAttribute("textContent");
		System.out.println();
		System.out.print(n + "th Product is : ");
		System.out.println(nthitem);
	}

	public void printItemOnScreen() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		for (WebElement product : allProducts) {
			System.out.println("*******");
			System.out.println(product.getText());
			System.out.println("*******");
		}

	}

	public void screenScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		int count = 1;
		for (WebElement product : allProducts) {
			js.executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[" + count + "]")));
			System.out.println("*********************************************************************");
			System.out.println(product.getText());
			System.out.println("*********************************************************************");
			count++;
		}

	}

}
