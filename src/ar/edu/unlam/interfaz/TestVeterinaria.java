package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Atencion;
import ar.edu.unlam.dominio.Especie;
import ar.edu.unlam.dominio.Usuario;
import ar.edu.unlam.dominio.Veterinaria;

public class TestVeterinaria {

	private static final int SALIR = 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);

		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CANTIDAD_MAXIMA_ATENCIONES);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case 1:
				// Registra una atencion con los datos ingresados por el
				// empleado e informa el resultado
				crearAtencion(teclado, veterinaria);
				break;
			case 2:
				// Se solicita el ingreso del id y se muestra la informacion de
				// la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				buscarAtencionPorId(veterinaria);
				break;
			case 3:
				// Ingresar la especie de mascota para listar las atenciones que
				// correspondan.
				// Si no hay atenciones indicar lo propio
				listarAtencionesPorEspecie(veterinaria);
				break;
			case 4:
				// Se solicita el ingresdo del id de la atencion y se elimina.
				// Indicar el
				// resultado de la operacion
				eliminarAtencionPorDni(veterinaria);
				break;
			case 5:
				// Listar las atenciones realizadas y las disponibles
				listarAtencionesRealizadasYDisponibles(veterinaria);
				break;
			case 6:
				// Informar el total de todas las atenciones realizadas. Debe
				// inciar sesión para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu
				// principal.
				informarTotalAtencionesRealizadas(veterinaria);
				break;
			case 7:
				// Informar por pantalla atenciones ordenadas en forma
				// decreciente. Si no hay atenciones mostrar un mensaje
				// aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu
				// principal.
				informarAtencionesOrdenadasDecreciente(veterinaria);
				break;
			case 8:
				//INICIAR SESION
				iniciarSesion(veterinaria);
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");
				break;
			}

		} while (opcion != SALIR);

		teclado.close();
	}

	private static Usuario iniciarSesion(Veterinaria veterinaria) {
		System.out.println("Ingrese el nombre de usuario");
		String nombreUsuario = teclado.next();
		System.out.println("Ingrese la contrasenia");
		String contrasenia = teclado.next();
		
		Usuario usuario = new Usuario(nombreUsuario, contrasenia);
		if(veterinaria.registrarUsuario(usuario)){
			System.out.println("Ha registrado un usuario");
		}
		return usuario;
		
	}

	private static void informarAtencionesOrdenadasDecreciente(Veterinaria veterinaria) {
		System.out.println("Ingrese el nombre de usuario: ");
		String nombreDeUsuario = teclado.next();

		System.out.println("Ingrese la contrasenia: ");
		String contrasenia = teclado.next();
		if (veterinaria.iniciarSesion(nombreDeUsuario, contrasenia)) {
			System.out.println("Ha iniciado sesion correctamente");
			veterinaria.ordenarAtencionesPorMontoDescendente();
			veterinaria.mostrarAtencionesOrdenadas();
		    
		} else {
			System.out.println("Vuelva a intentarlo");
		}
	}

	private static void informarTotalAtencionesRealizadas(Veterinaria veterinaria) {
		System.out.println("Ingrese el nombre de usuario: ");
		String nombreDeUsuario = teclado.next();

		System.out.println("Ingrese la contrasenia: ");
		String contrasenia = teclado.next();

		if (veterinaria.iniciarSesion(nombreDeUsuario, contrasenia)) {
			System.out.println("Ha iniciado sesion correctamente");
			System.out.println("Se han realizado " + veterinaria.obtenerCantidadDeAtencionesRealizadas());
		} else {
			System.out.println("Vuelva a intentarlo");
		}

	}

	private static void listarAtencionesRealizadasYDisponibles(Veterinaria veterinaria) {
		int atencionesRealizadas = veterinaria.obtenerCantidadDeAtencionesRealizadas();
		if(atencionesRealizadas != 0){
			System.out.println("Se han realizado "+atencionesRealizadas);
			System.out.println("Las atenciones disponbles son: "+ veterinaria.obtenerCantidadDeAtencionesDisponibles(atencionesRealizadas));
		}
	}

	private static void eliminarAtencionPorDni(Veterinaria veterinaria) {
		System.out.println("Ingrese el ID de la atencion a eliminar:");
		int id = teclado.nextInt();

		if (veterinaria.eliminarAtencionPorId(id)) {
			System.out.println("Se ha eliminado la atencion");
		} else {
			System.out.println("Vuelva a intentarlo");
		}

	}

	private static void listarAtencionesPorEspecie(Veterinaria veterinaria) {
		System.out.println("Ingrese la especie de la mascota");
		System.out.println("1-PERRO " + "2-GATO " + "3-AVE");
		int opcionSeleccionada = teclado.nextInt();

		Especie especie = Especie.values()[opcionSeleccionada - 1];
		if (veterinaria.listarAtencionesPorEspecieDeMascota(especie) != null) {
			System.out.println("Se ha listado las atenciones");
			System.out.println(veterinaria.listarAtencionesPorEspecieDeMascota(especie).toString());
		} else {
			System.out.println("No se ha podido listar las atenciones");
		}
	}

	private static void buscarAtencionPorId(Veterinaria veterinaria) {
		System.out.println("Ingrese el id de lam atencion: ");
		int id = teclado.nextInt();

		if (veterinaria.buscarAtencionPorId(id) != null) {
			System.out.println(veterinaria.buscarAtencionPorId(id).toString());
		} else {
			System.out.println("No se ha encontrado la atencion");
		}

	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad
	 * deseada
	 * 
	 * @param teclado
	 *            Para el ingreso de datos
	 * @return opcion seleccionada
	 */
	private static int seleccionarOpcion(Scanner teclado) {

		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar una atencion ");
		mostrarMensaje("2 - Buscar atencion por su identificador unico");
		mostrarMensaje("3 - Listar atenciones por una especie determinada");
		mostrarMensaje("4 - Eliminar una atencion por su id");
		mostrarMensaje("5 - Informar la cantidad de atenciones realizadas y las disponibles");
		mostrarMensaje("6 - Infomar el total de todas las atenciones realizadas [Requiere iniciar sesion]");
		mostrarMensaje("7 - Listar atenciones por monto descendente [Requiere iniciar sesion]");
		mostrarMensaje("8 - Iniciar Sesion");
		mostrarMensaje("\n9 - Salir");
		
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}

	/**
	 * Solicita el ingreso de la informacion para crear una atencion y la crea
	 * 
	 * @param teclado
	 *            Para el ingreso de datos
	 */
	private static boolean crearAtencion(Scanner teclado, Veterinaria veterinaria) {
		System.out.println("Ingrese el id de la atencion: ");
		int id = teclado.nextInt();
		System.out.println("Ingrese el nombre del Cliente: ");
		String nombreCliente = teclado.next();
		System.out.println("Ingese el nombre de la mascota: ");
		String nombreMascota = teclado.next();
		System.out.println("Ingrese la especie de la mascota: ");
		System.out.println("1-PERRO " + "2-GATO " + "3-AVE");
		int opcionSeleccionada = teclado.nextInt();

		Especie especie = Especie.values()[opcionSeleccionada - 1];
		System.out.println("Ingrese el monto: $");
		double monto = teclado.nextDouble();
		Atencion atencion = new Atencion(id, nombreCliente, nombreMascota, especie, monto);
		if (veterinaria.registrarAtencion(atencion)) {
			System.out.println("Se ha registrado la atencion correctamente");
			return true;
		} else {
			System.out.println("Vuelva a intentarlo");
		}
		return false;
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
