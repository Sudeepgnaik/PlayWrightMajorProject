package com.test;

import com.microsoft.playwright.*;
import com.utilities.configuration;

import java.io.File;
import java.nio.file.Paths;

import org.testng.annotations.*;

public class BaseTest {
	 protected static Playwright playwright;
	    protected static Browser browser;
	    protected static BrowserContext context;
	    protected static Page page;
	    @BeforeMethod
	    public void setup() {
	        playwright = Playwright.create();
	        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	        context = browser.newContext();
	        page = context.newPage();
	        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }
	    @AfterMethod
	    public void tearDown() {
	        if (context != null) context.close();
	        if (browser != null) browser.close();
	        if (playwright != null) playwright.close();
	    }
    public static String captureScreenshot(String testName) {
        String path = "./target/screenshots/" + testName + ".png";
        new File("./target/screenshots").mkdirs(); // Ensure folder exists
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }


    public Page getPage() {
        return page;
    }
}
