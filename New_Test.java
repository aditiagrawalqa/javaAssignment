package com.qainfotech.training.assertion;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import static org.testng.Assert.*;
	import org.testng.annotations.*;

	public class New_Test {
	    
	    WebDriver driver;
	    
	    Loginform loginForm;
	    
	    @Test
	    public void attempt_Login_With_Incorrect_Password_Should_Render_Error_Message(){
	        Assert.assertTrue(loginForm
	                .loginWithIncorrectCredentials("INVALID_USERN", "INVALUD_PASSWEOR").contains("Invalid Login"));
	    }
	    
	    @Test
	    public void attempt_Login_With_No_Password_Should_Annotate_Black_Password_Field(){
	        loginForm.login("aditi", "");
	        // red border in password entry
	        Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
	    }
	    public TimeSheet attempt_Login_with_Correct_Username_Password() {
	    	loginForm.loginWithCorrectCredentials("aditiagrawal", "Aditi@321#");
	    }
	    
	    @BeforeClass
	    public void launchBrowser(){
	        driver = new ChromeDriver();
	        driver.get("https://s-hris.qainfotech.com");
	        loginForm = new Loginform(driver);
	    }
	    
	    @AfterClass
	    public void closeBrowser(){
	        driver.quit();
	    }
	    

}
