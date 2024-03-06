package naukri;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriAutomate {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		String FileName1=System.getProperty("user.dir")+"//src//test//java//resume//Pritam Singh - QA Automation Tester Resume - Latest.pdf";
		String FileName2=System.getProperty("user.dir")+"//src//test//java//resume//Pritam Singh - QA Automation Tester Resume - Updated.pdf";
		String url = "https://www.naukri.com";
		String xLoginButton = "//a[@title='Jobseeker Login']";
		String xUserName = "//input[@placeholder='Enter your active Email ID / Username']";
		String xPassword = "//input[@placeholder='Enter your password']";
		String xSubmit = "//button[@type='submit']";
		String xViewProfile = "//a[@href='/mnjuser/profile' and contains(text(),'View')]";
		String xUploadResume = "//input[@id='attachCV']";
		String xUploadSuccessfull = "//p[@class='msg']";

		driver.get(url);

		driver.findElement(By.xpath(xLoginButton)).click();
		driver.findElement(By.xpath(xUserName)).sendKeys("singh.pritam2503@gmail.com");
		;
		driver.findElement(By.xpath(xPassword)).sendKeys("Kingkong@007007");
		;
		driver.findElement(By.xpath(xSubmit)).click();
		;

		String title = "Home | Mynaukri";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.titleContains(title));

		// System.out.println(driver.getTitle()+" / "+title);

		System.out.println("============================");

		String month = LocalDateTime.now().getMonth().toString().toLowerCase();
		int date = LocalDateTime.now().getDayOfMonth();
		int year = LocalDateTime.now().getYear();

		System.out.println("   Day => " + date + "-" + month + "-" + year);
		System.out.println("============================");

		driver.findElement(By.xpath(xViewProfile)).click();
		driver.navigate().refresh();
		Thread.sleep(1500);

		for (int i = 1; i <= 96; i++) {

			try {

				String resume = GetDynamicFileName.getFilePaths(FileName1, FileName2); // class
																						// name
																						// =
																						// "getDynamicFileName"

				driver.findElement(By.xpath(xUploadResume)).sendKeys(resume);
				// Resume has been successfully uploaded.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xUploadSuccessfull))));

				String time = LocalDateTime.now().toString().substring(11, 19);
				if (i < 10) {
					System.out.println("Resume '0" + i + "' uploaded at " + time + " => " + resume);
				} else {
					System.out.println("Resume '" + i + "' uploaded at " + time + " => " + resume);
				}

				long resumeUploadFrequencyInMinutes = 20; // Please choose
															// the frequency
															// of uploading
															// the your
															// Resume in
															// "Minutes"

				Thread.sleep((resumeUploadFrequencyInMinutes * 60000) - 1050);
			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println(e.getMessage());
			}

		}

	}
}
