package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		String title=driver.getTitle();

		System.out.println(title);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement (By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']" )).click();
		
		 //Click on Merge Contacts using Xpath Locator
		
		driver.findElement(By.partialLinkText("Merge Contacts")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//form[@name='MergePartyForm']//a")).click();
		
		Set <String> newwindow = driver.getWindowHandles();
	    List<String> newwindow1 = new ArrayList <String>(newwindow);
	    driver.switchTo().window(newwindow1.get(1));
	    System.out.println("The title of second windows  " + driver.getTitle());
	   
		    
	    driver.findElement(By.xpath("//a[text()='12885']")).click();
	    
	    
		 Thread.sleep(1000);
		 driver.switchTo().window(newwindow1.get(0));
		 System.out.println(newwindow1.size());
		 
		 driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		 Set<String> windowHand = driver.getWindowHandles();
		 List<String> List =new ArrayList<String>(windowHand);
		 driver.switchTo().window(List.get(1));;
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[text()='12886']")).click();
		 driver.switchTo().window(List.get(0));;
		 
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
		String title1 = driver.getTitle();
		if (title.contains("View Contact | opentaps CRM")) {
			System.out.println("Matching");
		
		}
		
		else
			System.out.println("not Matching");
		
		
		
	
		
	}
}
