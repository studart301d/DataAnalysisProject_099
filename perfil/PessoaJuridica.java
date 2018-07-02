package project_my_twitter.perfil;

public class PessoaJuridica extends Perfil{

	private long cnpj;

	public PessoaFisica(String usuario){
		super(usuario);
	}

	public void setCpf(long cnpj){
		this.cnpj = cnpj;
	}

	public long getCpf(){
		return this.cnpj;
	}
}