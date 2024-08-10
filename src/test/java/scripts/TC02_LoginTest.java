package scripts;

import org.testng.annotations.Test;

import pagefactory.Login.LoginPage;

public class TC02_LoginTest extends BaseTest {
	
  @Test
  public void f() {
		System.out.println("driverr launched");
		System.out.println(driver.getCurrentUrl());
		LoginPage page = new LoginPage(driver);
		page.enter_username();
	}
}
