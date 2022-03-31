package om.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import  org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MobileValidation {
	
		static WebDriver driver;
		static long startTime;
		 static String name1;
	 @BeforeClass(groups="default")
		public static void BeforeClass() {
		 
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.flipkart.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	@AfterClass(groups="default")
	 public static void afterClass(){
		
	driver.quit();
	 }
	 @BeforeMethod
	 public  void beforeScript() {
		 
		 startTime = System.currentTimeMillis();
	 }
	 @AfterMethod
	 public void afterScript(){
		 long endTime = System.currentTimeMillis();
		
			
			System.out.println("Time taken is:" + (endTime - startTime));
		 }
	 

@Test(priority=1,groups="sanity")
	 public  void login() {
		try {
			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
			
			close.click();
			
		}catch(Exception e) {
			
		
		} 
	}
@Test(priority=2,groups="sanity")
	 public void search() {
		 WebElement search = driver.findElement(By.name("q"));
		 search.sendKeys("realme",Keys.ENTER);
	 	
	 	 
	 }
@Test(priority=3)
	 public void choose() {
	 WebElement mobilename = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[1]"));
	 name1 = mobilename.getText();
	 System.out.println(name1);
	 

	 } 
@Test(priority=4)
	 public void  window(){
		 String parent = driver.getWindowHandle();
	Set<String> children = driver.getWindowHandles();
		 for (String x : children) {
			 if(!parent.equals(x)) {
				 driver.switchTo().window(x);
				 
			 }
		 }
		
		 
	 }

@Test(priority=5, enabled= false)
	public void validation() {
		 WebElement mobilename2 = driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
		 Assert.assertTrue(mobilename2.isDisplayed());
		 String name2 = mobilename2.getText();
		 System.out.println(name2); 
		
		 
		Assert.assertEquals(name1, name2);
		   System.out.println("passed");
	}

@Test(priority=6,invocationCount=5)
public void successMessage() {
	System.out.println("SUCCESS");
}
	}
		 
		 
		 
		 
		 
	 
	 

	

	
	
 
		 
		 
		 
		 
		 
	 
	 



