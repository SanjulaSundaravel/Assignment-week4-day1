package Assignment.Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAndWindow {
	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.linkText("FLIGHTS")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>();
		newWindow.addAll(windows);
		String mainPage = newWindow.get(0);
		String newPage = newWindow.get(1);
		
		driver.switchTo().window(newPage);
		System.out.println(driver.getCurrentUrl());
		
	
		
		driver.findElement(By.xpath("//a[@id='dropdown10']")).click();
		String customerCareMail = driver.findElement(By.xpath("(//a[@class='dropdown-item'][3])[1]")).getText();
		System.out.println("Cuctomer care Email Id is "+customerCareMail);
		
		driver.switchTo().window(mainPage).close();
		
		
		
		
		
	}

}
