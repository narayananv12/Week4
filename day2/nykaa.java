package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Mouseover on Brands
		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);

		builder.moveToElement(Brands).perform();

		// click on L'Oreal Paris
		driver.findElement(By.xpath("//ul[@class='l-vertical-list']//li[5]/a")).click();

		// switch to tab
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> tabs = new ArrayList<String>(windowHandles);
		driver.switchTo().window(tabs.get(1));

		// check the title contains L'Oreal Paris
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Matching");
		} else
			System.out.println("Not Matching");

		// Click sort By
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='value']")).click();

		// select customer top rated
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		// Click Category and click Shampoo
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		// check whether the Filter is applied with Shampoo
		Thread.sleep(1000);
		WebElement filter = driver.findElement(By.xpath("(//label[@class='control control--checkbox'])[1]/div"));
		boolean check = filter.isEnabled();
		if (check == true) {
			System.out.println("Filter is applied with Shampoo");

		} else
			System.out.println("Filter is not applied with Shampoo");

		// Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='m-content__product-list__title'])[12]")).click();

		// GO to the new window
		Set<String> S = driver.getWindowHandles();
		List<String> List = new ArrayList<String>(S);
		driver.switchTo().window(List.get(2));
		// driver.switchTo().window(tabs.get(2));
		Thread.sleep(1000);

		// GO to the new window and select size as 360ml
		driver.findElement(By.xpath("//span[text()='360ml']")).click();

		// Print the MRP of the product
		String text = driver.findElement(By.xpath("//span[text()='282']")).getText();
		String text1 = text.replaceAll("[^0-9]", "");
		System.out.println("MRP of the product :  " + text1);

		// Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='pull-left']//button")).click();

		// Go to Shopping Bag
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		WebElement Frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(Frame);

		// Print the Grand Total amount
		String text2 = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		String Total1 = text2.replaceAll("[^0-9]", "");
		int X = Integer.parseInt(Total1);
		System.out.println("Grand Total amount:    " + X);

		// Click Proceed
		driver.findElement(By.xpath("//div[@class='second-col']")).click();

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();

		// Check if this grand total is the same
		String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]/span")).getText();
		String Total2 = text3.replaceAll("[^0-9]", "");
		int Y = Integer.parseInt(Total2);
		System.out.println("grand total is the same:  " +Y);
		if (X == Y) {
			System.out.println("matching");

		}

		else
			System.out.println("not matching");

		driver.quit();

	}

}
