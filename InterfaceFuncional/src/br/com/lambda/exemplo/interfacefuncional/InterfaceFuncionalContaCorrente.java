package br.com.lambda.exemplo.interfacefuncional;

@FunctionalInterface
public interface InterfaceFuncionalContaCorrente {
	// Por ser funcional permite somente um m�todo abstrato
	public CaixaAgencia atualizarSaldo(CaixaAgencia ctaA, double valor);
}
