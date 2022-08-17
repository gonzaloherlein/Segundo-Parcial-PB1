package ar.edu.unlam.dominio;

public class Usuario {
	public String nombreUsuario;
	public String contrasenia;
	
	
	public Usuario(){
		
	}
	
	public Usuario(String nombreUsuario, String contrasenia){
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
