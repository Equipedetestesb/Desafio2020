package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    //Declarando navegador para ser usado em todos os métodos desta classe
    private WebDriver navegador;


    //Notação para reduzir repetições dentro do código, assim antes de qualquer  @Test ele faz o que tem dentro do
    //Before
    @Before
    public void setUp(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Desafio2020\\Drivers\\chromedriver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Maximizar a tela
        navegador.manage().window().maximize();

        //Navegando para a páginado Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){


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


    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario0002(){


        //Clicar no link que possui o texto Sign in
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Clicar no campo com o name "login" que está dentro do formulário de id "signinbox"
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com o name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0002");

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox"
        formularioSignInbox.findElement(By.name("password")).sendKeys("654321");

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox" o texto "123456"

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();
        //Validar que dentro do elemento com class "me" está o texto "Hi Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio",textoNoElementoMe);

        //Validação


    }

    //Notação para reduzir repetições dentro do código, assim depois de qualquer @Test ele faz o que tem dentro do
    //After
    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.close();
    }
}