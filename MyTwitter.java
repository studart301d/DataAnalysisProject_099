package project_my_twitter;

import java.util.Vector;
import project_my_twitter.tweet.Tweet;
import project_my_twitter.repositorio.IRepositorioUsuario;
import project_my_twitter.perfil.*;

public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio; 

	public MyTwitter(IRepositorioUsuario repositorio){
		this.repositorio = repositorio;
	}

	public void criarPerfil(Perfil usuario) throws PEException{
		try{
			repositorio.cadastrar(usuario);
		}catch(UJCException ujce){
			throw new PEException(usuario.getUsuario()); //exceção PEException
		}
	}

	public void cancelarPerfil(String usuario) throws PIException, PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				perfil.setAtivo(false);
				repositorio.atualizar(perfil);
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}

	public void tweetar(String usuario , String mensagem) throws PIException, MFPException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(mensagem.length()>=1 && mensagem.length()<=140){
				Tweet tweet = new Tweet;
				tweet.setUsuario(usuario);
				tweet.setMensagem(mensagem);
				perfil.addTweet(tweet);
				Vector<Perfil> seguidores = perfil.getSeguidores();
				for(int i = 0; i<seguidores.size();i++){
					if(seguidores.get(i).isAtivo()){
						seguidores.get(i).addTweet(mensagem);
					}// Não precisa tratar os seguidores inativos
				}
			}else{
				throw new MFPException(mensagem); //exceção MFPException
			}	
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}

	public Vector<Tweet> timeline(String usuario) throws PIException, PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				return perfil.getTimeline();
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}

	public Vector<Tweet> tweets(String usuario) throws PIException, PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				Vector<Tweet> tweets = new Vector<Tweet>;
				Vector<Tweet> timeline = new Vector<Tweet>;
				timeline = timeline(usuario); // usa o metodo da propria classe pra obter a timeline do usuario
				for(int i = 0; i < timeline.size();i++){
					if(timeline.get(i).getUsuario() == usuario){// timeline é um vector de tweet
						tweets.add(timeline.get(i));			// e a class Tweet tem um getUsuario
					}
				}
				return tweets;
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}
	public void seguir(String seguidor,String seguido) throws PIException, PDException, SIException{
		if(repositorio.buscar(seguido)!=null || repositorio.buscar(seguidor)!=null){
			Perfil perfilSeguido = repositorio.buscar(seguido);
			Perfil perfilSeguidor = repositorio.buscar(seguidor);
			if(perfilSeguido.isAtivo() || perfilSeguidor.isAtivo()){
				if(seguido != seguidor ){
					perfilSeguido.addSeguidor(seguidor);
					perfilSeguidor.addSeguido(seguido);
				}else{
					throw new SIException(seguidor); //exceção SIException
				}
			}else{
				throw new PDException(seguidor); //exceção PDException
			}
		}else{
			throw new PIException(seguidor);  //exceção PIException
		}
	}
	public int numeroSeguidores(String usuario) throws PIException, PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				Vector<Perfil> seguidores = perfil.getSeguidores();
				int quantidadeSeguidoresAtivo = 0;
				for(int i = 0; i < seguidores.size(); i++) {
					if(seguidores.get(i).isAtivo()) {
						quantidadeSeguidoresAtivo++;
					}
				}
				return quantidadeSeguidoresAtivo;
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				Vector<Perfil> seguidores = uperfil.getSeguidores();
				Vector<Perfil> seguidoresAtivo = new Vector<Perfil>;
				for(int i = 0; i < seguidores.size(); i++) {
					if(seguidores.get(i).isAtivo()) {
						seguidoresAtivo.add(seguidores.get(i);
					}
				}
				return seguidoresAtivo;
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}
	public Vector<Perfil> seguidos(String usuario) throws PIException , PDException{
		if(repositorio.buscar(usuario)!=null){
			Perfil perfil = repositorio.buscar(usuario);
			if(perfil.isAtivo()){
				Vector<Perfil> seguidos = uperfil.getSeguidores();
				Vector<Perfil> seguidosAtivo = new Vector<Perfil>;
				for(int i = 0; i < seguidos.size(); i++) {
					if(seguidos[i].isAtivo()) {
						seguidosAtivo[i] = seguidos[i]
					}
				}
				return seguidosAtivo;
			}else{
				throw new PDException(usuario); //exceção PDException
			}
		}else{
			throw new PIException(usuario); //exceção PIException
		}
	}
}