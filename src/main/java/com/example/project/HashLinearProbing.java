//package com.example.project;

import java.util.Random;

public class HashLinearProbing {
  private int hsize; // tamano de la tabla hash
  private Persona [] buckets; // array que representa la tabla hash
  //Se redefine AVAILABLE, para lo cual convertimos el minimo entero  a un string con valueOf
  private String  AVAILABLE=String.valueOf(Integer.MIN_VALUE); //el menor numero
  private int size; // cantidad de elementos en la tabla hash

  public HashLinearProbing(int hsize) {
    this.buckets = new Persona [hsize];
    this.hsize = hsize; 
    this.size = 0;
  }
  public int hashing(String key){
    int hash=0;
    for(int i=0;i< key.length();i++){
      hash = hash* key.charAt(i)+i;
      //Asi hash(123)!=hash(321)
    }
    hash = hash%hsize;
    if(hash<0){
      hash += hsize;
    }
    //El sumar, multiplicar etc hace que 123 sea igual a 321,132, y todas sus permutaciones
    //por lo que debemos modifidar algo para que cambie el resultante para las permutaciones
    System.out.println("numero has:"+hash);
    return hash;
  }

  public int hashing(int key) {
    int hash = key % hsize;
    if (hash < 0) {
      System.out.println("es negativo");
      hash += hsize;
    }
    return hash;
  }

  public void insertHash(Persona obj) {
    String key = obj.getDni();
    int hash = hashing(key);
    System.out.println(hash);

    if (isFull()) {
      System.out.println("Tabla hash esta llena!");
      return;
    }

    for (int i = 0; i < hsize; i++) {
      if (buckets[hash] == null || buckets[hash].getDni().equals(AVAILABLE) ) {
	buckets[hash] = obj;
	size++;
	return;
      }

      if (hash + 1 < hsize) {
	hash++;
      } else {
	hash = 0;
      }
    }
  }

  /*public void deleteHash(Persona key) {
    int hash = hashing(key.getDni());

    if (isEmpty()) {
      System.out.println("Tabla hash esta vacia!");
      return;
    }

    for (int i = 0; i < hsize; i++) {
      if (buckets[hash] != null && buckets[hash].equals(wrappedInt)) {
	buckets[hash] = key;
	size--;
	return;
      }

      if (hash + 1 < hsize) {
	hash++;
      } else {
	hash = 0;
      }
    }
    System.out.println("Clave " + key + " no encontrada");
  }*/

  /*public void displayHashtable() {
    for (int i = 0; i < hsize; i++) {
      if (buckets[i] == null || buckets[i] == AVAILABLE) {
	System.out.println("Celda " + i + ": Vacia");
      } else {
	System.out.println("Celda " + i + ": " + buckets[i].toString());
      }
    }
    System.out.println("*****");
  }*/

  /*public int findHash(int key) {
    Integer wrappedInt = key;
    int hash = hashing(key);

    if (isEmpty()) {
      System.out.println("Tabla hash esta vacia!");
      return -1;
    }

    for (int i = 0; i < hsize; i++) {
      try {
	if (buckets[hash].equals(wrappedInt)) {
	  buckets[hash] = AVAILABLE;
	  return hash;
	}
      } catch (Exception E) {
      }

      if (hash + 1 < hsize) {
	hash++;
      } else {
	hash = 0;
      }
    }
    System.out.println("Clave " + key + " no encontrada!");
    return -1;
  }    */

  public boolean isFull() {        
    return size == hsize;
  }

  public boolean isEmpty() {
    boolean response = true;
    for (int i = 0; i < hsize; i++) {
      if (buckets[i] != null) {
	response = false;
	break;
      }
    }
    return response;
  }

  public static void main (String[] args){
    HashLinearProbing tb = new HashLinearProbing(10);

    Random rd = new Random();

    /*for(int i = 0; i < 5; i++){
      int num = rd.nextInt(100);
      tb.insertHash(num);
      System.out.println(tb.hashing(num));
      System.out.println(tb.hashing("46788632"+i));
      
    }

    tb.displayHashtable();        
    System.out.println("buscar");
    System.out.println(tb.findHash(15));
    System.out.println(tb.findHash(47));
    tb.displayHashtable();        
    System.out.println("se termin");
    tb.deleteHash(60);
    tb.displayHashtable();        
    tb.displayHashtable();        */


  }
}
