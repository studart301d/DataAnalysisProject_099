package project_my_twitter.exception;

public class SIException extends java.lang.Exception{
		private String usuario;
		
		public SIException(String numero) {
			this.usuario = usuario;
		}
		
		public String getUsuario() {
			return this.usuario;
		}
}