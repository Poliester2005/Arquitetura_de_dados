package view;

import javax.swing.*;

public class view {

	public int inicio(String fila, String fila1) {
		String[] opcoes = { "Sou paciente", "Sou medico", "Sair" };
		int opcao = JOptionPane.showOptionDialog(null,
				"Proximos a serem chamados: \n " + fila + "\nChamados anteriormente: \n " + fila1, "Inicio",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		return opcao;
	}

	public void paciente(String num) {
		JOptionPane.showMessageDialog(null, "Seu numero é: " + num, "Aviso", JOptionPane.OK_OPTION);
	}

	public void medico(String num, String nome) {
		JOptionPane.showMessageDialog(null, "O numero chamado é: " + num + "\nO nome do paciente é: " + nome, "Aviso",
				JOptionPane.OK_OPTION);
	}

	public int idade() {
		int number = 0;

		while (true) {
			try {
				String input = JOptionPane.showInputDialog("Digite sua idade:");
				number = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido. Digite um número inteiro válido.");
			}
		}
		return number;

	}

	public String nome() {
		String input = JOptionPane.showInputDialog("Digite seu nome:");
		return input;
	}

}
