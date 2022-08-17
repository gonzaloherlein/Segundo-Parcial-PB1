package ar.edu.unlam.dominio;

import java.util.Arrays;

public class Veterinaria {

	private String nombre;
	private Atencion[] atenciones;
	private Usuario[] usuarios;

	public Veterinaria() {

	}

	public Veterinaria(String nombre, int cantidadMaximaAtenciones) {
		this.nombre = nombre;
		this.atenciones = new Atencion[cantidadMaximaAtenciones];
		this.usuarios = new Usuario[5];
	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion
	 *            Atencion que se agregara
	 * @return true en caso de exito
	 */
	public boolean registrarAtencion(Atencion atencion) {
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] == null) {
				atenciones[i] = atencion;
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id
	 *            Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 */
	public Atencion buscarAtencionPorId(int id) {
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				if (atenciones[i].getId() == id) {
					return atenciones[i];
				}
			}
		}
		return null;
	}

	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * 
	 * @return array de atenciones
	 */
	public Atencion listarAtencionesPorEspecieDeMascota(Especie especieMascota) {
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				if (atenciones[i].getEspecieMascota() == especieMascota) {
					return atenciones[i];
				}
			}
		}
		return null;
	}

	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id
	 *            Identificador de la atencion
	 * @return true en caso de exito
	 */
	public boolean eliminarAtencionPorId(int id) {
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				if (atenciones[i].getId() == id) {
					atenciones[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 */
	public int obtenerCantidadDeAtencionesRealizadas() {
		int atencionesCreadas = 0;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				atencionesCreadas++;
			}
		}
		return atencionesCreadas;
	}

	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 */
	public int obtenerCantidadDeAtencionesDisponibles(int atencionesRealizadas) {
		int atencionesDisponibles = 0;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				atencionesDisponibles = atenciones.length - atencionesRealizadas;
			}
		}
		return atencionesDisponibles;
	}

	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 */
	public double obtenerTotalDeAtenciones() {
		double total = 0.0;
		for(int i = 0; i < this.atenciones.length; i++) {
			if(this.atenciones[i] != null) {
				total+=this.atenciones[i].getMonto();
			}
		}
		return total;
	}

	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 */
	public void ordenarAtencionesPorMontoDescendente() {
		Atencion auxiliar = null;
		auxiliar = atenciones[0];
		for (int i = 1; i < atenciones.length; i++) {
			for (int j = 0; j < atenciones.length - 1; j++) {
				if (atenciones[j] != null && atenciones[j +1] != null) {
					if (atenciones[j].getMonto() < atenciones[j + 1].getMonto()){
						auxiliar = atenciones[j];
						atenciones[j] = atenciones[j+1];
						atenciones[j+1] = auxiliar;
					}
				}
			}
		}
	}

	public void mostrarAtencionesOrdenadas() {
		for(int i = 0; i < atenciones.length;i++) {
			if(atenciones[i] != null) {
				System.out.println(atenciones[i].toString());
			}	
		}
	}

	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario
	 *            Nombre de usuario del administrador
	 * @param contrasenia
	 *            Contrasenia del administrador
	 * @return verdadero en caso de exito
	 */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				if (usuarios[i].getNombreUsuario().equals(nombreUsuario)
						&& usuarios[i].getContrasenia().equals(contrasenia)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean registrarUsuario(Usuario usuario){
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = usuario;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String resultado = "";

		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				resultado += "\n" + "[" + i + "]" + atenciones[i].getNombreCliente()+" $ "+atenciones[i].getMonto();
			}
		}
		return resultado;
	}
	
}
