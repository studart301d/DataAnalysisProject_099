package project_my_twitter;

import java.util.Vector;
import project_my_twitter.tweet.Tweet;
import project_my_twitter.repositorio.IRepositorioUsuario;
import project_my_twitter.perfil.*;
import project_my_twitter.exception.*;

public interface ITwitter{
	public void criarPerfil(Perfil usuario);
	public void cancelarPerfil(String usuario);
	public void tweetar(String usuario , String mensagem);
	public Vector<Tweet> timeline(String usuario);
	public Vector<Tweet> tweets(String usuario);
	public void seguir(String seguidor,String seguido);
	public int numeroSeguidores(String usuario);
	public Vector<Perfil> seguidores(String usuario);
	public Vector<Perfil> seguidos(String usuario);
}