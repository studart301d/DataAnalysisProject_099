public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio;

	public MyTwitter(IRepositorioUsuario repositorio){
		this.repositorio = repositorio;
	}

	public void criarPerfil(Perfil usuario){
		if(Vector<Perfil>.buscar(usuario) == null){
			Vector<Perfil>.cadastrar(usuario);
		}else{
			//exceção PEException
		}
	}

	public void cancelarPerfil(String usuario){
		if(Vector<Perfil>.buscar(usuario)!=null){
			Perfil perfil = Vector<Perfil>.buscar(usuario);
			if(perfil.isAtivo()){
				perfil.setAtivo(false);
				Vector<Perfil>.atualizar(perfil);
			}else{
				//exceção PDException
			}
		}else{
			//exceção PIException
		}
	}

	public void tweetar(String usuario , String mensagem){
		if(Vector<Perfil>.buscar(usuario)!=null){
			Perfil perfil = Perfil(Vector<Perfil>.buscar(usuario));
			if(mensagem.length()>=1 && mensagem.length()<=140){
				Tweet tweet;
				tweet.setMensagem(mensagem);
			}else{
				//exceção MFPException
			}	
		}else{
			//exceção PIException
		}
	}
}