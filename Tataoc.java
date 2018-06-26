package QaTrainning;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Tataoc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aditiagrawal\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("http://10.0.1.86/tatoc");


		driver.findElement(By.linkText("Basic Course")).click();
		driver.manage().window().maximize();


		driver.findElement(By.className("greenbox")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.switchTo().frame(driver.findElement(By.id("main")));


		String Box1 = driver.findElement(By.id("answer")).getAttribute("class");
		String Box2 = null;
		do
		{
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#child")));
			Box2=driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(Box1.equals(Box2)) {

				driver.findElement(By.linkText("Proceed")).click();

				break;
			}
			else

				{driver.findElement(By.linkText("Repaint Box 2")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Repaint Box 2")));
		} }

		while(!(Box1.equals(Box2)));
		
		
		//driver.switchTo().frame(driver.findElement(By.id("dropbox")));
		WebElement From = driver.findElement(By.id("dragbox"));
		WebElement To =driver.findElement(By.id("dropbox"));
		
		 Actions act=new Actions(driver);					

				
		         act.dragAndDrop(From, To).build().perform();
		         driver.findElement(By.linkText("Proceed")).click();
		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		         
		         
		         driver.findElement(By.linkText("Launch Popup Window")).click();
		         String winHandleBefore = driver.getWindowHandle();
		         for(String windowHandle  : driver.getWindowHandles()) {
		         driver.switchTo().window(windowHandle);
		         }
		   
		         driver.findElement(By.id("name")).sendKeys("aditi");
		         
		         driver.findElement(By.id("submit")).click();
		         wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		        // String MainWindow=driver.getWindowHandle();
		         // String winHandleAfter = driver.getWindowHandle();
		        

		         
		         driver.switchTo().window(winHandleBefore);
		         driver.findElement(By.linkText("Proceed")).click();
		       /*  driver.findElement(By.linkText("Generate Token")).click();
		         String token= driver.findElement(By.id("token")).getText();
		         String [] s= token.split(" ");
		         
		         
		         
		         Cookie name = new Cookie("Token:",s[2]);
		 		driver.manage().addCookie(name);
		 		 
			
		  
		        driver.findElement(By.linkText("Proceed")).click();*/
		         driver.findElement(By.linkText("Generate Token")).click();
		 		String token1 = driver.findElement(By.id("token")).getText();
		 		String Token2 = token1.substring(token1.indexOf(":")+2);
		 		Cookie cookie = new Cookie("Token",Token2);
		 		driver.manage().addCookie(cookie);
		 		driver.findElement(By.linkText("Proceed")).click();
			}		
		
		
		
		
		
		
		

	}

