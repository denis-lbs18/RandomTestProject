package br.com.denisluna.randomtestproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaControleDoPonto extends TelaBase {
	private By tableDataDiaAtual = By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[1]");
	private By tableTotalHorasDiaAtual = By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[7]");
	private By tableDataDiaAnterior = By.xpath(".//*[@id='content']/table/tbody/tr[2]/td[1]");
	private By tableTotalHorasDiaAnterior = By.xpath(".//*[@id='content']/table/tbody/tr[2]/td[7]");

	public TelaControleDoPonto(WebDriver driver) {
		super(driver);
	}

	public String getDataDiaAtual() {
		return this.getElemento().elementoWebPegaTexto(this.tableDataDiaAtual);
	}

	public String getTotalHorasDiaAtual() {
		return this.getElemento().elementoWebPegaTexto(this.tableTotalHorasDiaAtual);
	}

	public String getDataDiaAnterior() {
		return this.getElemento().elementoWebPegaTexto(this.tableDataDiaAnterior);
	}

	public String getTotalHorasDiaAnterior() {
		return this.getElemento().elementoWebPegaTexto(this.tableTotalHorasDiaAnterior);
	}
}
