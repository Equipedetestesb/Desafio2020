package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.*;

// Anotação com a biblioteca externa 'easytest' inserida no pom.xml para permitir execução através da estratégia DDT
@RunWith(DataDrivenTestRunner.class)
// Anotação para carregar um arquivo CSV que contém os dados do teste que repete um mesmo método e varia entradas e processos
// O arquivo CSV deve ser criado dentro da pasta 'test' inserido em um diretório de nome 'resources'
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")

// Classe usada como teste dos objetos de páginas para não alterar os primeiros testes
public class InformacoesUsuarioPageObjectsTest {
    // Declarando navegador para ser usado em todos os métodos desta classe
    private WebDriver navegador;

    // Notação para reduzir as repetições dentro do código, assim antes de qualquer @Test ele faz o que tem dentro do
    // Before
    @Before
    public void setUp(){
        // variável recebe o retorno do método criado na classe Web
        //Em 31/08/2020 Autor Adriana Jesus, com base no video do capitulo 28 Julio alterou de Web.createChome p/ createBrowserStack
        //O navegador vai recever a instancia
        navegador = Web.createBrowserStack();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            //captura dos dados do csv
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagemEsperada")String mensagemEsperada){
            //faz o fluxo de adição dos dados do usuário e recebe o retorno da mensagem de sucesso
               String textoToast = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin(login, senha)
                .clicarMe()
                .clicarMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
                .adiocionarContato(tipo, contato)
                .capturarTextoToast();

               //valida a mensagem de sucesso
        assertEquals(mensagemEsperada, textoToast);
    }
    // Notação para reduzir as repetições dentro do código, assim depois de qualquer @Test ele faz o que tem dentro do
    // After
    @After
    public void tearDown(){
        //navegador.quit();
    }
}
