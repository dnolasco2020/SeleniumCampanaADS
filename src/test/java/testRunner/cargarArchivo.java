package testRunner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cargarArchivo{
	   
	public WebDriver driver;
        
	public cargarArchivo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//span[contains(text(),'Carga de archivo')]")
	private WebElement cargaArchivo;
	
	//Carga de Archivo de Campaña ADS
	@FindBy(xpath="//h2[contains(text(),'Carga de Archivo de Campaña ADS')]")
	private WebElement h2;
	
	//Datos de Formulario
	@FindBy(name="txtDescripcion")
	private WebElement descripcion;
	@FindBy(name="txtFechaInicial")
	private WebElement fechaini;
	@FindBy(name="txtFechaFinal")
	private WebElement fechafin;
	@FindBy(xpath="//input[@value='0']")
	private WebElement RetirosIlimitado;
	@FindBy(xpath="//input[@value='1']")
	private WebElement Retiroslimitado;
	@FindBy(name="txtCantidadRetiros")
	private WebElement cantRetiros;
	@FindBy(name="txtPorcentajeComision")
	private WebElement porcenComision;
	@FindBy(id="txtMinimoComision")
	private WebElement minComision;
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/section/div[2]/form/table[2]/tbody/tr[1]/td[2]/input")
	private WebElement btnSeleccionarArchivo;
	@FindBy(xpath="//*[@id=\"frmCarga\"]/table[2]/tbody/tr[2]/td/input")
	private WebElement btnCarga;
	
	public void clickADScargaArchivo() {
		cargaArchivo.click();
	}
	
	public void llenarTexto(WebElement elemento, String texto) {
		elemento.sendKeys(texto);
	}
	
	public void cargandoCampana() throws InterruptedException {
		    System.out.println("Entrar a cargado de archivo de campaña");
		 
		    cargaArchivo.click();
		if (h2.getText().trim().equals("Carga de Archivo de Campaña ADS".trim())) {
			System.out.println("Dentro de la opcion"); 
			llenarTexto(descripcion,"Campaña 20012020");
			
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtFechaInicial').removeAttribute('readonly',0);");
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtFechaInicial').removeAttribute('maxlength',0);");
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtFechaFinal').removeAttribute('readonly',0);");
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtFechaFinal').removeAttribute('maxlength',0);");
			llenarTexto(fechaini,"2020/01/21");
			Thread.sleep(1000);
			llenarTexto(fechafin,"2020/01/22");
			Thread.sleep(1000);
			RetirosIlimitado.click();
			llenarTexto(porcenComision,"2");
			llenarTexto(minComision,"0");
			btnSeleccionarArchivo.sendKeys("C:\\Users\\dnolasco\\Desktop\\Already Certificadas\\ADSCampañas\\20200120BaseclientesADS1.csv");
		    System.out.println("Archivo Seleccionado");
			//btnCarga.click();
		}
		
	}

	
}
