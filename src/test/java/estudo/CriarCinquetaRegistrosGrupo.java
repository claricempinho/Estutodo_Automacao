package estudo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;

public class CriarCinquetaRegistrosGrupo {
	private WebDriver driver;
	@Before
	public void login() {
		//Mapeando o caminho do exe do webdriver do Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Clarice\\IdeaProjects\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//Inserindo tempo de espera
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Abrir o MPE
		driver.get("http://mpe-frontend.mybluemix.net/");
		
		//Verificando finalização do cadastro
		Assert.assertEquals("Acesso à conta",driver.findElement(By.tagName("h3")).getText());
				
		//Informando email
		driver.findElement(By.id("login")).sendKeys("clarice.cruz@camss.group");
				
		//Informando senha
		driver.findElement(By.id("password")).sendKeys("1234");
				
		//Logando
		//OBSERVAÇÃO Mudar o xpath para ID
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/form/div[4]/button")).click();
		
		//Verificando se a página esta correta
		Assert.assertEquals("R$",driver.findElement(By.tagName("h3")).getText());
		
	}
	
	@Test
	public void criarCinquetaRegistrosGrupo() {
		 //Clicando no menu Gestão Financeira
        driver.findElement(By.id("menu_purchase")).click();
        WebElement ulCompra = driver.findElement(By.cssSelector("ul[aria-labelledby='menu_purchase']"));
        List<WebElement> liCompra = ulCompra.findElements(By.tagName("li"));
        for (WebElement li :liCompra){
            if (li.getText().equals("Grupos")){
                li.click();
             }
         }
        
      
      int a = 2;
      for(int i = 0; i<49; i++ ) {      	 
    	a = a+1;
    	driver.findElement(By.xpath("//*[@id='crud-title']/div[2]/button")).click();
    	driver.findElement(By.id("name")).sendKeys("Grupo"+a);      
    	//Salvando o Grupo botão Salvar
    	WebElement btSalvar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/button[1]"));
    	btSalvar.click();
    	new WebDriverWait(driver,50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div")));
    	new WebDriverWait(driver,50).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"crud-list-content\"]/div/button")));
    	    
      }
		
	}
	
	
	@After
	public void printFecharBrowser() {
		
		//variavel que recebe o local da pasta mais o nome do arquivo e o metodo que pega a data e hora do sistema
        String screensjptArquivo = "C:\\Users\\Clarice\\IdeaProjects\\print_tela\\" + Generator.dataHoraParaArquivo()+"_removerUmContatoDeUmUsuario.png";
        //chamada do metodo que tira a print da tela passando o navegador, o local e nome do arquivo
        Screenshot.tirar(driver, screensjptArquivo);
         
        //Fechando o browser
      //  driver.quit();         
		
	}

}
