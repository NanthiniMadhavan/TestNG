package om.flipkart.stepdefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SamsungMobileValidation{
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
 @org.testng.annotations.AfterClass(groups="default")
 public static void AfterClass(){
	
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
	 search.sendKeys("Samsung",Keys.ENTER);
 	
 	 
 }
 @Test(priority=3)
 public void choose() {
 WebElement mobilename = driver.findElement(By.xpath("(//div[contains(text(),'samsung')])[1]"));
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


@Test(priority=5)
 public void validation() {
	 WebElement mobilename2 = driver.findElement(By.xpath("//span[contains(text(),'samsung')]"));
	 String name2 = mobilename2.getText();
	 System.out.println(name2); 
	 
	Assert.assertEquals(name1, name2);
	
}
}
	 
	 
	 
	 
	 
 
 


 


