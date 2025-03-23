// Aplicación de Pila TDA

import java.util.Scanner;  // Importa la clase Scanner para leer la entrada del usuario
import java.util.Stack;    // Importa la clase Stack para usar pilas (estructuras LIFO)

public class EditorTxt {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);       
        Stack<String> contenido = new Stack<>();        // Pila principal: guarda las líneas escritas
        Stack<String> eliminadas = new Stack<>();       // Pila secundaria: guarda líneas eliminadas (para rehacer)

        // Menú interactivo
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("      Editor Interactivo de Texto         ");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Escribe lo que desees agregar o usa un comando:");
        System.out.println("- MOSTRAR   1. Ver el texto actual");
        System.out.println("- DESHACER  2. Eliminar la última línea");
        System.out.println("- REHACER   3. Recuperar la última línea eliminada");
        System.out.println("- SALIR     4. Cerrar el editor");
        System.out.println("────────────────────────────────────────");

        // Bucle principal del programa
        while (true) {
            System.out.print("\n Ingreso: ");
            String entrada = lector.nextLine();  // Lee lo que escribe el usuario

           
            switch (entrada.toUpperCase()) {  // Convertimos a mayúsculas para evitar errores por minúsculas

                case "MOSTRAR":
                    // Muestra todo el texto actual
                    System.out.println("\n Texto actual:");
                    if (contenido.isEmpty()) {
                        System.out.println("(Sin contenido por ahora)");
                    } else {
                        for (String linea : contenido) {
                            System.out.println("- " + linea);  // Imprime cada línea almacenada
                        }
                    }
                    break;

                case "DESHACER":
                    // Elimina la última línea escrita y la guarda por si se desea rehacer
                    if (!contenido.isEmpty()) {
                        String quitada = contenido.pop();       // Saca la última línea de la pila
                        eliminadas.push(quitada);               // La guarda en la pila de deshacer
                        System.out.println("[Última línea deshecha]");
                    } else {
                        System.out.println("[No hay nada que deshacer]");
                    }
                    break;

                case "REHACER":
                    // Recupera la última línea eliminada
                    if (!eliminadas.isEmpty()) {
                        String recuperada = eliminadas.pop();   // Recupera la línea más reciente deshecha
                        contenido.push(recuperada);             // Pero la vuelve a agregar al contenido
                        System.out.println("[Línea restaurada]");
                    } else {
                        System.out.println("[Nada para rehacer]");
                    }
                    break;

                case "SALIR":
                    // Finaliza el programa
                    lector.close();                             
                    System.out.println("\n Saliendo del editor...");
                    return;                                     

                default:
                    // Si no es un comando, se considera una línea de texto normal
                    contenido.push(entrada);                    
                    eliminadas.clear();                         
                    System.out.println("[Línea agregada]");
                    break;
            }
        
        }
    }
}
 
