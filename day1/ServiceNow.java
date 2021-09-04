package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident",Keys.ENTER);
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		String attribute = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Id is:" + attribute);
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).click();
		driver.findElement(By.xpath("//td[text()='Annabelle Coger']")).click();
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Going good");
		
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		
	String text1 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (text1.contains(attribute)) {
			System.out.println("verified");
		}
		else
			System.out.println("Not matchhing");
		File Scr = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/seat2.png");
		FileUtils.copyFile(Scr, dst);

	}

}
