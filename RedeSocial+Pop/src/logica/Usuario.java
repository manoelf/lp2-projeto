package logica;

import java.util.List;
import java.util.ArrayList;

import exceptions.*;

public class Usuario {
	
	private String nome;
	private String email;
	private String telefone;
	private String nascimento;
	private String senha;
	private String imagem;
	private int pop;
	private boolean estaLogado;
	private List<Usuario> amigos;
	
	public Usuario(String nome, String email, String senha, String nascimento, String telefone, String imagem) throws CadastroInvalidoException {
		if (nome == null || nome.equals("")){
			throw new CadastroInvalidoException("Nome");
		}
		if (email == null || email.equals("")) {
			throw new CadastroInvalidoException("Email");
		}
		if (senha == null || senha.equals("")) {
			throw new CadastroInvalidoException("Senha");
		}
		if (nascimento == null || nascimento.equals("")) {
			throw new CadastroInvalidoException("Nascimento");
		}
		if (telefone == null || telefone.equals("")) {
			throw new CadastroInvalidoException("Telefone");
		}
		if (imagem == null) {
			throw new CadastroInvalidoException("Imagem");
		}
		if (imagem.equals("")) {
			this.imagem = "resources/avatarDefaul.jpg";
		} else {
			this.imagem = imagem;
		}
		
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.senha = senha;
		this.pop = 0;
		this.estaLogado = false;
		this.amigos = new ArrayList<>();
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean getEstaLogado(){
		return this.estaLogado;
	}
	
	public String insereSenha(String senha) {
		return senha;
	}

	public String insereEmail(String email) {
		return email;
	}

	public void login() throws UsuarioLogadoException {
		if (this.estaLogado == false) {
			this.estaLogado = true;
		} else {
			throw new UsuarioLogadoException();
		}
	}

	public void logout() throws UsuarioDeslogadoException {
		if (this.estaLogado == true) {
			this.estaLogado = false;
		} else {
			throw new UsuarioDeslogadoException();
		}
	}

	
	//Caso de Uso3: Pesquisar e alterar informacoes do usuario
	
	public void alterarNome(String novoNome) throws LogicaException {
		if (novoNome == null || novoNome.equals("")){
			throw new LogicaException("Nome");
		}
		this.nome = novoNome;
	}
	
	public void alterarEmail(String novoEmail) throws LogicaException {
		if (novoEmail == null || novoEmail.equals("")) {
			throw new LogicaException("Email");
		}
		this.email = novoEmail;
	}
	
	public boolean alterarSenha(String senha, String novaSenha) throws LogicaException {
		if (senha == null || senha.equals("")) {
			throw new LogicaException("Senha");
		}
		
		if (novaSenha == null || novaSenha.equals("")) {
			throw new LogicaException("Senha");
		}
		
		if (this.senha.equals(senha)) {
			this.senha = novaSenha;
			return true;
		} else {
			//Lancar exception
			return false;
		}
	}
	
	
	public void alterarNascimento(String novoNascimento) throws LogicaException {
		if (novoNascimento == null || novoNascimento.equals("")) {
			throw new LogicaException("Nascimento");
		}
		this.nascimento = novoNascimento;
	}
	
	public void alterarTelefone(String novoTelefone) throws LogicaException {
		if (novoTelefone == null || novoTelefone.equals("")) {
			throw new LogicaException("Telefone");
		}
		this.telefone = novoTelefone;
	}

	public void alterarImagem(String novaImagem) throws LogicaException {
		if (novaImagem == null) {
			throw new LogicaException("Imagem");
		}
		if (novaImagem.equals("")) {
			this.imagem = "resources/avatarDefaul.jpg";
		} else {
			this.imagem = novaImagem;
		}
	}
	
	
	
}