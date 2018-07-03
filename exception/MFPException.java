package project_my_twitter.exception;

public class MFPException extends java.lang.Exception{
	private String mensagem;
	
	public MFPException (String mensagem) {
		super("Mensagem grande");
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
}