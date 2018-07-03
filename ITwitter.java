package project_my_twitter;

import java.util.Vector;
import project_my_twitter.tweet.Tweet;
import project_my_twitter.repositorio.IRepositorioUsuario;
import project_my_twitter.perfil.*;
import project_my_twitter.exception.*;

public interface ITwitter{
	public void criarPerfil(Perfil usuario) throws PEException,UJCException ;
	public void cancelarPerfil(String usuario) throws PIException, PDException;
	public void tweetar(String usuario , String mensagem) throws PIException, MFPException;
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
	public void seguir(String seguidor,String seguido) throws PIException, PDException, SIException;
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException;
	public Vector<Perfil> seguidos(String usuario) throws PIException , PDException;
}