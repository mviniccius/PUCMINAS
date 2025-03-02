package models;

public class Secretaria extends Usuario{

		public Secretaria(String nome, String email, String senha){
			super(nome, email, senha);
		}

		@Override
		public String toString(){
			return "===Secretaria===\n"  + nome;
		}
}
