package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import java.io.File;

public class Screenshot {


    public static void tirar(WebDriver driver, String arquivo){
        //pega a tela capturada do navegador como um arquivo de saida
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            //copia a tela capturada para uma local pasta
             Files.copy(screenshot, new File(arquivo));
        }catch (Exception e){
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta:"+ e.getMessage());
        }


    }
}
