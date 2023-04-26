package modelo.bean;

import java.util.Date;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String mail;
	private Date antiguedad;
	
	public Cliente() {
	}

	public Cliente(String dni, String nombre, String apellido, String telefono, String mail, Date antiguedad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.antiguedad = antiguedad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", mail=" + mail + ", antiguedad=" + antiguedad + "]";
	}
	
	
	

}
