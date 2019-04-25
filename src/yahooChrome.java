import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class yahooChrome {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "c:/selenium/BrowserDriver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testYoutube() throws Exception {
	  driver.get("https://www.yahoo.com/");
	  driver.findElement(By.id("uh-search-box")).clear();
	  driver.findElement(By.id("uh-search-box")).sendKeys("seleniumhq");
	  driver.findElement(By.id("uh-search-button")).click();
  }

  @After
  public void tearDown() throws Exception {
	  driver.quit();
	  String verificationErrorString = verificationErrors.toString();
	  if (!"".equals(verificationErrorString)) {
		  fail(verificationErrorString);
	  }
  }
}
