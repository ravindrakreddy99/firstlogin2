package com.selenuim;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstLogin {
	
	WebDriver driver;
	
	
/*	login in to the newtours application
	check if the user have be landed on book a flight page
	round trip radio button should be selected by default
	select the passenger count as 2
	departure location as london Arrival location is paris
	select first class radio button 
	click on continue button to book a flight

	check if the user is landed on payment page
	close the browser*/
	
	@BeforeTest
    public void setUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenuim1\\chromedriver.exe");
    driver =new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://www.newtours.demoaut.com/");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
  }
	/*@AfterTest
    public void tearDown() {
	driver.quit();*/
	  
  
	
   @Test(priority=1)
    public void Login_funct() throws InterruptedException {
	   
	driver.findElement(By.name("userName")).sendKeys("mercury");
	driver.findElement(By.name("password")).sendKeys("mercury");
	driver.findElement(By.name("login")).click();
	Thread.sleep(3000);
	  
  }
 @Test(priority=2,dependsOnMethods="Login_funct")  
  public void check_if_user_book_flight() {
	 String title=driver.getTitle();
	 if(title.contains("Find a Flight")) {
		 Reporter.log("the user is on book a flight");
		 
	 }
	
	
}
 @Test(priority=3,dependsOnMethods="check_if_user_book_flight", groups= "BookaFlight")
     public void check_Roundtrip_button() throws InterruptedException {
	 boolean selected = driver.findElement(By.xpath("//input[@type='radio' and @value='roundtrip']")).isSelected();
	 if(selected) {
		 Reporter.log("user book a flight on round trip");
		 Thread.sleep(3000);
	 }

	 
 }
 @Test(priority=4, groups="BookaFlight")
     public void selectPassenger_count() throws InterruptedException {
	 Select passengercount = new Select(driver.findElement(By.name("passCount")));
	 passengercount.selectByIndex(1);
	 Thread.sleep(3000);
	 
 }
 
@Test(priority=5, groups= "BookaFlight")
public void set_Departure_And_Arrival_Location() throws InterruptedException {
	 Select depar_location = new Select(driver.findElement(By.name("fromPort")));
	 depar_location.selectByVisibleText("London");
	 Select arrival_location = new Select(driver.findElement(By.name("toPort")));
	 arrival_location.selectByVisibleText("Paris");
	 Thread.sleep(3000);

}

@Test(priority=6)
public void first_class_radio() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='radio' and @value='First']")).click();	
	Thread.sleep(3000);
}

@Test(priority=7)
public void click_on_buton() throws InterruptedException {
	
	boolean enabled=driver.findElement(By.name("findFlights")).isEnabled();	
if(enabled) {
	driver.findElement(By.name("findFlights")).click();	
	Thread.sleep(3000);

}
}
@Test(priority=8)
public void bookingFlightname() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='radio' and @value='Pangea Airlines$362$274$9:17']")).click();
	

	
}
@Test(priority=9)
public void bookingFlightname1() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='radio' and @value='Pangea Airlines$632$282$16:37']")).click();
}
@Test(priority=10)
public void registration() {
	driver.findElement(By.name("reserveFlights")).click();
	driver.findElement(By.name("passFirst0")).sendKeys("ravi");
	driver.findElement(By.name("passLast0")).sendKeys("kumar");
	driver.findElement(By.name("pass.0.meal")).sendKeys("Hindu");
}
@Test(priority=11)
public void credit() {
	driver.findElement(By.name("creditCard")).sendKeys("Visa");
	driver.findElement(By.name("creditnumber")).sendKeys("2345678");
	 Select depar_location = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
	 depar_location.selectByIndex(3);
	 Select depar_location1 = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
	 depar_location1.selectByIndex(5);
}



















}
