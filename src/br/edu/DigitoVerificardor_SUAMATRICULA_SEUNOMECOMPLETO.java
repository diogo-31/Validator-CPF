package br.edu;

import java.util.Scanner;

public class DigitoVerificardor_SUAMATRICULA_SEUNOMECOMPLETO {

	public static void main(String[] args) {
		boolean ok = true;
		Scanner ler = new Scanner(System.in);

		while (ok) {
			System.out.println("Olá, digite a opção que deseja conforme o menu abaixo:");
			System.out.println("(1)Verificar o dígito verificador do CPF");
			System.out.println("(2)Informações do desenvolvedor (Matrícula e Nome do aluno)");
			System.out.println("(3)Sair do algoritmo");

			int opcao = ler.nextInt();

			switch (opcao) {
			case 1: {
				// boolean dnv = true;
				while (ok) {
					digitoVerificador();
					System.out.println("\nDeseja fazer um novo teste?");
					System.out.println("(1)SIM      (2)NÃO");
					opcao = ler.nextInt();
					if (opcao == 2) {
						ok = false;
						System.out.println("Obrigado, volte sempre!");
					}
				}
				break;
			}
			case 2: {
				System.out.println("Você está acessando as informações do desenvolvedor: ");
				System.out.println("Nome Completo: Diogo Santos de Sousa \nMatrícula: 1-2021119478");

				System.out.println("\nDeseja voltar para o menu?");
				System.out.println("(1)SIM      (2)NÃO");
				opcao = ler.nextInt();
				if (opcao == 2) {
					ok = false;
					System.out.println("Obrigado, volte sempre!");
				}

				for (int i = 0; i < 50; ++i)
					System.out.println("");
				break;
			}
			default:
				ok = false;
				System.out.println("Obrigado, volte sempre!");
				// throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}

	}

	static void digitoVerificador() {
		Scanner ler = new Scanner(System.in);
		String CPF;
		boolean ficarNoLoop = true;

		while (ficarNoLoop) {
			System.out.println("Informe os 9 primeiros dígitos de um CPF: ");
			CPF = ler.next();
			if (validaCpf(CPF)) {
				ficarNoLoop = false;
				calculoDiv10(CPF);

				System.out.print("\nCPF completo: " + imprimeCPF(CPF));
			} else {
				System.out.println("CPF inválido!");

			}
		}
	}

	static boolean validaCpf(String CPF) {
		if (CPF.length() >= 11 || CPF.length() <= 8 || CPF == "111111111" || CPF == "222222222" || CPF == "333333333" || CPF == "444444444"
				|| CPF == "555555555" || CPF == "666666666" || CPF == "7777777" || CPF == "88888888"
				|| CPF == "999999999") {
			return false;
		}
		return true;
	}

	static int[] calculoDiv10(String cpf) {
		char arrayValores[] = cpf.toCharArray();
		int cpfLista[] = new int[11];

		for (int i = 0; i < cpf.length(); i++) {
			cpfLista[i] = Integer.parseInt(String.valueOf(arrayValores[i]));
		}

		int peso[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		int soma1 = 0;
		for (int i = 0; i < peso.length; i++) {
			soma1 = soma1 + (cpfLista[i] * peso[i]);
		}
		// soma1 recebe resto da divisão por 11
		soma1 = (soma1*10) % 11;

		if (soma1 == 10) {
			cpfLista[9] = 0;
		} else {
			cpfLista[9] = soma1;
		}
		return cpfLista;
	}

	static String calculoDiv11(String cpf, int[] lista) {
		char arrayValores[] = cpf.toCharArray();
		int cpfLista[] = new int[11];

		for (int i = 0; i < cpf.length(); i++) {
			cpfLista[i] = Integer.parseInt(String.valueOf(arrayValores[i]));
		}

		int peso[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3 };
		int soma2 = 0;
		for (int i = 0; i < peso.length; i++) {
			soma2 = soma2 + (cpfLista[i] * peso[i]);
		}

		soma2 = (lista[9] * 2 + soma2)*10 % 11;

		if (soma2 == 10) {
			cpfLista[10] = 0;
		} else {
			cpfLista[10] = soma2;
		}

		cpf = cpf + "" + lista[9] + "" + cpfLista[10];
		return cpf;
	}

	static String imprimeCPF(String CPF) {
		int cpfLista[] = calculoDiv10(CPF);
		CPF = calculoDiv11(CPF, cpfLista);

		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	
	}

}
