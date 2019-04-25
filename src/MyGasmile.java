import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyGasmile {
	public MyGasmile (WebDriver driver) throws InterruptedException {
		
		driver.get("https://www.calculator.net/gas-mileage-calculator.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("uscodreading")).clear();	
		driver.findElement(By.id("uscodreading")).sendKeys("12000");
		driver.findElement(By.id("uspodreading")).clear();
		driver.findElement(By.id("uspodreading")).sendKeys("10000");
		driver.findElement(By.id("usgasputin")).clear();
		driver.findElement(By.id("usgasputin")).sendKeys("40");
		driver.findElement(By.id("usgasprice")).clear();
		driver.findElement(By.id("usgasprice")).sendKeys("4.5");
		
		//Click Button
		driver.findElement(By.xpath("//table[@id='standard']//input[@value='Calculate']")).click();
		
		String temp = driver.findElement(By.xpath("//*[@id='content']/font/b")).getText();
		System.out.println(temp);
		if (temp.matches("(.*) miles per gallon")) {
			System.out.println("Pass");
		}
		String [] x = temp.split(" ");
		if (x[0].equals("50.00")) {
			System.out.println("Equal 50");
		}
				
		Thread.sleep(4000);
		System.out.print("Finish !!");
		
		driver.close();
	}
}
