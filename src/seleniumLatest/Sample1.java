package seleniumLatest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class Sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver4.exe"); // Launch chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/"); // get-launch the Url of any application
		driver.manage().window().maximize();
		driver.navigate().refresh();
		WebElement nameEditbox = driver.findElement(By.cssSelector("input[name='name']"));

		driver.findElement(withTagName("label").above(nameEditbox)).getText(); // Any static package will not be
																				// identified by eclipse & selenium guys
																				// have made this as static
		System.out.println(driver.findElement(withTagName("label").above(nameEditbox)).getText());

		WebElement aa = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(withTagName("input").below(aa)).sendKeys("2/27/2021");
		WebElement bb = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(withTagName("input").toLeftOf(bb)).click();

		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(withTagName("label").toRightOf(radioButton)).getText());

		WebElement rbo = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));

		driver.findElement(withTagName("input").toRightOf(rbo)).click();
	}
}