package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 	
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copiaEnteros = arregloEnteros.clone();
        return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	if (arregloCadenas != null){
    	String [] arregloCopia = arregloCadenas.clone();
        return arregloCopia;
    	}
        else {
        	return arregloCadenas;
        }
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	return arregloCadenas.length;
   	}
    

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
     public void agregarEntero(int nuevoEntero) {
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {
            nuevoArreglo[i] = arregloEnteros[i];
        }
        nuevoArreglo[arregloEnteros.length] = nuevoEntero;
        arregloEnteros = nuevoArreglo;
    }
    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	if (cadena != null) {
    	String[] nuevoArreglo = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
        nuevoArreglo[nuevoArreglo.length - 1] = cadena;
        arregloCadenas = nuevoArreglo;
    	}
    	
    
    }
    
    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {   
    	int contador = 0;
        for (int num : arregloEnteros) {
            if (num == valor) {
                contador++;                
            }    } 
        
        int[] nuevoArreglo = new int[arregloEnteros.length - contador];
        int indice = 0;
        for (int num : arregloEnteros) {
            if (num != valor) {
                nuevoArreglo[indice++] = num;
   
    	}
    }
        arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int contador = 0;
        for (String num : arregloCadenas) {
            if (cadena.equals(num)) {
                contador++;                
            }    } 
        
        String [] nuevoArreglo = new String[arregloCadenas.length - contador];
        int indice = 0;
        for (String num : arregloCadenas) {
            if (num != cadena) {
                nuevoArreglo[indice++] = num;
   
    	}
    }
        arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {if (posicion<0) {
        posicion =0; } 
    else if (posicion>arregloEnteros.length) {
        posicion = arregloEnteros.length; 
    }
    int[] arregloFinal = new int[arregloEnteros.length + 1];
    
    for (int i = 0; i < posicion; i++) {
    	arregloFinal[i] = arregloEnteros[i];
    	}
    arregloFinal[posicion] = entero;
    for (int j = posicion; j <arregloEnteros.length; j++) {
        arregloFinal[j + 1] = arregloEnteros[j];
    }
    arregloEnteros = arregloFinal;
    	}
    	


    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion ) //No entiendo pq no sale TODO
    {	
    	
        int[] nuevoArregloFinal;    	
    	if (arregloEnteros.length != 0) {
    		nuevoArregloFinal = new int[arregloEnteros.length - 1];
        }
    else {
    	nuevoArregloFinal = new int[arregloEnteros.length];
    }
    	
    	if (posicion < arregloEnteros.length && posicion > 0) {
    		for(int i = 0; i< posicion; i++) {
			nuevoArregloFinal[i] = arregloEnteros[i];
    		}
				for(int j = 1 + posicion; j< arregloEnteros.length; j++) {
					nuevoArregloFinal[j-1] = arregloEnteros[j];
    			}
				
    }
    	else {
    		if (posicion==0) {
    			int j = 0;
    			for(int i = 1; i< arregloEnteros.length; i++) {
    				nuevoArregloFinal[j] = arregloEnteros[i];
    				j ++;
    			}
    		}
    	}
    if(posicion >=0 && posicion < arregloEnteros.length) {
    arregloEnteros = nuevoArregloFinal;
    }
    
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arregloAux = new int[valores.length];
    	for(int i = 0; i < valores.length; i++) {
    		double valorDecimal = (valores[i]);
    		int nuevoValor = (int)valorDecimal;
    		arregloAux[i] = nuevoValor;
    	}
		arregloEnteros = arregloAux;

    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
     	String[] cadenaFinal = new String[objetos.length];
     	for (int i = 0; i< objetos.length; i++) {
     		String finalCad = objetos[i].toString();
     		cadenaFinal[i] = finalCad;
     	}
     	arregloCadenas = cadenaFinal;
     }     	
	

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i< arregloEnteros.length; i++) {
    		if(arregloEnteros[i] < 0) {
    			arregloEnteros[i] = arregloEnteros[i] * (-1);
    		}
    		else {
    			arregloEnteros[i] = arregloEnteros[i];
    		}
    	}

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	if (arregloEnteros != null) {
    	Arrays.sort(arregloEnteros);}
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public int organizarCadenas()
    {	
    	 Arrays.sort(arregloCadenas);  
    	 return 1;
    	 }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int contador = 0;
        for (int elements : arregloEnteros) {
        	if (elements == valor) {
        		contador++;
        	}
        }
        return contador;
    	
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int contador = 0;
        for (String elements : arregloCadenas) {
        	if (elements.toLowerCase().equals(cadena.toLowerCase()) ){
        		contador++;
        	}
        }
        return contador;
    	
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor ){ //No se aaaaaaaaaaaaaaaaaaaaaaaaaa creo que esta bien 
    	int contador = 0;
    	int identador = 0;
    	int[] arregloAux;    	
		for (int elementos : arregloEnteros){
			if(elementos == valor ) {
				contador ++;
			}
		}	
       	if (contador != 0) {
    		arregloAux = new int[contador];
    	} 	
    	else {
    		arregloAux = new int[contador];
    	}    	
		for (int j = 0; j < arregloEnteros.length; j++) {
    		if (arregloEnteros[j] == valor && identador < arregloAux.length) {
    			arregloAux[identador] = j;
    			identador++;
        		}
        		
		}
        return arregloAux;

    }
    	
        

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	int[] arregloAux = new int[2];
    	int menorComp = 0;
    	int mayorComp = 0;
    	if(arregloEnteros.length == 0) {
			return  new int[0];
			}
		else {
			for(int i = 0; i< arregloEnteros.length; i++) {
    			if(arregloEnteros[i] > mayorComp) {
    				mayorComp = arregloEnteros[i];
    			}
    			if(arregloEnteros[i] < menorComp) {
    				menorComp = arregloEnteros[i];
    				
    			}
 
    		}
    	}
    	arregloAux[0] = menorComp;
    	arregloAux[1] = mayorComp;
        return arregloAux;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> mapaResultados = new HashMap();
    	for (Integer elementos : arregloEnteros ) {
    		if (mapaResultados.containsKey(elementos)) {
    			Integer llaveEspecifica = mapaResultados.get(elementos);
    			llaveEspecifica ++;
    			mapaResultados.replace(elementos, llaveEspecifica);
    		}
    		else {
    			mapaResultados.put(elementos, 0);
    			Integer llaveEspecifica = mapaResultados.get(elementos);
    			llaveEspecifica ++;
    			mapaResultados.replace(elementos, llaveEspecifica);

    		}
    	}
        return mapaResultados;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( ){
    	HashMap<Integer, Integer> contadorRepetidos = new HashMap<Integer, Integer>();
    	int contador = 0;
    	for(int elementos : arregloEnteros) {
    		if (contadorRepetidos.containsKey(elementos) && contadorRepetidos.get(elementos) != 1) {
    			contador++;
    			contadorRepetidos.replace(elementos, 1);
    		}
    		else{
    			contadorRepetidos.put(elementos, 0);
    		}
    	}		
        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    { if (arregloEnteros.length != otroArreglo.length) {
        return false;
    	}
    else {
    	for(int i = 0; i < arregloEnteros.length; i++) {
    		if(otroArreglo[i] == arregloEnteros[i]) {
    			
    		}
    		else {
    			return false;
    		}
    	}
    }
    return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (otroArreglo.length != arregloEnteros.length) {
    		return false;
    	}
    	else {
    	for (int i =0; i >arregloEnteros.length; i++) {
    		int posicionInicial = arregloEnteros[i];
    		int contador = 0;
    		for(int j = 0 ; j < arregloEnteros.length; j++) {	
    			if(posicionInicial != otroArreglo[j] && contador!=arregloEnteros.length) {
    				j++;
    				contador ++;
    			}
    			else if (posicionInicial == otroArreglo[j]){
    				i++;
    			}
    			else {
    				return false;
    			}
    			}
    			
    			
    		}
    	}
        return true;
    }
    	

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {	
    	int[] arregloRespuesta = new int[cantidad];
    	
    	for(int i = 0; i < arregloRespuesta.length; ) {
    	int numeroAleatorio = ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    	arregloRespuesta[i] = numeroAleatorio;
    	i++;
    	
    	
    	}
    	
    	arregloEnteros = arregloRespuesta;
    }

}