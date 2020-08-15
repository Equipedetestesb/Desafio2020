package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Desafio2020\\Drivers\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Maximizar a tela
        navegador.manage().window().maximize();

        //Navegando para a páginado Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no link que possui o texto Sign in
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Clicar no campo com o name "login" que está dentro do formulário de id "signinbox"
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com o name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox" o texto "123456"

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();
        //Validar que dentro do elemento com class "me" está o texto "Hi Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio",textoNoElementoMe);

        //Validação


        //Fechar o navegador
        navegador.close();
    }
}