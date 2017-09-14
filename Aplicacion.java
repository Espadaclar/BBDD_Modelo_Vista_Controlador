import javax.swing.JFrame;
import java.awt.event.*;


/**
 * Las consulta a BBDD deben de hacerse con el modelo “MODELO, VISTA CONTROLADOR”.
 * Para ello, el modelo divide el código en módulos o partes y las conecta.
 * 
 * Este modelo separa 1 la lógica del programa, es decir la BBDD y todo lo que tenga que ver con los 
 * datos almacenados -->Modelo<--,  de la interface del usuario, la parte que utiliza el usuario para interactuar con 
 * el programa, ver y mandar órdenes -->Vista<--.
 * Luego hay un 3 módulo, que es el de las comunicaciones, el cual conecta al usuario con la BBDD -->Controlador<--.
 * 
 * EJ.
 * Supongamos que tenemos una aplicación que esta formada por una interfaceGráfica.
 * Y por otro lado tenemos una BBDD, esto implica que de alguna forma hemos de establecer una comunicación
 * entre ambos para poder interactuar, y lo hacemos a través de Eventos (cuando el usuario hace click en el botón).
 * 
 * En este caso se trataría de crear tres partes diferenciadas.
 * Modelo, aquí se programa todo lo que tenga que ver con los datos y su encapsulación.
 * Vista,  aquí se programa todo lo que tenga que ver con la interfaceGráfica.
 * Controlador, aquí se programa todo lo que tenga que ver con la interación entre la vista y el modelo,
 * es decir la conexión y los eventos que se producen entre ambos.
 * -----ESTAS TRES PARTES SE PODRÁN SUBDIVIDIR.
 * 
 *  ESTE PROTECTO ACCEDE A UNA BASE DE DATOS Y MEDIANTE DOS DESPLEGABLES SE SELECCIONAN VARIAS DE LOS CAMPOS QUE 
 *  OFRECE UNA TABLA SELECCIONADA, DESPUÉS DE LA SELECIÓN, PULSANDO UN BOTÓN SE MUESTRA EN UNA VENTANA TODAS LAS 
 *  FILAS DE LA TABLA QUE CONTIENEN LAS CARACTERISTICAS SELECCIONADAS.

 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     Marco_Aplicacion marco = new Marco_Aplicacion();     
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}