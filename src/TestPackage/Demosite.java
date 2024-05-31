package TestPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Demosite
{
	WebDriver driver;
	@Test
public void searchChrome()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\TestNGPractice\\TestNGReport\\ChromeDriver\\chromedriver.exe");
	
    driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationpanda.com/about/");
	String expectedtitle="About | Automation Panda111";
	String pagetitle=driver.getTitle();
	Assert.assertEquals(pagetitle, expectedtitle);
}
	@AfterMethod
	public void onTestFailure(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE)
	{
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(result.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
}