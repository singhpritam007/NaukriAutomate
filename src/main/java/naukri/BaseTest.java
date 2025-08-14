package naukri;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
    public void setup(Method method) throws Exception {
        String methodName = method.getName();
        System.out.println("Started Recording");
        VideoRecorder.startRecording(methodName);
    }

	

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        VideoRecorder.stopRecording();
        System.out.println("Stoped Recording");
        if(result.isSuccess()) {
        	VideoRecorder.deleteRecording();
        }
    }
	
}

