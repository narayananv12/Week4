package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assing1Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(item1).moveToElement(item2).release().perform();

	}

}
