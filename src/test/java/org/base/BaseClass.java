package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver; 
	public static void launchBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}
	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void launchUrl(String Url) {
		driver.get(Url);
	}
	 public static void clickTheOption(WebElement ele) {
		ele.click();
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public static void passText(String txt , WebElement ele) {
		ele.sendKeys(txt);
		
	}
	public static void screenShot(String img) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location + imgname.png");
		FileUtils.copyFile(image, f);
	}
	public static void dropDown() {
	Actions	a = new Actions(driver);
	a.dragAndDrop(null, null).perform();
	}
	
    public static JavascriptExecutor js;
    public void ScrollThePge() {
		js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(null));
		js.executeScript("arguments[0].scrollIntoView(true)", element );
	}
    public static void ScrollDown() {
		js=(JavascriptExecutor)driver;
		WebElement element2 = driver.findElement(By.id(null));
		js.executeScript("arguments[0].scrollIntoView(false)", element2);
	}
	public static void excelRead() throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\NEW\\ExcelSheet\\Excel\\SampleDatas.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fis);

		Sheet MySheet = wb.getSheet("Datas");

		for (int i = 0; i < MySheet.getPhysicalNumberOfRows(); i++) {
			Row r = MySheet.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();

				if (cellType == 1) {
					String value = c.getStringCellValue();
					System.out.println(value);

				} else if (DateUtil.isCellDateFormatted(c)) {
					Date dd = c.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
					String format = s.format(dd);
					System.out.println(format);

				} else {
					double cellValue = c.getNumericCellValue();
					long l = (long) cellValue;
					String value = String.valueOf(l);
					System.out.println(value);
				}

			}
		}
		
	}
	public static void createExcel(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\NEW\\ExcelSheet\\Excel\\CeateFile.xlsx");
		Workbook w = new XSSFWorkbook();
		
		Sheet newSheet = w.createSheet("Datas");
		
		Row newRow = newSheet.createRow(rowNum);
		
		Cell newCell = newRow.createCell(cellNum);
	
		newCell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	
	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\NEW\\ExcelSheet\\Excel\\CeateFile.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet s = w.getSheet("Datas");
		
		Row r = s.getRow(rowNum);
		
		Cell c = r.createCell(cellNum);
	
		c.setCellValue(newData);
		
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	public static void createRow(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\NEW\\ExcelSheet\\Excel\\CeateFile.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet s = wb.getSheet("Datas");
		
		Row r = s.createRow(rowNum);
		
		Cell c = r.createCell(cellNum);
	
		c.setCellValue(newData);
		
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
}
		
		

	


