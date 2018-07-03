package project_my_twitter.repositorio;

import java.util.Vector;
import project_my_twitter.perfil.Perfil;
import project_my_twitter.exception.*;

public class VectorPerfis implements IRepositorioUsuario{
	private Vector<Perfil> perfis;

	public Vector<Perfil>(){
		this.perfis = new Vector<Perfil>();
	}

	public void cadastrar(Perfil usuario) throws UJCException{
		if(buscar(usuario.getUsuario()) == null){
			perfis.add(usuario);
		}else{
			throw new UJCException(usuario); //exceção UJCException
		}
	}

	public Perfil buscar(String usuario){
		for(int i = 0;i < perfis.lengh();i<i++){
			if(perfis.get(i.getUsuario() == usuario){
				return perfis.get(i);
			}
		}
		return null;
	}

	public void atualizar(Perfil usuario) throws UNCException{
		if(buscar(usuario.getUsuario()) != null){
			Perfil perfilDesatualizado = buscar(usuario.getUsuario());
			perfis.remove(perfilDesatualizado);
			perfis.add(usuario);
		}else{
			throw new UNCException(usuario); //exceção UNCException
		}
	}
	
}