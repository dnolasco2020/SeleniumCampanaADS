package stepDefinition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;
import testRunner.LoginPage;
import testRunner.cargarArchivo;

public class Steps {
	
	private WebDriver driver;
	LoginPage loginPage;
	cargarArchivo cargarArch;
	
	@Given("^Open the Chrome and launch the application$")				
    public void open_the_Chrome_and_launch_the_application() throws Throwable							
    {		
        System.out.println("This Step open the chrome and launch the application.");
        System.setProperty("webdriver.chrome.driver","C:/Users/dnolasco/Documents/workspace-sts-3.9.11.RELEASE/SeleniumProject/src/main/resources/webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	
    }			
	
    @When("^Enter the Username and Password$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       System.out.println("This step enter the Username and Password on the login page.");		
       loginPage = new LoginPage(driver);
       loginPage.realizarLogin("bac06557", "agricola1");
    }		

    @Then("^Enter on Campana ADS$")					
    public void enter_on_Campana_ADS() throws Throwable 							
    {   
        System.out.println("This step click on the Campaña ads.");		
        //System.out.println("This step click on the salir");	
        loginPage.clickCampana();
        
    }		

    @And("^Enter on Carga de archivo$")					
    public void enter_on_Carga_de_archivo() throws Throwable 							
    {   
        System.out.println("This step click on carga de archivos.");		
        //System.out.println("This step click on the salir");	
        cargarArch = new cargarArchivo(driver);
        cargarArch.cargandoCampana();
        
    }
   
    
}

