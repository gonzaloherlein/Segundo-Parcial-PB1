package ar.edu.unlam.dominio; 

public class Atencion{

	private int id;
	private String nombreCliente;
	private String nombreMascota;
	private Especie especieMascota; 
	private double monto;
	
	public Atencion() {
	}
	
	public  Atencion(int id, String nombreCliente, String nombreMascota, Especie especieMascota, double monto){
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.nombreMascota = nombreMascota;
		this.especieMascota = especieMascota;
		this.monto = monto;
		
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Especie getEspecieMascota() {
		return especieMascota;
	}

	public void setEspecieMascota(Especie especieMascota) {
		this.especieMascota = especieMascota;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Atencion [id=" + id + ", nombreCliente=" + nombreCliente + ", nombreMascota=" + nombreMascota
				+ ", monto=" + monto + ", especie= "+ especieMascota+"]";
	}	
	
}


