import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		String browser = "chrome";
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c:/selenium/BrowserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:/selenium/BrowserDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get("http://www.coin360.io");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if (driver.findElement(By.xpath("//div[@class='BottomViewType BottomViewType BottomViewType']")).isDisplayed())
			driver.findElement(By.xpath("//button[@class='Toast__Button']")).click();

		Thread.sleep(4000);
		System.out.print("Finish !!");

		driver.close();
	}
}
