package models;

public class Usuario {
	protected String nome;
	protected String email;
	protected String senha;
	
	public Usuario(String nome ,String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	
	public String getNome(){
		return nome;
	}
	public String getEmail(){
		return email;
	}

	public boolean autenticar(String senhaDigitada){
		return this.senha.equals(senhaDigitada);
	}

	@Override
	public String toString(){
		return "===Nome===" + nome + "===Email===" + email;
	}
}
