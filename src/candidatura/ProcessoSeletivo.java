package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSUTO" };

		for (String candidato : candidatos) {
			entrandoEmContato(candidato);
		}
	}

	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;

		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			
			if(continuarTentando) {
				tentativasRealizadas ++;
			} else {
				System.out.println("Contato Realizado com sucesso");
			}

		} while (continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com o"+ candidato +" na "+ tentativasRealizadas +"tentativa");
		}else {
			System.out.println("Não conseguimos contato com o"+ candidato +" número máximo tentativas "+ tentativasRealizadas);

		}

	}

	static boolean atender() {
		 return new Random().nextInt(3)==1;
	}

	static void imprimirSelecionados() {
		String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSUTO", "MONICA", "FABRICIO", "MIRELA",
				"DANIELA", "JORGE" };

		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

		for (int indice = 0; indice < candidatos.length; indice++) {
			System.out.println(
					"iterando com o candidato do indice " + (indice + 1) + ", com o nome " + candidatos[indice]);
		}

		System.out.println("Agora usando o for each");

		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}

	}

	static void selecaoCandidatos() {

		String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSUTO", "MONICA", "FABRICIO", "MIRELA",
				"DANIELA", "JORGE" };

		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 2000.0;

		while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {

			String candidato = candidatos[candidatosAtual];
			double valorPretendido = valorPretendido();

			System.out.println("O candidato " + candidato + " Solicitou este valor de salário: " + valorPretendido);

			if (salarioBase >= valorPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatosAtual++;
		}

	}

	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	static void analisarCandidato(double salarioPretendido) {

		double salarioBase = 2000.0;

		if (salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
		} else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");

		}

	}
}
