package verissimo;

import controller.controller;
import view.*;

public class exec {
	public static void main(String[] args) {
		controller organizacaoFilas = new controller();
		view view1 = new view();

		while (true) {
			int var = view1.inicio(String.join(", ", organizacaoFilas.verProximosClientes(20)),
					organizacaoFilas.getFilaHistorico());
			if (var == 0) {
				String nome = view1.nome();
				int idade = view1.idade();
				view1.paciente(organizacaoFilas.adicionarCliente(idade, nome));
			} else if (var == 1) {
				view1.medico(organizacaoFilas.atenderClienteNum(), organizacaoFilas.atenderClienteNome());
			} else {
				break;
			}
		}
	}
}
