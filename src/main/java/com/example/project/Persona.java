//package com.example.project;

public class Persona {
    public String DNI, nombre;

    public Persona(String DNI, String nombre){
        this.DNI = DNI;
        this.nombre = nombre;
    }
    public String getDni(){
      return DNI;
    }
    public void setDni(String dni){
      this.DNI = dni;
    }
    public String getName(){
      return this.nombre;
    }
    public String toString(){
      return nombre;
    }
}
