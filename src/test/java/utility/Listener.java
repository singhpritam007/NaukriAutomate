package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;

public class Listener implements ITestListener {

    public void onStart(ITestContext context) {
    	File resultsDir = new File(System.getProperty("user.dir"), "allure-results");
        if (resultsDir.exists() && resultsDir.isDirectory()) {
            File[] files = resultsDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.delete()) {
                        System.err.println("Failed to delete: " + file.getAbsolutePath());
                    }
                }
            }
            System.out.println("✅ Allure results cleared before test execution.");
        } else {
            System.out.println("ℹ Allure results folder not found, skipping cleanup.");
        }
    }

    public void onFinish(ITestContext context) {}
    public void onTestStart(org.testng.ITestResult result) {}
    public void onTestSuccess(org.testng.ITestResult result) {}
    public void onTestFailure(org.testng.ITestResult result) {}
    public void onTestSkipped(org.testng.ITestResult result) {}
    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult result) {}
    public void onTestFailedWithTimeout(org.testng.ITestResult result) {}
}

