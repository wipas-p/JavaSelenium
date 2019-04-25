import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindJob {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		String browser = "firefox";
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c:/selenium/BrowserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:/selenium/BrowserDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//Open Web Page
		driver.get("http://www.google.co.th");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Search Keyword
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		//Wait for Search Result
		Thread.sleep(2000);
		
		List<WebElement> lst = driver.findElements(By.xpath("//ul[@role='listbox']//span"));

		for (WebElement list : lst) {
			String target = list.getText();
			System.out.println(target);
			if (target.equalsIgnoreCase("selenium ide")) {
				list.click();
				break;
			}
		}
		
//		for (WebElement list : lst) {
//			if (list.getText().equalsIgnoreCase("selenium ide")) {
//				list.click();
//				break;
//			}
//		}

		Thread.sleep(4000);
		System.out.print("Finish !!");
		driver.close();
	}
}
