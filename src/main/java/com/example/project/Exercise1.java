//package com.example.project;

public class Exercise1 {

    public HashLinearProbing tb;

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        obj.tb = new HashLinearProbing(100);

        obj.insertarPersona(new Persona("12345678", "Jorge Chamby"));
        obj.insertarPersona(new Persona("12345679", "Juan Perez"));
	obj.display();
        System.out.println(obj.encontrarPersona("12345678"));

        obj.eliminarPersona("12345678");
	obj.display();

        System.out.println(obj.encontrarPersona("12345679"));
    }

    public void insertarPersona(Persona obj){
      tb.insertHash(obj);
        // Llamar al metodo 'insertHash' modificado
    }

    public void eliminarPersona(String dni){
      tb.deleteHash(dni);
        // Llamar al metodo 'deleteHash' modificado
    }

    // Retorna NULL quando no se encontro el dni, y el nombre de la persona si lo encontro
    public String encontrarPersona(String dni){
      return tb.findHash(dni)==null ? "no se encontra":tb.findHash(dni).getName();
    }    
    public void display(){
      tb.displayHashtable();
    }
}
