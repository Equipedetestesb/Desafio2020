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

        //Clicar no link que possui o texto Sign in

        //Clicar no campo com o name "login" que está dentro do formulário de id "signinbox"

        //Digitar no campo com o name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox"

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox" o texto "123456"

        //Clicar no link com o texto "SIGN IN"

        //Validar que dentro do elemento com class "me" está o texto "Hi, Julio"

        //Validação
        assertEquals(1, 1);

        //Fechar o navegador
        navegador.close();
    }
}