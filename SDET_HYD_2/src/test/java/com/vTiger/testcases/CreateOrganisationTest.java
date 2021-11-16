package com.vTiger.testcases;

import org.testng.annotations.Test;

import com.vtiger.genericutils.BaseClass;
import com.vtiger.genericutils.ExcelUtility;
import com.vtiger.objectRepository.CreateOrganisation;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganisationInfo;
import com.vtiger.objectRepository.OrganisationPage;
import com.vtiger.genericutils.JavaUtility;

public class CreateOrganisationTest extends BaseClass{

	@Test
	public void createOrganisationTest() throws Throwable
	{
		ExcelUtility eUtil=new ExcelUtility();
		String orgName = eUtil.excelUtility("Sheet1",1 , 2)+"_"+JavaUtility.generateRandomNumber();

		//Create Organisation
		hp=new HomePage(driver);
		hp.clickOnOrganisation();
		
		OrganisationPage op=new OrganisationPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrgName(orgName);

		OrganisationInfo oi=new OrganisationInfo(driver);
		oi.verifyOrgName(orgName);
	}

}
