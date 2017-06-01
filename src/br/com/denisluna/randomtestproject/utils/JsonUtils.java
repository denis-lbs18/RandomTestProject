package br.com.denisluna.randomtestproject.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils {
	public String url;
	public String usuario;
	public String senha;

	public JsonUtils() {
		this.abreArquivo();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void abreArquivo() {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("data/dados.json"));

			JSONObject jsonObject = (JSONObject) object;

			this.setUrl((String) jsonObject.get("url"));
			this.setUsuario((String) jsonObject.get("usuario"));
			this.setSenha((String) jsonObject.get("senha"));
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
