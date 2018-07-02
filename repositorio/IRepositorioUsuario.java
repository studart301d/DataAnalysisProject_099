package project_my_twitter.repositorio;

import project_my_twitter.perfil.Perfil;

public interface IRepositorioUsuario{
	public void cadastrar(Perfil usuario);
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario);
}