public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio;

	public MyTwitter(IRepositorioUsuario repositorio){
		this.repositorio = repositorio;
	}
}