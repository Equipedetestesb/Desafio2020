package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

        //Clicar no campo com o name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // Clicar em link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // No campo de name "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("5511999999999");

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
    }

    //Notação para reduzir repetições dentro do código, assim depois de qualquer @Test ele faz o que tem dentro do
    //After
    @After
    public void tearDown(){
        //Fechar o navegador
        //navegador.close();
    }
}