package project_my_twitter.exception;

public class PIException extends java.lang.Exception {
		private String usuario;
		
		public PIException(String usuario) {
			super("Perfil inexistente");
			this.usuario = usuario;
		}
		
		public String getUsuario() {
			return this.usuario;
		}
}