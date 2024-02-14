package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStepDef {
	WebDriver driver;
@Before
public void setup() {
	driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().window().maximize();
}

	@Given("User is on Login Page")
	public void user_in_on_login_page() {
	    driver.get("https://the-internet.herokuapp.com/login");
	}
	/*
	@When("User enters credentials")
	public void user_enters_credentials() {
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("SuperSecretPassword!");
//		driver.findElement(By.tagName("button")).click();
	
	}
	*/
	
	@When("User enters {string} and {string}")
	public void user_enters_credentials(String strUser, String strPwd) {
		driver.findElement(By.id("username")).sendKeys(strUser);
		driver.findElement(By.name("password")).sendKeys(strPwd);
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();   
	}
	
	//Fetching lists of list from database
	/*
	@When("User enters credentials")
	public void user_enters_credentials(DataTable dataTable) {
		List<List<String>> users=dataTable.asLists();
		String strUser=users.get(0).get(0);
		String strPwd=users.get(0).get(1);
		driver.findElement(By.id("username")).sendKeys(strUser);
		driver.findElement(By.name("password")).sendKeys(strPwd);
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
	}
	*/
	
	//Fetching lists of map from database
	@When("User enters credentials")
	public void user_enters_credentials(DataTable dataTable) {
		List<Map<String, String >> users=dataTable.asMaps();
		String strUser=users.get(0).get(0);
		String strPwd=users.get(0).get(1);
		driver.findElement(By.id("username")).sendKeys(strUser);
		driver.findElement(By.name("password")).sendKeys(strPwd);
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
	}
	
//	@Then("Should display Success Msg")
//	public void should_display_success_msg() {
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//		Assert.assertTrue(isUserValid);
//	}
	
	@Then("Should display Success Msg")
	public void should_display_success_msg(DataTable dataTable) {
		List<String> msgs =dataTable.asList();
		String expMsg=msgs.get(0);
		Assert.assertEquals("You logged into a secure area!", expMsg);
	}
	

}





