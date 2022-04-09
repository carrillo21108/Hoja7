/**
 * 
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Scanner;

import uvg.edu.common.DictionaryController;
import uvg.edu.io.Reader;
import uvg.edu.structures.BinarySearchTree;

/**
 * @author Brian Carrillo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Instancia del scanner
		Scanner scanner = new Scanner(System.in);
		
		
		//Mensaje inicial
		System.out.println("--DICCIONARIO INGLES-ESPAÑOL-FRANCES--");
		System.out.println("Bienvenido\n");
		
		//Solicitud de la ruta del archivo. (ejemplo: C:\Users\Brian Carrillo\OneDrive\Desktop\UVG\3er semestre\Algoritmos y Estructuras de Datos\HDT2\diccionario.txt)
		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear con el diccionario de palabras.");
		String ruta = scanner.nextLine();
		
		Reader reader = new Reader(ruta);
		
		//Instancia del ArrayList con las filas obtenidas del archivo.
        ArrayList<String> filas = reader.scanTxt();
        
        //Controlador
      	DictionaryController controller = new DictionaryController(filas);
        
      	//Banderas de salida y errores
        boolean salida = false;
        boolean error = false;
        
        //Opcion de menu
        int op = 0;
        
        //Ciclo del menu
        while(!salida) {
        	do{
                //Verificacion de entrada de las opciones del menu
                try{
                    //Solicitud de opcion de menu
                	System.out.println("\nElija la opcion que necesite ejecutar");
    	            //Opciones del menú
    				System.out.println("1. Ver diccionario en ingles\n"
    								+ "2. Ver diccionario en frances\n"
    								+ "3. Traducir texto de documento\n"
    								+ "4. Ingresar nueva palabra a diccionario\n"
    								+ "5. Eliminar palabra del diccionario\n"
    								+ "6. Editar palabra del diccionario\n"
    								+ "7. Salir\n");
    	            op = scanner.nextInt();
                    error = false;

                //En caso de error
                }catch(Exception e){
                    System.out.println("Error de ingreso, intente de nuevo.\n");
                    error = true;
                //Finalmente
                }finally{
                	scanner.nextLine();
                }
            }while(error);
        	
        	switch(op){
        	case 1:
        		String resultBtsIngles = controller.listBtsIngles();
        		if(!resultBtsIngles.equals(null)) {
        			System.out.println("--DICCIONARIO INGLES--.");
        			System.out.println(resultBtsIngles);
        		}else {
        			System.out.println("El diccionario se encuentra vacio.");
        		}
        		break;
        	case 2:
        		String resultBtsFrances = controller.listBtsFrances();
        		if(!resultBtsFrances.equals(null)) {
        			System.out.println("--DICCIONARIO FRANCES--.");
        			System.out.println(resultBtsFrances);
        		}else {
        			System.out.println("El diccionario se encuentra vacio.");
        		}
        		break;
        	case 3:
        		//Solicitud de la ruta del archivo. (ejemplo: C:\Users\Brian Carrillo\OneDrive\Desktop\UVG\3er semestre\Algoritmos y Estructuras de Datos\HDT2\diccionario.txt)
        		System.out.println("Ingrese la ruta en la que se encuentra el archivo .txt a escanear con el texto a traducir.");
        		String rutaParagraph = scanner.nextLine();
        		
        		ArrayList<String>resultado = reader.scanParagraph(rutaParagraph);
        		String translation = controller.translateText(resultado);
        		
        		System.out.println(translation);
        		
        		break;
        	case 4:
        		//Solicitud de nueva palabra
        		System.out.println("Ingrese la palabra en español que desea agregar al diccionario.");
        		String palabraEspañol = scanner.nextLine();
        		
        		//Solicitud de traduccion al ingles
        		System.out.println("Ingrese la traduccion al ingles de la palabra que desea agregar al diccionario.");
        		String palabraIngles = scanner.nextLine();
        		
        		//Solicitud de traduccion al frances
        		System.out.println("Ingrese la traduccion al frances de la palabra que desea agregar al diccionario.");
        		String palabraFrances = scanner.nextLine();
        		
        		String solicitud = palabraIngles+","+palabraEspañol+","+palabraFrances;
        		
        		System.out.println(controller.addPalabra(solicitud));
        		filas.add(solicitud);
        		reader.updateTxt(ruta,filas);
        		
        		break;
        	case 5:
        		//Solicitud de palabra a eliminar
        		System.out.println("Ingrese la palabra en español que desea eliminar del diccionario.");
        		String palabraEliminar = scanner.nextLine();
        		
        		String asociacion = "";
        		
        		boolean eliminacionValida = false;
        		for(String fila:filas) {
        			String[] palabras = fila.split(",");
        			if(palabraEliminar.equals(palabras[1])) {
        				asociacion = fila;
        				System.out.println(controller.deletePalabra(asociacion));
        				eliminacionValida = true;
        			}
        		}
        		
        		if(eliminacionValida) {
        			filas.remove(asociacion);
            		reader.updateTxt(ruta,filas);
        		}else {
        			System.out.println("Palabra no valida.");
        		}
        		
        		break;
        	case 6:
        		//Solicitud de palabra a actualizar
        		System.out.println("Ingrese la palabra en español que desea actualizar del diccionario.");
        		String palabraActualizar = scanner.nextLine();
        		
        		//Solicitud de palabra actualizada
        		System.out.println("Ingrese la palabra en español actualizada que desea agregar al diccionario.");
        		String nuevaPalabra = scanner.nextLine();
        		
        		//Solicitud de traduccion al ingles
        		System.out.println("Ingrese la traduccion al ingles de la palabra actualizada que desea agregar al diccionario.");
        		String nuevaPalabraIngles = scanner.nextLine();
        		
        		//Solicitud de traduccion al frances
        		System.out.println("Ingrese la traduccion al frances de la palabra actualizada que desea agregar al diccionario.");
        		String nuevaPalabraFrances = scanner.nextLine();
        		
        		String asociacionAnterior = "";
        		
        		boolean actualizacionValida = false;
        		for(String fila:filas) {
        			String[] palabras = fila.split(",");
        			if(palabraActualizar.equals(palabras[1])) {
        				asociacionAnterior = fila;
        				controller.deletePalabra(asociacionAnterior);
        				actualizacionValida = true;
        			}
        		}
        		
        		if(actualizacionValida) {
        			filas.remove(asociacionAnterior);
            		reader.updateTxt(ruta,filas);
            		
            		String actualizado = nuevaPalabraIngles+","+nuevaPalabra+","+nuevaPalabraFrances;
            		
            		controller.addPalabra(actualizado);
            		System.out.println("Palabra ("+actualizado+") actualizada con exito.");
            		filas.add(actualizado);
            		reader.updateTxt(ruta,filas);
            		
        		}else {
        			System.out.println("Palabra actual no valida.");
        		}
        		
        		break;
        		
        	case 7:
        		//Salida
            	salida = true;
            	System.out.println("Saliendo...");
        		break;
        	default:
        		System.out.println("Opcion incorrecta. Intentelo de nuevo.");
        		break;
        	}
        }
      
	}

}
