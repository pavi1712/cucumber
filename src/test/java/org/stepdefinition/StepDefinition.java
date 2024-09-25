package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	
	@Given("User have to launch the Facebook Application through Chrome Browser")
	public void user_have_to_launch_the_Facebook_Application_through_Chrome_Browser() {
	   launchBrowser();
	   togetUrl("https://www.facebook.com/");
	}

	@When("User have to enter invalid username and valid password")
	public void user_have_to_enter_invalid_username_and_valid_password() {
		WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys("SSR");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys("12345678");
	}
	
	//DATA TABLE
	
	//ONE DIMENTIONAL LIST
	
	/*//ONE DIMENTIONAL LIST
       |java|python|sql|selenium|nodejs|
       
	 @When("User have to enter invalid username and valid password")
	public void user_have_to_enter_invalid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
	    List<String> l = d.asList();
	    
	    String string = l.get(0);
	    
	    WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys(string);
		 
		 String string2 = l.get(1);
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys(string2);
	    }*/

	//TWO DIMENTIOAL LIST
	
	/*//TWO DIMENTIONAL LIST
       |java|python|sql|selenium|nodejs|
       |1234|98765|567|987654|
       
	 @When("User have to enter invalid username and valid password")
	public void user_have_to_enter_invalid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
	    List<List<String>> l = d.asLists();
	    
	    String string = l.get(0).get(0);
	    
	    WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys(string);
		 
		 String string2 = l.get(1).get(1);
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys(string2);
	    }*/
	
	//ONE DIMENTIONAL MAP
	
	/*//ONE DIMENTIONAL MAP
       |username|selva|
       |password|1234567|
       |email   |abc@gmail|
       
	  @When("User have to enter invalid username and valid password")
      public void user_have_to_enter_invalid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
      Map<String,String> mp= d.asMap(String.class, String.class);
      
         String string1 = mp.get("username");
         
         WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys(string1);
		 
		 String string2 = mp.get("password");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys(string2);
		 }*/
	
	//TWO DIMENTIONAL MAP
	
	/*//TWO DIMENTIONAL MAP
      |username|password|
      |java    |123|
      |sql     |4567|
      |selenium|98765|
      
     @When("User have to enter invalid username and valid password")
	public void user_have_to_enter_invalid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
	List<Map<String, String>> mp = d.asMaps(String.class, String.class);
	
	String string = mp.get(2).get("username");
	
	WebElement email= driver.findElement(By.id("email"));
	 email.sendKeys(string);
	 
	 String string2 = mp.get(0).get("password");
	 
	 WebElement password = driver.findElement(By.id("pass"));
	 password.sendKeys(string2);
	}*/
	
	@When("User have to enter valid username and invalid password")
	public void user_have_to_enter_valid_username_and_invalid_password() {
		WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys("pavi@gmail.com");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys("6756789");
	}
	@When("User have to enter {string} and  {string}")
	public void user_have_to_enter_and(String username, String password) {
		WebElement email= driver.findElement(By.id("email"));
		 email.sendKeys(username);
		 
		 WebElement pass = driver.findElement(By.id("pass"));
		 pass.sendKeys(password);
	    
	}

	@When("User have to click the Login button")
	public void user_have_to_click_the_Login_button() {
		WebElement login = driver.findElement(By.name("login"));
		login.click();
	}

	@Then("User have to reach the invalid credential page")
	public void user_have_to_reach_the_invalid_credential_page() {
		 String url = driver.getCurrentUrl();
		 if (url.contains("privacy_mutation_token")) {
			System.out.println("User reach the invalid credential");
		} else {
			System.out.println("User reach the valid page");

		}
	}}
	




