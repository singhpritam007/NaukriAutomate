package orphan;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class ValidateOrphan {
	
	@BeforeMethod
	public void setUp() {
		Allure.step("Open Browser");
	}

	@Test
	public void createOrphan() {
		Allure.step("create orphan");
	}
	
	@Test
	public void viewOrphan() {
		Allure.step("View orphan");
	}
	
	@Test
	public void linkOrphan() {
		Allure.step("Link orphan");
	}
	
	@Test
	public void deleteOrphan() {
		Allure.step("Delete orphan");
	}
	
	@AfterMethod
	public void teardown() {
		Allure.step("Close Browser");
	}	
}
