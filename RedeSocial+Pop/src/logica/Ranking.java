package logica;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import exceptions.LogicaException;
import logica.Usuario;
import logica.ordenacao.OrdenaDecrescente;

public class Ranking {

	private List<Usuario> comMaisPop;
	private List<Usuario> comMenosPop;
	private Comparator<Usuario> comparador;
	private List<Usuario> listaDeUsuarios;
	private final int TAMANHO_MAXIMO = 3;

	public Ranking() {

		this.comparador = new OrdenaDecrescente();
		comMaisPop = new ArrayList<Usuario>();
		comMenosPop = new ArrayList<Usuario>();
	} // fecha o cosntrutor

	public void ordenaCrescente(List<Usuario> usuarios) {
		Collections.sort(usuarios);
	}

	public void ordenaDecrescente(List<Usuario> usuarios) {
		Collections.sort(usuarios, comparador);
	}

	public String atualizaRanking(List<Usuario> listaDeUsuarios) {

		ordenaDecrescente(listaDeUsuarios);

		int cont = 0;
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (listaDeUsuarios.get(i) != null) {
				comMaisPop.add(listaDeUsuarios.get(i));
				cont++;
			}
			if (cont == 3) {
				break;
			}
		}

		if (listaDeUsuarios.size() > TAMANHO_MAXIMO) {
			ordenaCrescente(listaDeUsuarios);

			int contador = 0;
			for (int i = 0; i < listaDeUsuarios.size() - TAMANHO_MAXIMO; i++) {
				if (listaDeUsuarios.get(i) != null) {
					comMenosPop.add(listaDeUsuarios.get(i));
					contador++;
				}
				if (contador == 3) {
					break;
				}
			}

		} else{
			System.out.println("o tamanho da lista eh menor do que 3");
		}

		return toString();
	}

	@Override
	public String toString() {
		String imprime = "Mais Populares: ";

		for (int i = 0; i < comMaisPop.size(); i++) {
			imprime += " (" + (i + 1) + ")" + comMaisPop.get(i).getNome() + " " + comMaisPop.get(i).getPops();
		}
		imprime += " | Menos Populares: ";
		for (int i = 0; i < comMenosPop.size(); i++) {
			imprime +=  " (" + (i + 1) + ")" + comMenosPop.get(i).getNome() + " " + comMenosPop.get(i).getPops() ;
		}

		return imprime;

	}

} // fecha a classe ranking