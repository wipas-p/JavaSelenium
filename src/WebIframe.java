import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebIframe {

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

		driver.get("http://www.globalsqa.com/demo-site/draganddrop");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		By drop = By.xpath("//*[@id='trash']");
		
		WebElement destination = driver.findElement(drop);
		
		Actions action = new Actions(driver);
		
		for (int i=1 ; i <=4; i++) {
			By drag = By.xpath("//*[@id='gallery']/li");
			WebElement source = driver.findElement(drag);
			
			action.dragAndDrop(source, destination).build().perform();
			Thread.sleep(2000);
		}

		Thread.sleep(4000);
		System.out.print("Finish !!");

//		driver.close();
	}
}
