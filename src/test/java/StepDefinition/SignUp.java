package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class SignUp {
	
	WebDriver driver;

	@Given("^User is on Application Home Page$")
	public void user_is_on_Application_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^Application Page Title is PHP Travels$")
	public void application_Page_Title_is_PHP_Travels(){
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
	    Assert.assertEquals(expectedTitle, actualTitle);

	}

	@Then("^user clicks on MY ACCOUNT$")
	public void user_clicks_on_MY_ACCOUNT() {
	    driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")).click();
	}

	@Then("^user clicks on Sign Up option$")
	public void user_clicks_on_Sign_Up_option()  {
		driver.findElement(By.xpath("//a[starts-with(text(),'Sign')]")).click();
	}

	@When("^User navigate to Sign Up page$")
	public void user_navigate_to_Sign_Up_page() {
		 String actualTitle = driver.findElement(By.xpath("//h3[contains(text(),'Sign')]")).getText();
		    String expectedTitle = "Sign Up";
		    Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("^user enters personal data and the entered values are validated$")
	public void user_enters_personal_data(DataTable data){
		List<List<String>>  formData = data.raw();
		   driver.findElement(By.name("firstname")).sendKeys(formData.get(0).get(0));
		   driver.findElement(By.name("lastname")).sendKeys(formData.get(0).get(1));
		   driver.findElement(By.name("phone")).sendKeys(formData.get(0).get(2));
		   driver.findElement(By.name("email")).sendKeys(formData.get(0).get(3));
		   driver.findElement(By.name("password")).sendKeys(formData.get(0).get(4));
		   driver.findElement(By.name("confirmpassword")).sendKeys(formData.get(0).get(5));
		   
		   String fname=driver.findElement(By.name("firstname")).getAttribute("value");
		   String lname=driver.findElement(By.name("lastname")).getAttribute("value");
		   String phone= driver.findElement(By.name("phone")).getAttribute("value");
		   String email=driver.findElement(By.name("email")).getAttribute("value");
		   String pswd=driver.findElement(By.name("password")).getAttribute("value");
		   String cpswd=driver.findElement(By.name("confirmpassword")).getAttribute("value");
		   
		   Assert.assertEquals(fname,formData.get(0).get(0));
		   Assert.assertEquals(lname,formData.get(0).get(1));
		   Assert.assertEquals(phone,formData.get(0).get(2));
		   Assert.assertEquals(email,formData.get(0).get(3));
		   Assert.assertEquals(pswd,formData.get(0).get(4));
		   Assert.assertEquals(cpswd,formData.get(0).get(5));
	}

	@Then("^click on Sign Up button$")
	public void click_on_Sign_Up_button()  {
	    
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
	}

	@Then("^Close the Browser$")
	public void close_the_Browser()  {
	    
		driver.close();
	}


}
