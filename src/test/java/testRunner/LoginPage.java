package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

	
    public WebDriver driver;
	
	private String URL = "https://portal9desa.banagricola.com/wp9desa/wps/myportal";
	@FindBy(name="username")
	@CacheLookup //almacenar en cache la variable
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\"table2\"]/tbody/tr[5]/td[2]/input")
	private WebElement btnLogin;
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/header/div[3]/div/div/ul[1]/li/span/a/img")
	private WebElement banner;
	@FindBy(xpath = "//span[contains(text(),'Campañas ADS')]")
	private WebElement adscamp;
	@FindBy(id = "logoutlink")
	private WebElement salir;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void open() {
		this.driver.get(URL);
	}
	
	public void writeUser(String value) {
		username.sendKeys(value);
	}
	
	public void writePassword(String value) {
		password.sendKeys(value);
	}
	
	public void clickEntrar() {
		btnLogin.click();
	}
	
	//public String getBannerTitle(){
		//return this.banner.getText();
	//}
	
	public void clickADSCampana() {
		adscamp.click();
	}
	public boolean validarBanner(){
		return this.banner.isDisplayed();
	}
	
	public void clickSalir() {
		salir.click();
	}
	
	public void realizarLogin(String usuario, String password) throws Exception {
		System.out.println("Metodo realizar login");
		open();
		writeUser(usuario);
		writePassword(password);
		clickEntrar();
		Thread.sleep(2000);
	}
	
	public void clickCampana() throws InterruptedException {
		open();
	    clickADSCampana();
	}
	
	public void cerrarSesion() {
		open();
		clickSalir();
	}
	
	
}
