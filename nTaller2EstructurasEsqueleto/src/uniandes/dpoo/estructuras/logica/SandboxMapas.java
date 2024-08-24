package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> listaRetorno = new ArrayList<>(mapaCadenas.values());
                Collections.sort(listaRetorno);
        

        return listaRetorno;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        llaves.sort(Collections.reverseOrder()); 
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	String menorCadena = null;
    	if (mapaCadenas.isEmpty()) 
    	{
    		return null;
    	}	
    	for (String llaveMapa : mapaCadenas.keySet()) 
    	{
    		if (menorCadena == null || llaveMapa.compareTo(menorCadena) < 0) 
    		{
    			menorCadena = llaveMapa;
    		}
     }
	return menorCadena;
    }
    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	 if (mapaCadenas.isEmpty()) 
    	 {
             return null;
         }
         return Collections.max(mapaCadenas.values());
     }
    

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	 return mapaCadenas.keySet().stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    /**
     * Retorna la cantidad de valores diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    
    	return (int) mapaCadenas.values().stream().distinct().count();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String cadenaInvertida = "";
    	for(int indice = cadena.length()-1; indice >= 0; indice--) {
    		cadenaInvertida += cadena.charAt(indice);
    	}
    	if(mapaCadenas.containsKey(cadenaInvertida)) {
    		
    	}
    	else {
    		mapaCadenas.put(cadenaInvertida, cadena);
    	}
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {	
        mapaCadenas.remove(llave);

    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	String claveAEliminar = null;
    	boolean condicion = true;
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
        	if(condicion) {
        
        		if (entry.getValue().equals(valor)) {
        			claveAEliminar = entry.getKey();
        			condicion = false;
        		}
        	}
        }
        	
        if (claveAEliminar != null) {
            mapaCadenas.remove(claveAEliminar);
            }
    }
    

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	
    	mapaCadenas.clear();
        for (Object objeto : objetos) {
            String cadena = objeto.toString();
            String cadenaInvertida = new StringBuilder(cadena).reverse().toString();
            mapaCadenas.put(cadena, cadenaInvertida);
            }
    
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	
    	Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entrada : mapaCadenas.entrySet()) {
            String llaveOriginal = entrada.getKey();
            String valor = entrada.getValue();
            String llaveEnMayusculas = llaveOriginal.toUpperCase();
            nuevoMapa.put(llaveEnMayusculas, valor);
        }
        
        mapaCadenas = nuevoMapa; 
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	 Set<String> valoresMapa = Set.copyOf(mapaCadenas.values());
         for (String elemento : otroArreglo) {
             if (!valoresMapa.contains(elemento)) {
                 return false; 
             }
         }    
         return true;
     
    }

}