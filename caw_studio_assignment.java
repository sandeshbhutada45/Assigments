package Assignment_V3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class caw_studio_assignment {

	public static void main(String[] args) {
		String data = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//summary[normalize-space()='Table Data']")).click();
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).clear();
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).sendKeys(data);
		System.out.println("data insterted");
		driver.findElement(By.xpath("//button[@id='refreshtable']")).click();

		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		boolean match = true;
		for (WebElement row : tableRows) {
			String rowData = row.getText();
			if (!data.contains(rowData)) {
				match = false;
				break;
			}
		}

		if (match) {
			System.out.println("Data in table matches the entered data!");
		} else {
			System.out.println("Data in table does not match the entered data.");
		}
	}
}