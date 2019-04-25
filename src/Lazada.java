import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lazada {
	
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
		
		driver.get("https://www.lazada.co.th");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("Bose Soundlink");
		driver.findElement(By.xpath("//button[@class='search-box__button--1oH7']")).click();
		
		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='c1_t2i']//a"));
		
		for (WebElement list : lst)
			System.out.println(list.getText());
		
		Thread.sleep(4000);
		System.out.print("Finish !!");
		
		driver.close();
	}
}
