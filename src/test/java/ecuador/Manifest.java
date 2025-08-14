package ecuador;

import org.testng.annotations.*;

import io.qameta.allure.Allure;

public class Manifest {
	
	@BeforeMethod
	public void setUp() {
		Allure.step("Open Browser");
	}

	@Test
	public void validateManfest() {
		Allure.step("validate manifest");
	}
	
	@Test
	public void uploadManfest() {
		Allure.step("upload manifest");
	}
	
	@Test
	public void deleteManfest() {
		Allure.step("delete manifest");
	}
	
	@Test
	public void downloadManfest() {
		Allure.step("Download manifest");
	}
	
	@AfterMethod
	public void teardown() {
		Allure.step("Close Browser");
	}
}
