package estudo;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;


public class CRPagar {
	@Test
	
	public void contasReceberPagar() {
		
		//Mapeando o caminho do exe do webdriver do Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Clarice\\IdeaProjects\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Inserindo tempo de espera
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Abrir o MPE
		driver.get("http://mpe-frontend.mybluemix.net/");
				
		//Verificando finaliza��o do cadastro
		Assert.assertEquals("Acesso � conta",driver.findElement(By.tagName("h3")).getText());
						
		//Informando email
		driver.findElement(By.id("login")).sendKeys("clarice.cruz@camss.group");
						
		//Informando senha
		driver.findElement(By.id("password")).sendKeys("1234");
						
		//Clicando no bot�o Entrar para logar
		//OBSERVA��O Mudar o xpath para ID
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/form/div[4]/button")).click();
				
		//Verificando se a p�gina esta correta
		Assert.assertEquals("R$",driver.findElement(By.tagName("h3")).getText());
		
		//Clicando no menu Gest�o Financeira
        driver.findElement(By.id("menu_financial")).click();
        WebElement ulGestaoFinanceira = driver.findElement(By.cssSelector("ul[class='dropdown-menu']"));
        List<WebElement> liContasReceber = ulGestaoFinanceira.findElements(By.tagName("li"));
        for (WebElement li :liContasReceber){
            if (li.getText().equals("Contas a Receber")){
                li.click();
                }
            }
                
        //Clicando em Criar
        driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
    

        //Verificando se a p�gina esta correta
        Assert.assertEquals("Valor Principal",driver.findElement(By.cssSelector("label[class='form-label control-label']")).getText());
        
        //Verificando se a pagina carregou por completo pelo botao Cancelar visevel e clicavel
        new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/div/button[2]")));
        new WebDriverWait(driver, 25).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div/div[2]/div/button[2]")));
        /*Teste:verificando se o wait funcinou
       	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/button[2]")).click();*/
        
        //Informando campo Valor Principal e Numero Documento
        driver.findElement(By.id("value")).sendKeys("10000");
        driver.findElement(By.id("document-number")).sendKeys("N001");
        
        //Clicando no campo Cliente
        driver.findElement(By.id("select2-partner-container")).click();
        
        //Esperando o dropDown pai ser aberto e clicaverl na pagina
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        
        //Esperando o dropDown filho ser criado e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-dropdown select2-dropdown--below']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-dropdown select2-dropdown--below")));
        
        //Eperando o filho ul Cliente ser carregada e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-partner-results")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.id("select2-partner-results")));
        
        //Selecionando um Cliente na ul Cliente
        WebElement ulCliente = driver.findElement(By.id("select2-partner-results"));
        List<WebElement> liCliente = ulCliente.findElements(By.tagName("li"));
        for (WebElement li :liCliente){
            if (li.getText().equals("Cliente_01")){
                li.click();
                }
            }
        
        //Clicando no campo Categoria
        driver.findElement(By.id("select2-category-container")).click();
        
        //Esperando o dropDown pai ser aberto e clicaverl na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        
        //Esperando o dropDown filho ser criado e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-dropdown select2-dropdown--below']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-dropdown select2-dropdown--below")));
        
        //Eperando o filho ul Cliente ser carregada e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-category-results")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.id("select2-category-results")));
        
        //Selecionando uma Categoria na ul Categoria
        WebElement ulCategoria = driver.findElement(By.id("select2-category-results"));
        List<WebElement> liCategoria = ulCategoria.findElements(By.tagName("li"));
        for(WebElement li:liCategoria) {
        	if(li.getText().equals("Categoria_ContasReceber")) {
        		li.click();
        		}
        	}
        
        //Clicando no campo Obra
        driver.findElement(By.id("select2-building-container")).click();
        
        //Esperando o dropDown pai ser aberto e clicaverl na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        
        //Esperando o dropDown filho ser criado e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-dropdown select2-dropdown--below']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-dropdown select2-dropdown--below")));
        
        //Eperando o filho ul Cliente ser carregada e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-building-results")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.id("select2-building-results")));
        
        //Selecionando uma Obra na ul Obra
        WebElement ulObra = driver.findElement(By.id("select2-building-results"));
        List<WebElement> liObra = ulObra.findElements(By.tagName("li"));
        for(WebElement li:liObra) {
        	if(li.getText().equals("Obra_01")) {
        		li.click();
        		}
        	}
        
        
        //INFORMANDO QUE O T�TULO FOI PAGO
        
        
        //Informando que o t�tulo foi pago clicando no switch Recebido
        driver.findElement(By.xpath("//*[@id='custom-fields']/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]")).click();
          
        //Verificando se a div principal de recebimento e form.pagamento foi inserida na pagina e se esta dispon�vel para intera��o
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='col-sm-10 col-sm-offset-2']")));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='col-sm-10 col-sm-offset-2']")));
          
        //Verificndo se a div pai Conta de Credito esta prensete na pagina 
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='col-sm-6 col-sm-offset-0']")));
          
        //Verificando se a div filha Conta de Credito esta presente na pagina
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='form-group has-error']")));
          
          
        //Clicando no campo Conta de Credito
        driver.findElement(By.id("select2-bank-container")).click();
          
        //Esperando o dropDown pai ser aberto e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
          
        //Esperando o dropDown filho ser criado e clicavel na pagina
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-dropdown select2-dropdown--below']")));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-dropdown select2-dropdown--below")));
          
        //Eperando o filho ul Conta de Cr�dito ser carregada e clicavel na pagina
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-bank-results")));
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("select2-bank-results")));
          
        //Selecionando Conta de Cr�dito
        //Alterar para List depois que o combo estiver correto
        WebElement ulContaCredito = driver.findElement(By.id("select2-bank-results"));
        WebElement liContaCredito = ulContaCredito.findElement(By.tagName("li"));
        liContaCredito.click();
          
        //Clicando no Campo Forma de Pagamento
        driver.findElement(By.id("select2-payment-form-container")).click();
          
        //Esperando o dropDown pai ser aberto e clicavel na pagina
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-container select2-container--default select2-container--open']")));
        
        // o dropDown filho ser criado e clicavel na pagina  																										
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='select2-dropdown select2-dropdown--below']")));
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='select2-dropdown select2-dropdown--below")));
          
        //Eperando o filho ul Forma de Pagamento ser carregada e clicavel na pagina
        new WebDriverWait(driver,40).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-payment-form-results")));
        new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(By.id("select2-payment-form-results")));
          
        //Selecionando Forma de Pagamento
        WebElement ulFormaPagamento = driver.findElement(By.id("select2-payment-form-results"));
        WebElement liFormaPagamento = ulFormaPagamento.findElement(By.tagName("li"));
        liFormaPagamento.click();
        
        //Informando Acr�scimo e Desconto
        driver.findElement(By.id("increase")).sendKeys("5000");
        driver.findElement(By.id("discount")).sendKeys("5000");
        
        //Salvando o Contas a Receber clicado no bot�o Salvar
        WebElement btSalvar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/button[1]"));
        if(btSalvar.isEnabled()) {
        	btSalvar.click();
        } 
             
        
        //Verificando se o t�tulo foi salvo com sucesso
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='row']")));
        WebElement assitenteSalvoSucesso = driver.findElement(By.cssSelector("div[class='message-container-after']"));
        String conteudoSalvoSucesso = assitenteSalvoSucesso.getText();
        Assert.assertEquals("Conta a Receber cadastrada com o valor de R$ 100,00 referente ao cliente Cliente_01", conteudoSalvoSucesso); 
        
       /* //Esperando o assitente informar o Saldo do dia
         new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[3]")));*/
        
              
                   
       //Cliando no bot�o Excluir do grid
       Actions moverMouse = new Actions(driver);
       WebElement botaoExcluir = driver.findElement(By.xpath("//*[@id='crud-list-content']/div/div[1]/div[1]/div[2]/div[1]/div/div/div/div[9]")); 
       moverMouse.moveToElement(botaoExcluir).build().perform();
       new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='crud-list-content']/div/div[1]/div[1]/div[2]/div[1]/div/div/div/div[9]")));
       new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='crud-list-content']/div/div[1]/div[1]/div[2]/div[1]/div/div/div/div[9]")));
       moverMouse.moveToElement(botaoExcluir).click().build().perform(); 
       
       //Confirmando a exclusao no modal Excluir
       new WebDriverWait(driver,100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]")));
       WebElement MensagemExcluir = driver.findElement(By.cssSelector("div[class='modal-body']"));
       String textoMensagemExcluir = MensagemExcluir.getText();
       Assert.assertEquals("Hey, voc� tem certeza que deseja excluir esse item? N�o haver� como recuper�-lo depois, ok?", textoMensagemExcluir);        
       driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[3]/button[1]")).click();
       
       //Verificando se t�tulo foi excluido com sucesso
       new WebDriverWait(driver,50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div")));
       WebElement assitenteMensagemExclusao = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[3]"));
       String textoassitenteMensagemExclusao = assitenteMensagemExclusao.getText();
       Assert.assertEquals("Tudo certo! Sua conta a receber foi apagada!", textoassitenteMensagemExclusao);
       
       //variavel que recebe o local da pasta mais o nome do arquivo e o metodo que pega a data e hora do sistema
       String screensjptArquivo = "C:\\Users\\Clarice\\IdeaProjects\\print_tela\\" + Generator.dataHoraParaArquivo()+"_removerUmContatoDeUmUsuario.png";
       //chamada do metodo que tira a print da tela passando o navegador, o local e nome do arquivo
       Screenshot.tirar(driver, screensjptArquivo);
               
       //Fechando o browser
       driver.quit();             
       
		
	}

}





