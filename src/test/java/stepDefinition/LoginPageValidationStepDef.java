package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageValidationStepDef {
	
	WebDriver driver;
	@Given("User in Login Page")
	public void user_is_in_login_page() {
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.manage().window().maximize();
	    driver.get("https://react-redux.realworld.io/#/login?_k=flwqrm");
	}
	
	
	@When("User enters valid credentials")
	public void user_enter_credentials() {
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("thamizhini1302@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc1234fg");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	    
	}
	
	
	@Then("Should display success message")
	public void should_display_success_message() {
	    boolean check=driver.findElement(By.xpath("//a[@href='#@Thamizhini']")).isDisplayed();
	    Assert.assertTrue(check);
	}
	
	
	@When("User enters invalid credentials")
	public void user_enter_invalid_credentials() {
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("tamil@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("cnvn");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	   
	}
	
	
	@Then("Should display error message")
	public void should_display_invalid_sign_in_message() {
	    boolean check=driver.findElement(By.xpath("//li[contains(text(),'email or password')]")).isDisplayed();
	    Assert.assertTrue(check);
	}
	
	
	@After
	public void attachReportWithScreen(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot screen=(TakesScreenshot)driver;
			byte[] img=screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img,"img/png","ScreenshotImage");
		}
	}


}
