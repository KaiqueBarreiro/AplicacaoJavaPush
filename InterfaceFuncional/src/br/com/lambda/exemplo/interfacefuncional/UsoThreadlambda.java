package br.com.lambda.exemplo.interfacefuncional;

public class UsoThreadlambda {
	public static void main(String[] args) {
		threadJava7();
		threadJava8();
	}

	private static void threadJava7() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Executando a Thread Java 7");
			}
		});
		thread.start();
		System.out.println("Fim da execu��o da Thread Java 7");
	}

	private static void threadJava8() {
		// m�todo run() n�o recebe par�metro
		Thread thread = new Thread(() -> System.out.println("Executando a Thread Java 8"));
		thread.start();
		System.out.println("Fim da execu��o da Thread Java 8");
	}
}
