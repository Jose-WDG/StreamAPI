package br.com.treinaweb.java.streams;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado(1, "João", 2000, "producao"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "jOSÉ", 5000, "DEV"));
		System.out.println("Lista de empregados: ");
		/*
		 * for (Empregado emp : empregados) { System.out.println(emp.getNome()); }
		 */
		empregados.stream().forEachOrdered(emp -> {
			System.out.println(emp.getNome());
		});
		double salariototal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();

		/* double salarioTotal = 0; */
		/*
		 * for (Empregado emp : empregados) { salarioTotal += emp.getSalario(); }
		 * System.out.println("Salário total: R$" + salarioTotal); }
		 */
		/*
		 * Mensageiro mensageiro = new MensageiroConsole();
		 * mensageiro.emitirMensagem("Treinaeweb!");
		 * 
		 * Mensageiro mensageiroAnonimo = new Mensageiro() {
		 * 
		 * @Override public void emitirMensagem(String mensagem) {
		 * System.out.println("Mensagem anonima: "+ mensagem);
		 * 
		 * } }; mensageiroAnonimo.emitirMensagem("De novo");
		 */
		// LAMBDA
		Mensageiro mensageiro = (mensagem) -> System.out.println("mensagem da expreção lambda:" + mensagem);
		mensageiro.emitirMensagem("treinaweb");
		// Consumer
		System.out.println("Execução do consumer: ");
		Consumer<Empregado> consumer = (emp) -> {
			System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
		};
		consumer.accept(new Empregado(10, "Gessione", 5000, "T.I"));
		
		//Functions
		System.out.println("Execução da function: ");
		Function<Empregado, Double> function = (emp) -> emp.getSalario()*10;
		double novoSalario = function.apply(new Empregado(1000, "", 1, ""));
		System.out.println(novoSalario);
	}
}