import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {
	
	@Test
	public void readPDFTest() throws IOException {
		
		//WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver","C://Program Files//eclipse//Charu//ChromeDriver/chromedriver.exe");
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options); 
		WebDriver driver = new ChromeDriver();
		driver.get("D:/Documents/Form16_022862_FY 2022-23.pdf");
		
		URL url = new URL(driver.getCurrentUrl());
		
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
		
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		
		String PDFContent = new PDFTextStripper().getText(document);
		
		System.out.println(PDFContent);
		
		//Assert.assertTrue(PDFContent.contains("FORM NO. 16"));
		Assert.assertTrue(PDFContent.contains("CSQPP5884F"));
		
		
		driver.quit();
		
	}

}
