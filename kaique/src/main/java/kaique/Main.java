package kaique;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

public class Main {

	public static void main(String[] args) {

		// Cria��o do objeto bot com as informa��es de acesso
		TelegramBot bot = new TelegramBot("SEU_TOKEN_CRIADO");

		// objeto respons�vel por receber as mensagens
		GetUpdatesResponse updatesResponse;

		// controle de off-set, isto �, a partir deste ID ser� lido as mensagens
		// pendentes na fila
		int m = 0;

		// loop infinito pode ser alterado por algum timer de intervalo curto
		// como TimerTask, Schedule, etc
		while (true) {

			// executa comando no Telegram para obter as mensagens pendentes a
			// partir de um off-set (limite inicial)
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));
			// lista de mensagens
			List<Update> updates = updatesResponse.updates();
			// an�lise de cada a��o da mensagem
			for (Update update : updates) {
				// atualiza��o do off-set
				m = update.updateId() + 1;
				Long chat_id = update.message().chat().id();
				// envio de "Escrevendo" antes de enviar a resposta
				bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
				String textoInvertido = "";
				String texto = update.message().text();
				for (int j = texto.length() - 1; j >= 0; j--) {
					textoInvertido += texto.charAt(j);
				}
				// envio da mensagem de resposta com o nome de usu�rio do
				// telegram que enviou
				String enviaMensagem = "Ol�, " + update.message().chat().firstName() + " "
						+ update.message().chat().lastName() + ". Aqui est� sua mensagem invertida: " + textoInvertido;
				bot.execute(new SendMessage(chat_id, enviaMensagem));
			}
		}
	}
}