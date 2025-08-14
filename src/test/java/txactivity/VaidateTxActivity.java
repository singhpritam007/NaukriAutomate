package txactivity;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class VaidateTxActivity {

	@BeforeMethod
	public void setUp() {
		Allure.step("Open Browser");
	}

	@Test
	public void createRecordsInTxActivity() {
		Allure.step("Create records in Tx Activity");
	}
	
	@Test
	public void filterRecordsInTxActivity() {
		Allure.step("filter records in Tx Activity");
	}
	
	@Test
	public void deleteRecordsInTxActivity() {
		Allure.step("delete records in Tx Activity");
	}
	
	@Test
	public void dowlloadRecordsInTxActivity() {
		Allure.step("Download records in Tx Activity");
	}
	
	@AfterMethod
	public void teardown() {
		Allure.step("Close Browser");
	}
}
