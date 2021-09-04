package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Input the Topic
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id]/following-sibling::input")).sendKeys("Frames");

		//Mark the checkbox
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		//Returning to main content
		driver.switchTo().defaultContent();
		//Select from Dropdown
		driver.switchTo().frame("frame2");
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select animals = new Select(dropDown);
		animals.selectByIndex(3);
		
		driver.switchTo().defaultContent();
		
	}

}
