package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "grupodetesteseal1";
    public static final String AUTOMATE_ACCESS_KEY = "bLyad8hiCkLXENQ7JZzJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Desafio2020\\Drivers\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Maximizar a tela
        navegador.manage().window().maximize();

        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }
        //Autor Adriana Jesus Data: 31/08/2020 - Capitulo 28/29
        //Necessidade de correção - Revisar capitulo para detectar os erros
        //Alteração maior feita nesta pagina a paritr do creteBrowserStack

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "60.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10.0");
        caps.setCapability("resolution", "1200x800");
        caps.setCapability("browserstack.debug", "true");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //Maximizar a tela
            navegador.manage().window().maximize();

            //Navegando para a página do Taskit!
            navegador.get("http://www.juliodelima.com.br/taskit");
        }catch (MalformedURLException e){
            System.out.println("Houveram problemas com a URL:"+ e.getMessage());
        }
        return navegador;
    }
}
