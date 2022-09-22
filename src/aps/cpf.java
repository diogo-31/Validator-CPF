package aps;

import java.util.Scanner;

public class cpf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean menuOk = true;
		
		while(menuOk) {
			System.out.println("Esolha uma opção: \n 1 - Verificar o dígito verificador do CPF \n 2 - Informações do desenvolvedor (Matrícula e Nome do aluno) \n 3 - Sair do algoritmo ");
			int escolha = sc.nextInt();
			if (escolha == 1 ) {
				boolean verificacao = true;
				Scanner ler = new Scanner(System.in);
				
				while (verificacao) {
					System.out.println("Digite o CPF (sem os dígitos verificadores), ou seja, apenas os 9 primeiros dígitos:");
					String cpf = ler.nextLine();
					if (cpf.length() <9) {
						System.out.println("CPF inválido");
					}else {
						int DigitosFinais =DigitoVerificardor(cpf);
						System.out.println("Os 2 dígitos finais são: "+ DigitosFinais);
						verificacao = false;
					}	
				}
				menuOk = false;
			}if (escolha == 2) {
				System.out.println(" Matrícula: 1-2021119963 \n Nome do aluno: James Henrique Oliveira de Sousa ");
				menuOk = false;
			}if (escolha == 3) {
				menuOk = false;
			} else {
				System.out.println("Valeuu !");
			}
			
		}

	}

	public static int DigitoVerificardor(String digitos) {
		char digitosSeparados[] = digitos.toCharArray();
		int digitosInteiros[] = new int[11];
		
		for (int i = 0; i < digitos.length(); i++) {
			digitosInteiros[i] = Integer.parseInt(String.valueOf(digitosSeparados[i]));
		}
		
		int total = 0,contador = 0;
		
		for (int i = 10; i > 1; i--) {
			total += digitosInteiros[contador] * i;
			contador++;
		}
		
		int etapa1 = (total*10) % 11;
		int dv1;
		if (etapa1 == 10) {
			dv1 = 0;
		} else {
			dv1 = etapa1;
		}
		
		int total2 = 0, contador2 = 0;
		for (int i = 11; i > 2; i--) {
			total2 += digitosInteiros[contador2] * i;
			contador2++;
		}
		int etapa2 = (total2+dv1*2)*10 % 11;
		int dv2;
		if (etapa2 == 10) {
			dv2 = 0;
		} else {
			dv2 = etapa2;
		}
		
		int etapa3 = dv1*10 + dv2;
		return etapa3;
	}
}
