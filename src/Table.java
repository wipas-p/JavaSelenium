import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		String browser = "chrome" ;
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c:/selenium/BrowserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:/selenium/BrowserDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		
		String country = "italy";
		boolean found = false;
		
		for (WebElement tr : trs) {
			List<WebElement> tds = tr.findElements(By.tagName("td")); {
				for (WebElement td : tds) {
					if(td.getText().equalsIgnoreCase(country)) {
						found = true;
						System.out.println(country + " Found");
					}
				}
			}
			System.out.println();
		}
		
		if (!found)
			System.out.println();
		
		
		Thread.sleep(4000);
		System.out.print("Finish !!");
		
		driver.close();
	}
}
