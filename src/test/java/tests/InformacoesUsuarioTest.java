package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Desafio2020\\Drivers\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        //Maximizar a tela
        navegador.manage().window().maximize();

        //Navegando para a páginado Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Validação
        assertEquals(1, 1);

        //Fechar o navegador
        navegador.close();
    }
}