package org.vtiger.products;

import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.IPathContants;
import org.vtiger.pom.CreateNewProductsPage;
import org.vtiger.pom.ProductInformationPage;
import org.vtiger.pom.ProductPage;

public class CreateProductTest extends BaseClass {
    @Test
	public void createProductTest() {

		//fetch the data from excel file
		String sheetName = "productmodule";
		String expectedProductName = excelutility.getDataFromExcel(2, 1,sheetName )+randomNumber;

		//Creating object for the pom repo classes
		ProductPage productpage=new ProductPage();
		CreateNewProductsPage createnewproductspage=new CreateNewProductsPage();
		ProductInformationPage productinformationpage=new ProductInformationPage();

		//Create product
		commonpage.ClickProduct();
		productpage.ClickOnCreateProductBtn();
		javautility.printStatement("The Expected Product name is "+expectedProductName);
		createnewproductspage.createProduct(expectedProductName);
		createnewproductspage.clickOnSavebtn();
		//validation
		String actualProductName =productinformationpage.getActualProductName();
		javautility.printStatement("The Actual Product name is "+actualProductName);
		if(actualProductName.equals(expectedProductName)) {
			javautility.printStatement("The Product name is created==>Test case is pass");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS1);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}
		else {
			javautility.printStatement("The Product name is not created===>Test case is fail");
			excelutility.setDataIntoExcel(sheetName,2,3,IPathContants.VTIGERSTATUS2);
			excelutility.saveOutputIntoExcel(IPathContants.VTIGEREXCELFILEPATH);
			javautility.printStatement("The data is entered");
		}

	}

}
