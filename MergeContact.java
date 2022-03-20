package Assignment.Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[4]")).click();
		driver.findElement(By.xpath("(//a[@href]/img)[4]")).click();
		Thread.sleep(4000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>();
		newWindow.addAll(windowHandles);
		String newPage = newWindow.get(1);
		driver.switchTo().window(newPage);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a[1]")).click();
		String mainPage = newWindow.get(0);
		driver.switchTo().window(mainPage);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//a[@href]/img)[5]")).click();
		Thread.sleep(3000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> newWindow2 = new ArrayList<String>();
		newWindow2.addAll(windowHandles2);
		String newPage2 = newWindow2.get(1);
		driver.switchTo().window(newPage2);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[2]//a")).click();
		String mainPage1 = newWindow2.get(0);
		driver.switchTo().window(mainPage1);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//tr//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
	}

}
