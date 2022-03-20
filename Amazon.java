package Assignment.Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("onepluse 9 pro", Keys.ENTER);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(price);
		String rating = driver.findElement(By.xpath("(//a[@target='_blank'])[4]/span")).getText();
		System.out.println(rating);
		driver.findElement(By.xpath("(//a[@role='button'])[2]/i[1]")).click();
		String fiveStar = driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a")).getText();
		System.out.println("the 5 star rating percentage is "+fiveStar);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> noOfWindows = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>();
		newWindow.addAll(noOfWindows);
		String newPage = newWindow.get(1);
		driver.switchTo().window(newPage);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("add-to-cart-button")).click();
		String cartTotal = driver.findElement(By.xpath("(//div[@class='a-column a-span11 a-text-left a-spacing-top-large'])[1]/span[2]")).getText();
		System.out.println(cartTotal);
		if(cartTotal.contains(price)) {
			System.out.println("The price is same");
			
		}else {
			System.out.println("The price is not same");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
 