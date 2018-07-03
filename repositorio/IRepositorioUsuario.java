package project_my_twitter.repositorio;

import project_my_twitter.perfil.Perfil;
import project_my_twitter.exception.*;

public interface IRepositorioUsuario{
	public void cadastrar(Perfil usuario) throws UJCException;
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario)throws UNCException;
}