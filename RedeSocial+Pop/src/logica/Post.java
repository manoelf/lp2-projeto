package logica;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import util.ConverterException;
import exceptions.*;

public class Post implements Comparable<Post>, Comparator<Post> {

	private String texto;
	private LocalDateTime data;
	private String conteudo; 
	private int like;
	private int deslike;
	private int popularidade;
	private List<String> hashtags;
	private List<Midia> midias;

	// data e hora
	public Post(String texto, String data) throws PostException {
		if (texto == null || texto.trim().length() == 0) {
			// lancar Exception
		}
		
		String[] dataHorario = data.split(" ");
		String dataS = dataHorario[0];
		String horaS = dataHorario[1];
		
		if (Util.getInstancia().verificaFormatoData(dataS) == false) {
			// lanca execao data formato invalido
		}
		if (Util.getInstancia().verificaFormatoHora(horaS) == false) {
			// lanca execao data formato invalido
		}
		if (Util.getInstancia().verificaDataValida(dataS) == false) {
			// lanca excecao data invalida
		}
		if (Util.getInstancia().verificaHoraValida(horaS) == false) {
			// lanca excecao data invalida
		}

		
		this.texto = texto;
		this.popularidade = 0;
		this.like = 0;
		this.deslike = 0;
		this.hashtags = Util.getInstancia().encontraHashtag(texto);
		this.midias = new ArrayList<>();
		this.data = Util.getInstancia().converteParaData(data);
		
		buscaConteudo(texto);
		buscaMidia(texto);
		verificaTam(texto);			
	}

	private void verificaTam(String texto) throws PostException {
		String novoTexto = Util.getInstancia().encontraTexto(texto);
		if (novoTexto.length() >= 200) {
			throw new PostException(" O limite maximo da mensagem sao 200 caracteres.");
		} else {
			this.texto = texto;
		}
	}
	
	public String getDataString() {
		return this.data.toString().replace("T", " ");
	}
	
	public LocalDateTime getData() {
		return this.data;
	}
	
	public String getMidias(int indice) {
		return this.midias.get(indice).getCaminho();
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDeslike() {
		return deslike;
	}

	public void setDeslike(int deslike) {
		this.deslike = deslike;
	}

	public int getPopularidade() {
		return popularidade;
	}

	public void setPopularidade(int popularidade) {
		this.popularidade = popularidade;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}
	
	public String getConteudo() {
		return this.conteudo;
	}
	
	private void buscaConteudo(String conteudo) {
		String novoConteudo = "";
		char[] novaMsg = this.texto.toCharArray();
		for (char caracter: novaMsg) {
			if (caracter == '#' ) {
				novoConteudo = novoConteudo.substring(0, novoConteudo.length() -1);
				break;
			}
			novoConteudo += caracter;
			
		}
		this.conteudo = novoConteudo;
	} 
	
	private String getHashtagsStr() {
		String hastags = "";
		int  cont = 0;
		for(String hash: this.hashtags) {
			cont += 1;
			hastags += hash;
			if (cont < this.hashtags.size()) {
				hastags += ",";
			}
		}
		return hastags;
	}
			
	public void curtir(int pontos) {
		this.like += 1;
		this.popularidade += pontos;
	}
	
	public void descurtir(int pontos) {
		this.deslike += 1;
		this.popularidade -= pontos;
	}

 	@Override
	public int compareTo(Post outroPost) {
 		return this.data.compareTo(outroPost.getData());
 	}

	@Override
	public int compare(Post o1, Post o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getPost(String atributo) {
		if (atributo.equals("Data")) {
			return getDataString();
		} else if (atributo.equals("Conteudo")) {
			return getConteudo();
		} else if (atributo.equals("Hashtags")) {
			return getHashtagsStr();
		} else {
			return "Aqui tem que lancar exception getPost(Atributo)";
		}
	}
	
	public String getPost() {
		return this.texto + " (" + getDataString() + ")";
	}
	
	private void buscaMidia(String mensagem) {
		FactoryMidia factoryMidia = new FactoryMidia();
		List<String> listMidias = Util.getInstancia().getMidia(mensagem);
		//System.out.println(Util.getInstancia().encontraTexto(mensagem) + "-->");
		Midia mensagem2 = new Mensagem(Util.getInstancia().encontraTexto(mensagem));
		this.midias.add(mensagem2);
		for (String arquivo: listMidias) {
			this.midias.add(factoryMidia.obtemMidias(arquivo));
		}
	}
	
	public String getMidias() {
		return this.midias.toString();
	}

	public boolean comparaData(LocalDateTime outroData) {
		if (this.data.getMonth() != outroData.getMonth() &&
			this.data.getYear() != outroData.getYear() &&
			this.data.getDayOfMonth() != outroData.getDayOfMonth() ) {
				return false;
			}
		return true;		
	}
		
}