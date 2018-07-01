public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio; //ONDE TIVER Vector<Perfil> tem que ser trocado por repositorio

	public MyTwitter(IRepositorioUsuario repositorio){
		this.repositorio = repositorio;
	}

	public void criarPerfil(Perfil usuario){
		if(repositorio.buscar(usuario) == null){
			repositorio.cadastrar(usuario);
		}else{
			//exceção PEException
		}
	}

	public void cancelarPerfil(String usuario){
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				perfil.setAtivo(false);
				repositorio.atualizar(perfil);
			}else{
				//exceção PDException
			}
		}else{
			//exceção PIException
		}
	}

	public void tweetar(String usuario , String mensagem){
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = Perfil(repositorio.buscar(usuario));
			if(mensagem.length()>=1 && mensagem.length()<=140){
				Tweet tweet = new Tweet;
				tweet.setUsuario(usuario);
				tweet.setMensagem(mensagem);
				perfil.addTweet(tweet);
				Vector<Perfil> seguidores = perfil.getSeguidors();
				for(int i = 0; i<seguidores.length();i++){
					if(seguidores[0].isAtivo()){
						seguidores[0].addTweet(mensagem);
					}// Não precisa tratar os seguidores inativos
				}
			}else{
				//exceção MFPException
			}	
		}else{
			//exceção PIException
		}
	}

	public Vector<Tweet> timeline(String usuario){
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				return perfil.getTimeline();
			}else{
				//exceção PDException
			}
		}else{
			//exceção PIException
		}
	}

	public Vector<Tweet> tweets(String usuario){
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				Vector<Tweet> tweets = new Vector<Tweet>;
				Vector<Tweet> timeline = new Vector<Tweet>;
				timeline = timeline(usuario); // usa o metodo da propria classe pra obter a timeline do usuario
				for(int i = 0; i < timeline.length();i++){
					if(timeline[i].getUsuario() == usuario){// timeline é um vector de tweet
						tweets[i] = timeline[i];			// e a class Tweet tem um getUsuario
					}
				}
				return tweets;
			}else{
				//exceção PDException
			}
		}else{
			//exceção PIException
		}
	}
}