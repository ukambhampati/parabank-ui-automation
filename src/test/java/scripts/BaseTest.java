package scripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.JsonUtils;

public class BaseTest {
	
	public static JsonNode envdata;
	public static WebDriver driver;
	@Parameters({"environment", "browser"})
	@BeforeMethod
	public WebDriver setup(@Optional("QA") String environment,@Optional("chrome") String browser) throws IOException {
		JsonUtils jutil = new JsonUtils();
		envdata = jutil.readJSON("E:\\testing\\ushauiautomation\\src\\main\\java\\data\\config.json");
		String baseurl = envdata.get("Environments").get(environment).get("url").asText();
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.get(baseurl);
			
		}
		return driver;
	}

	@AfterMethod
	public void teardown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}

