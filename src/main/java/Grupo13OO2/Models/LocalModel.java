package Grupo13OO2.Models;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import Grupo13OO2.Entities.Empleado;

public class LocalModel {
	
	private int id;
	private String direccion;
	private float latitud;
	private float longitud;
	private int numeroTelefono;
	private Empleado empleado;
	@OneToMany
    private Set<Empleado> empleados;
	@OneToMany
	private Set<LoteModel> lotes;
	 
	public LocalModel() {}

	public LocalModel(int id, String direccion, float latitud, float longitud, int numeroTelefono, Empleado empleado
			, Set<Empleado> empleados, Set<LoteModel> lotes) {
		super();
		setId(id);
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.numeroTelefono = numeroTelefono;
		this.empleado = empleado;
		this.empleados = empleados;
		this.lotes = lotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Set<LoteModel> getLotes() {
		return lotes;
	}

	public void setLotes(Set<LoteModel> lotes) {
		this.lotes = lotes;
	}
	
	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371; //en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
		+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
		}
	

}
