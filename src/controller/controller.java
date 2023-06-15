package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class controller {
	private LinkedList<String> filaNormal;
	private LinkedList<String> filaPreferencial;
	private LinkedList<String> filaNormalNome;
	private LinkedList<String> filaPreferencialNome;
	private LinkedList<String> filaHistorico;
	private int atendimentosPreferencial;

	public controller() {
		filaNormal = new LinkedList<>();
		filaNormalNome = new LinkedList<>();
		filaPreferencial = new LinkedList<>();
		filaPreferencialNome = new LinkedList<>();
		filaHistorico = new LinkedList<>();
		atendimentosPreferencial = 0;
	}

	public String adicionarCliente(int idade, String nome) {
		Random random = new Random();
		String cliente = Integer.toString(random.nextInt(100) + 1);

		if (idade >= 60) {
			filaPreferencial.add("P" + cliente);
			filaPreferencialNome.add(nome);
			return "P" + cliente;
		} else {
			filaNormal.add("N" + cliente);
			filaNormalNome.add(nome);
			return "N" + cliente;
		}
	}

	public String atenderClienteNum() {
		if (filaNormal.isEmpty() && filaPreferencial.isEmpty()) {
			return "Fila Vazia";
		}
		if (!filaNormal.isEmpty() && atendimentosPreferencial < 3) {
			atendimentosPreferencial++;
			filaHistorico.add(filaNormal.getFirst());
			return filaNormal.removeFirst();
		} else if (!filaPreferencial.isEmpty()) {
			atendimentosPreferencial = 0;
			filaHistorico.add(filaPreferencial.getFirst());
			return filaPreferencial.removeFirst();
		}
		return " ";
	}

	public String atenderClienteNome() {
		if (filaNormalNome.isEmpty() && filaPreferencialNome.isEmpty()) {
			return "Fila Vazia";
		}
		if (!filaNormalNome.isEmpty() && atendimentosPreferencial < 3) {
			return filaNormalNome.removeFirst();
		} else if (!filaPreferencialNome.isEmpty()) {
			return filaPreferencialNome.removeFirst();
		}
		return " ";
	}

	public String getFilaHistorico() {
		if (!filaHistorico.isEmpty()) {
			return String.join(", ", this.filaHistorico);
		} else {
			return " ";
		}
	}

	public List<String> verProximosClientes(int quantidade) {
		List<String> proximosClientes = new LinkedList<>();
		int totalClientes = 0;

		for (String cliente : filaPreferencial) {
			proximosClientes.add(cliente);
			totalClientes++;

			if (totalClientes >= quantidade) {
				break;
			}
		}

		for (String cliente : filaNormal) {
			proximosClientes.add(cliente);
			totalClientes++;

			if (totalClientes >= quantidade) {
				break;
			}
		}

		return proximosClientes;
	}
}
