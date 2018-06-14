package br.com.lambda.exemplo.interfacefuncional.exemplointernet;

public class Calculadora {

	public static Double calcular(Double op1, Double op2, OperadorDouble operador) {
		return operador.aplicar(op1, op2); // delegar para o operador
	}

}
