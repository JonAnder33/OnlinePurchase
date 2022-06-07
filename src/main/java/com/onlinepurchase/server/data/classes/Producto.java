package com.onlinepurchase.server.data.classes;

public class Producto {
	private String nombre;
	private float precio;
	private float peso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Producto(String nombre, float precio, float peso) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
	}
	
	public Producto() {
		super();
		this.nombre = "Producto";
		this.precio = 0;
		this.peso = 0;
	}
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", peso=" + peso + "]";
	}
	
	
}
