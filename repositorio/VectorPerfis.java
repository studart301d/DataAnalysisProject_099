package project_my_twitter.repositorio;

import java.util.Vector;
import project_my_twitter.perfil.Perfil;

public class VectorPerfis implements IRepositorioUsuario{
	private Vector<Perfil> perfis;

	public Vector<Perfil>(){
		this.perfis = new Vector<Perfil>();
	}

	public void cadastrar(Perfil usuario){
		if(buscar(usuario.getUsuario()) == null){
			perfis.add(usuario);
		}else{
			//exceção UJCException
		}
	}

	public Perfil buscar(String usuario){
		for(int i = 0;i < perfis.lengh();i<i++){
			if(perfis[i].getUsuario() == usuario){
				return perfis[i];
			}
		}
		return null;
	}

	public void atualizar(Perfil usuario){
		if(buscar(usuario.getUsuario()) != null){
			Perfil perfilDesatualizado = buscar(usuario.getUsuario());
			perfis.remove(perfilDesatualizado);
			perfis.add(usuario);
		}else{
			//exceção UNCException
		}
	}
	
}