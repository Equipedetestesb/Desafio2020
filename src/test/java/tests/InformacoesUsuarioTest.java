package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

//Anotação com a biblioteca externa 'easytest' inserida no pom.xml para permitir execução através da estratégia DDT
@RunWith(DataDrivenTestRunner.class)
//Anotação para carregar um arquivo CSV que contém os dados do teste que repete um mesmo método e varia entradas e saídas
//O arquivo CSV deve ser criado dentro da pasta 'test' inserido em um diretório de nome 'resources'
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {
    //Declarando navegador para ser usado em todos os métodos desta classe
    private WebDriver navegador;

    //Utilizado para invocar o nome da classe do @Test
    @Rule
    public TestName test = new TestName();


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

        //Clicar no link que possue a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada){

        //Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde está o formulário de id
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name "contact" digitar "+5571991234567"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);

    }

    @Test
    public void removerUmContatoDeUmUsuario(){

        //Clicar no elemento pelo seu xpath //span[text()="71988099999"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+5561989874757\"]/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);

        String screenshotArquivo = "/C:/Desafio2020/evidencias/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Clicar no link com texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    //Notação para reduzir repetições dentro do código, assim depois de qualquer @Test ele faz o que tem dentro do
    //After
    @After
    public void tearDown(){
        //Fechar o navegador
        // navegador.close();
    }
}