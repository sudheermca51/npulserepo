package org.iitwf.hc.nexuspulse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemo_Map_Example {

	WebDriver driver;
	int i;
	Map<String,Double> actualPriceMap ;
	public void launchApp(String url)
	{

		System.out.println(i);
		System.out.println(driver);

		int i1 = 0;//local variable 
		System.out.println(i1);


		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void login(String uname,String pword)
	{
		driver.findElement(By.id("user-name")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("login-button")).click();
	}

	public List<WebElement> fetchAllProductNames()
	{

		List<WebElement> productNamesList  = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		return productNamesList;

	}
	public List<WebElement> fetchAllPrices()
	{

		List<WebElement> priceList  = driver.findElements(By.className("inventory_item_price"));
		return priceList;

	}
	public Map<String, Double> getProductPriceMap()
	{
		Map<String,Double> productPriceMap = new HashMap<String,Double>();
		System.out.println(" In this method");
		List<WebElement> productNamesList  =  fetchAllProductNames();
		List<WebElement> priceList  =  fetchAllPrices();

		for(int i=0;i<productNamesList.size();i++)
		{
			//System.out.println(productNamesList.get(i).getText() +"----"+ priceList.get(i).getText());
			productPriceMap.put(
					productNamesList.get(i).getText(),
					Double.valueOf(priceList.get(i).getText().replace("$","")));

		}
		return productPriceMap;


	}

	public String[][] readTestData(String fName) 

	{
		File f ;
		String data[][] = null;
		try 
		{
			f = new File(fName);
			XSSFWorkbook wb;

			wb = new XSSFWorkbook(f);

			XSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Rows " + rows);
			System.out.println("Cols " + cols);
			data= new String[rows][cols];

			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					XSSFRow row = sheet.getRow(i);
					XSSFCell cell = row.getCell(j);
					if(cell.getCellType()==CellType.NUMERIC)
					{
						double d = cell.getNumericCellValue();
						data[i][j] = Double.valueOf(d).toString();
						System.out.println("numeric value" + d);
					}
					else
					{
						data[i][j]=cell.getStringCellValue();
						System.out.println("Value" + cell.getStringCellValue().trim());
					}
				}

			}
		}
		catch(Exception e)
		{

		}
		finally
		{
			f=null;
		}
		return data;

	}
	@Test 
	public void validateProductPriceList() throws InvalidFormatException, IOException
	{

		launchApp("https://www.saucedemo.com/");
		login("standard_user","secret_sauce");
		Map<String,Double> actualPriceMap = getProductPriceMap();
		System.out.println("Price Map" + actualPriceMap);
		readTestData("testdata.xlsx");

	}
	@BeforeClass
	public void setUp()
	{
		launchApp("https://www.saucedemo.com/");
		login("standard_user","secret_sauce");
		actualPriceMap = getProductPriceMap();
	}

	@Test(dataProvider = "test1")
	public void validateProductPriceListDP(String pName,String pPrice) throws InvalidFormatException, IOException
	{
		try {
			Double actualPrice = actualPriceMap.get(pName);
			Double expectedPrice = Double.parseDouble(pPrice);
			Assert.assertEquals(actualPrice,expectedPrice);
		}
		catch(Exception e)
		{
			System.out.println("Unable to fetch the data for the ProductName:: " + pName);
			System.out.println("Error Message :: " + e.getMessage());
			//System.exit(0);
		}
	}


	@DataProvider(name = "test1")
	public String[][] createData() throws InvalidFormatException, IOException {

		return readTestData("testdata.xlsx");
	}	


}
