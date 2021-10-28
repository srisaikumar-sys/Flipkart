package org.revision;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Sri Sai kumar\\eclipse-workspace\\Revision_Project\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		java.util.List<WebElement> element = driver.findElements(By.tagName("a"));
		int linkCount = element.size();
		System.out.println("Total number of Links in the webpage"+linkCount);
		int count=0;
		int brokencount=0;
		for (int i = 0; i < element.size(); i++) {
			WebElement link = element.get(i);
			String attribute = link.getAttribute("href");
			
			if (attribute !=null) {
				if (attribute.contains("https")) {
				URL url=new URL(attribute);
				URLConnection openConnection;
					openConnection = url.openConnection();
				HttpURLConnection http=(HttpURLConnection)openConnection;
				int rc = http.getResponseCode();
				if (rc==200) {
					count++;
					System.out.println("success===>"+attribute);
				} else {
					brokencount++;
					System.out.println("unsuccess===>"+attribute);
				}}}
		}
		System.out.println("Successcount===>"+count);
		System.out.println("unsuccesscount===>"+brokencount);	
		
		Thread.sleep(300);
		System.out.println("Printed SuccessCount");
		System.out.println("Printed Unsuccesscount");
		
		WebElement txtName = driver.findElement(By.xpath("//a[@class='_14Me7y']"));
		String s=txtName.getText();
		System.out.println(s);
		
		
		
		}
}

