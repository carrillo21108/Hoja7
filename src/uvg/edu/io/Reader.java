/**
 * Clase Reader
 * @author Brian Carrillo
 *
 * En esta clase se utilizan las clases File, FileReader y BufferedReader 
 * para escanear el contenido del archivo de datos.
 */

package uvg.edu.io;

//Importacion de todas las clases de los paquetes java.util y java.io
import java.util.*;
import java.io.*;


public class Reader {
	
	//Ruta del archivo .txt
	private String ruta;

	/**
	 * Constructor
	 * @param ruta: Ruta del archivo (String)
	 */
    public Reader(String ruta){
    	this.ruta = ruta;
    }
    
    /**
     * Extrae cada una de las filas del archivo txt y las almacena en un ArrayList
     * @return ArrayList<String>: Filas del archivo
     * @see File#File(String)
     * @see FileReader#FileReader(File)
     * @see BufferedReader#BufferedReader(Reader)
     * @see ArrayList#ArrayList()
     * @see ArrayList#add(Object)
     * @see BufferedReader#readLine()
     * @see FileReader#close()
     * @see Exception#printStackTrace()
     */
    public ArrayList<String> scanTxt(){
    	
    	//Clases para el escaneo de la clase
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
        	//Creacion del bufferedreader
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del archivo
            ArrayList<String> filas = new ArrayList<String>();
            String fila;
            
            //Adicion de cada fila al ArrayList
            while((fila=br.readLine())!=null){
                filas.add(fila);
            }
            return filas;
            
        }catch(Exception e){
        	
        	//En caso no se pueda escanear el archivo
        	System.out.println("Error al escanear el archivo.");
            e.printStackTrace();
            
        }finally{
        	
            // En el finally cerramos el archivo, tanto si se leyo correctamente como si
        	// se encontro alguna excepcion.
            try{
            	//Cierre del archivo
                if( fr != null ){   
                    fr.close();     
                }                  
            }catch (Exception f){
            	//En caso el archivo no pueda ser cerrado
            	System.out.println("Error al cerrar el archivo.");
               f.printStackTrace();
            }
        }

        return null;

    }
    
    /**
     * Extrae cada una de las filas del archivo txt y las almacena en un ArrayList
     * @return ArrayList<String>: Filas del archivo
     * @see File#File(String)
     * @see FileReader#FileReader(File)
     * @see BufferedReader#BufferedReader(Reader)
     * @see ArrayList#ArrayList()
     * @see ArrayList#add(Object)
     * @see BufferedReader#readLine()
     * @see FileReader#close()
     * @see Exception#printStackTrace()
     */
    public ArrayList<String> scanParagraph(String ruta){
    	
    	//Clases para el escaneo de la clase
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
        	//Creacion del bufferedreader
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del archivo
            ArrayList<String> filas = new ArrayList<String>();
            String fila;
            ArrayList<String> resultado = new ArrayList<String>();
            
            //Adicion de cada fila al ArrayList
            while((fila=br.readLine())!=null){
            	String[]palabras = fila.split(" ");
                for(String palabra:palabras) {
                	palabra = palabra.replace(",", "");
                	palabra = palabra.replace(".", "");
                	resultado.add(palabra);
                }
            }
            return resultado;
            
        }catch(Exception e){
        	
        	//En caso no se pueda escanear el archivo
        	System.out.println("Error al escanear el archivo.");
            e.printStackTrace();
            
        }finally{
        	
            // En el finally cerramos el archivo, tanto si se leyo correctamente como si
        	// se encontro alguna excepcion.
            try{
            	//Cierre del archivo
                if( fr != null ){   
                    fr.close();     
                }                  
            }catch (Exception f){
            	//En caso el archivo no pueda ser cerrado
            	System.out.println("Error al cerrar el archivo.");
               f.printStackTrace();
            }
        }

        return null;

    }

}