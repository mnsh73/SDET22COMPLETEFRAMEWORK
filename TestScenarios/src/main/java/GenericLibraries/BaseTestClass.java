package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vitiger.pom.HomePage;
import com.vitiger.pom.LoginPage;
/**
 * this class contains basic configuration annotations of TestNG
 * @author MANISH
 *
 */


public class BaseTestClass implements IpathConstant
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtility file = new FileUtility();
	public ExelUtility eutil= new ExelUtility();
	public JavaUtility j= new JavaUtility();
	public WebDriverUtility utility = new WebDriverUtility();
	public DataBaseUtility dbutil= new DataBaseUtility();
	
	/**
	 * This statements will be executed for just one time
	 * incase no permission is availale for DataBase disable the connection statement
	 *
	 * @throws Throwable
	 */
	@BeforeSuite(groups= {"smokeTest","regression"})
	public void createconnnectionWithDatabase() throws Throwable
	{
		//dbutil.connectionToDB();
		System.out.println("==========Connection DataBase Successful========");
		
	}
	
	/**
	 * this statements will be executed fo every class
	 * @throws Throwable
	 */
	
	
// for parallel crossBrowser execution we need to create a @BeforeTest annotation  method and implement it 
	//it can be done directly also by implementing it before class wit @parameter , 
		//instead of implementing @parameter inside the Better write it directly
	//Parameters should be imported from TestNg only
	
	@Parameters(value = {"browser"})//Chrome or FireFox
	
	@BeforeClass(groups= {"smokeTest","regression"})
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Throwable
	{
		
		System.out.println("Launching Browser"+BROWSER);
		// read Data from Property File
		//String BROWSER = file.getPropertyKeyValue("browser");
		String URL= file.getPropertyKeyValue("url");
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("internetexplorer"))
		{
			driver = new InternetExplorerDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		sdriver = driver;
		driver.manage().window().maximize();
		driver.get(URL);
		utility.waitUntillPageLoad(driver);
		
	}
/**
 * This method will be executed before every test method 
 * and the it will login to application by default
 * @throws Throwable
 */
	
	@BeforeMethod(groups= {"smokeTest","regression"})
	public void OpenApp() throws Throwable
	
	{
		String USERNAME= file.getPropertyKeyValue("username");
		String PASS= file.getPropertyKeyValue("password");
		LoginPage login = new LoginPage(driver);		
		login.loginApp(USERNAME ,PASS);
		System.out.println("=======LogIn SuccessFull=========");
				
	}
	
/**
 * This method will be executed to after every test method and it will logout from the page 
 * also will take photo for every failed case
 * @param r
 * @throws Throwable
 */
	@AfterMethod(groups= {"smokeTest","regression"})
	
	public void logOut(ITestResult r) throws Throwable
	{
		/** int status = r.getStatus();
		String name = r.getName();
		if (status==2)
		{
			Screenshot s = new Screenshot();
			s.getPhoto(driver, name);
			
		}*/
		
		//signOut of Home Page
		HomePage hp = new HomePage(driver);
		hp.signout();
		System.out.println("========Sign Out Succesfull==========");
		driver.quit();		
	}
	/**
	 * It will close the browser after execution of every class
	 */
	@AfterClass(groups= {"smokeTest","regression"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("=====Broser closed successfully ========");		
	}
	
	
	/**
	 * it will close the Connection with the DataBase and statement will be executed just once 
	 * after the execution of the complete suite
	 * @throws Throwable
	 */
	@AfterSuite(groups= {"smokeTest","regression"})
	public void closeDB() throws Throwable
	{
		//dbutil.closeDB();
		System.out.println("The connection gotclosed successfully");
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

}
