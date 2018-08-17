package com.kaique.push;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	private final static String KEY_SERVIDOR = "CHAVE DO SERVIDOR FIREBASE AQUI";
	private final static String TOKEN_DSV = "INSERIR O TOKEN DO ANDROID AQUI";
	private final static String LINK_SEND = "https://fcm.googleapis.com/fcm/send";

	private static void enviarPushAplicativo(String msgEnviadaCelular, String tokenUsario, String tituloMsg,
			Integer tipoAcesso) {
		JSONObject json = new JSONObject();
		try {
			json.put("to", TOKEN_DSV);
			JSONObject data = new JSONObject();
			data.put("body", msgEnviadaCelular);
			data.put("title", tituloMsg);
			json.put("data", data);
			URL url;
			try {
				url = new URL(LINK_SEND);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "key=" + KEY_SERVIDOR);
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(json.toString().getBytes("UTF-8"));
				outputStream.close();
				conn.getInputStream();
				System.out.println("Celular notificado via Push Notification:");
			} catch (MalformedURLException ex) {
				System.out.println("Classe: PushSendNotification - Erro ao formatar JSON. " + ex.toString());
			} catch (IOException e) {
				System.out.println("Classe: PushSendNotification - Erro ao enviar Push ao android. " + e.toString());
			}
		} catch (JSONException e1) {
			System.out.println("Falha no JSON - " + e1.toString());
		}

	}

	public static void main(String[] args) {
		// Enviará mensagem para o aplicaitvo do Android Studio.
		enviarPushAplicativo("teste de msg com acento é", null, "CENTRO DE OPERAÇÕES - COPEL TELECOM", 0);
	}
}
