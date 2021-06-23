package seleniumLatest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

public class MultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver4.exe"); // Launch chrome driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/"); // get-launch the Url of any application
		driver.manage().window().maximize();
		driver.navigate().refresh();

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);

		driver.get("https://rahulshettyacademy.com/#/index");

		String CourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(3).getText();

		driver.switchTo().window(ParentWindow);

		WebElement Name = driver.findElement(By.cssSelector("input[name='name']"));

		Name.sendKeys(CourseName);

		File screenshot = Name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("RahulshettyImage.png"));

		System.out.println(Name.getRect().getDimension().getHeight());
		System.out.println(Name.getRect().getDimension().getWidth());

	}
}
