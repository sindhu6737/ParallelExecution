import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class parallel {
	WebDriver driver;

	@Test
	public void checkUrl()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getTitle());
	}

	@Test
	public void login()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Sindhu.Naik\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("sindhu@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		System.out.println("this is the test related to chrome browserstack login"+ " " +Thread.currentThread().getId());

	}

	@AfterClass
	public void close()
	{
		driver.quit();
	}

}
