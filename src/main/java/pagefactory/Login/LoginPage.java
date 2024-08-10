package pagefactory.Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	public void enter_username() {
		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(30));
		we.until(ExpectedConditions.elementToBeClickable(username)).sendKeys("krusha16@gmail.com");
		
	}
	
	public void enter_password() {
		WebDriverWait we = new WebDriverWait(driver, Duration.ofSeconds(30));
		we.until(ExpectedConditions.elementToBeClickable(username)).sendKeys("125689");
	}
}
