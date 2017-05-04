package br.com.denisluna.randomtestproject.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe que trabalha com wait do WebElement, permitindo que o objeto esteja
 * clic�vel antes de executar o c�digo.
 * 
 * @author X187841
 *
 */
;

public class ElementoWebUtils {
	private WebDriver driver;

	/**
	 * Construtor da classe, recebe o WebDriver das demais classes.
	 * 
	 * @param driver
	 *            WebDriver escolhido para executar os testes
	 */
	public ElementoWebUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * retorna o codigo HTML da p�gina
	 * 
	 * @return o codigo HTML da p�gina
	 */
	public String getCodigoHTML() {
		//
		driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * Getter para o Driver do objeto.
	 * 
	 * @return o driver da classe
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * M�todo que acha a refer�ncia WebElement na p�gina. Usufrui do recurso
	 * WebDriverWait: A cada x segundos definidos pela ENUM TEMPOPOLLING, ser�
	 * efetuada uma busca pelo elemento, em at� y segundos, com timeout definido
	 * pela ENUM TEMPOWAIT
	 * 
	 * @param by
	 *            o identificador By do elemento a ser encontrado
	 * @return WebElement encontrado na p�gina atrav�s do By
	 */
	private WebElement elementoWebAchaElemento(By by) {
		WebElement elemento = (new WebDriverWait(this.getDriver(), TempoTimeouts.TEMPOWAIT))
				.withTimeout(TempoTimeouts.TEMPOWAIT, TimeUnit.SECONDS)
				.pollingEvery(TempoTimeouts.TEMPOPOLLING, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

		return elemento;
	}

	/**
	 * M�todo que executa um Thread.sleep, efetuando uma pausa no teste.
	 * 
	 * @param l
	 *            quantidade de milissegundos que o teste deve aguardar
	 */
	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * M�todo que busca clicar no elemento, impedindo que o erro "element is no
	 * longer attached to the DOM" aconte�a
	 * 
	 * @param elemento
	 *            a referencia WebElement dentro da p�gina
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 */
	private void click(WebElement elemento, By by) {
		try {
			elemento.click();
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento n�o vis�vel.");
			elemento = this.getDriver().findElement(by);
		}
	}

	/**
	 * M�todo que permite selecionar uma op��o do combobox pelo index. Seleciona
	 * o �ndice na lista e aperta o enter.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @param index
	 *            o �ndice a ser escolhido dentro do combobox
	 */
	public void elementoWebSelecionaListaPorIndex(By by, int index) {
		try {
			WebElement elemento = this.elementoWebAchaElemento(by);
			this.click(elemento, by);
			Select lista = new Select(elemento);
			lista.selectByIndex(index);

			this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
			elemento.sendKeys(Keys.ENTER);
		} catch (Exception ex) {
			System.out.println("Erro ao selecionar op��o por index.");
		}
	}

	/**
	 * metodo para sele��o de op��o em combobox
	 * 
	 * @param by
	 * @param option
	 */
	public void elementoWebSelecionaRadio(By by, int option) {
		List<WebElement> radios = driver.findElements(by);
		if (option > 0 && option <= radios.size()) {
			WebElement elemento = radios.get(option);
			// if (this.elementoWebEstaVisivelWait(elemento))
			this.click(elemento, by);
			// radios.get(option - 1).click();

		}
	}

	/**
	 * M�todo que permite selecionar uma op��o do combobox pelo texto. Seleciona
	 * o texto da lista e aplica o enter.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @param value
	 *            o texto a ser escolhido dentro do combobox
	 */
	public void elementoWebSelecionaListaPorTexto(By by, String value) {
		try {
			WebElement elemento = this.elementoWebAchaElemento(by);
			this.click(elemento, by);
			Select lista = new Select(elemento);
			lista.selectByVisibleText(value);

			this.sleep(TempoTimeouts.TEMPOPADRAOTELA);
			elemento.sendKeys(Keys.ENTER);
		} catch (Exception ex) {
			System.out.println("Erro ao selecionar op��o por texto." + ex.getClass().getSimpleName());
		}
	}

	/**
	 * M�todo que permite inserir texto em um input WebElement. Recebe como
	 * par�metros o By do elemento e o texto a ser inserido.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @param value
	 *            o texto a ser inserido dentro do cmapo de texto
	 */
	public void elementoWebInsereTexto(By by, String value) {
		this.elementoWebAchaElemento(by).sendKeys(value);
	}

	/**
	 * M�todo que permite utilizar o m�todo click() em um WebElement.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 */
	public void elementoWebClica(By by) {
		WebElement elemento = this.elementoWebAchaElemento(by);

		if (this.elementoWebEstaVisivelWait(elemento))
			this.click(elemento, by);
	}

	/**
	 * M�todo que limpa o texto do elemento web.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 */
	public void elementoWebLimpa(By by) {
		this.elementoWebAchaElemento(by).clear();
	}

	/**
	 * M�todo que retorna se elemento web est� vis�vel na tela.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto est� vis�vel ou n�o
	 */
	public boolean elementoWebEstaVisivel(By by) {
		try {
			return this.getDriver().findElement(by).isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento n�o vis�vel (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento n�o vis�vel (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println("Elemento n�o vis�vel " + ex.getMessage());
			return false;
		}
	}

	/**
	 * M�todo que retorna se elemento web est� vis�vel na tela, utilizando o
	 * recurso WebDriverWait que espera um determinado tempo at� o elemento
	 * ficar vis�vel.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto est� vis�vel ou n�o
	 */
	public boolean elementoWebEstaVisivelWait(By by) {
		try {
			WebElement elemento = this.elementoWebAchaElemento(by);
			return this.elementoWebEstaVisivelWait(elemento);
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento n�o vis�vel (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento n�o vis�vel (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println(("Elemento n�o vis�vel " + ex.getMessage()));
			return false;
		}
	}

	/**
	 * M�todo que retorna se elemento web est� vis�vel na tela.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto est� vis�vel ou n�o
	 */
	public boolean elementoWebEstaVisivelWait(WebElement elemento) {
		try {
			return elemento.isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento n�o vis�vel (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento n�o vis�vel (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println("Elemento n�o vis�vel " + ex.getMessage());
			return false;
		}
	}

	/**
	 * M�todo que retorna se elemento web est� habilitado na tela.
	 * 
	 * @param by
	 *            o identificador By do elemento a ser selecionado
	 * @return o identificador By do elemento a ser selecionado
	 */
	public boolean elementoWebEstaHabilitado(By by) {
		WebElement element = this.getDriver().findElement(by);
		return element.isEnabled();
	}

	/**
	 * M�todo que retorna se elemento web est� habilitado na tela. Recebe como
	 * par�metro o By do elemento. Utiliza o m�todo WebDriverWait
	 * 
	 * @param by
	 * @return
	 */
	public boolean elementoWebEstaHabilitadoWait(By by) {
		WebElement elemento = this.elementoWebAchaElemento(by);
		return elemento.isEnabled();
	}

	public String elementoWebPegaTexto(By by) {
		return this.elementoWebAchaElemento(by).getText();
	}

	public String elementoWebPegaAtributo(By by, String atributo) {
		return this.elementoWebAchaElemento(by).getAttribute(atributo);
	}

	public void elementoWebSelecionaDatePicker(By by, String data) {
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date date2 = null;

		try {
			date2 = dateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String dataBusca = dateFormat.format(date2);

		WebElement dateWidget = this.elementoWebAchaElemento(by);
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			if (cell.getText().equals(dataBusca)) {
				cell.click();
				break;
			}
		}
	}
}