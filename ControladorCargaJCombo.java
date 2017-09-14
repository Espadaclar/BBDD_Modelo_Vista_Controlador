import java.awt.event.*;

/**
 * PARA PODER CARGAR EL JComboBox TENEMOS QUE PASAR UN OBJETO Marco_Aplicacion A
 * ESTA CL, ---- SE LO PASAMOS EN EL CONSTRUTOR
 *
 * @author Usuario
 */
public class ControladorCargaJCombo extends WindowAdapter {

    Tabla_Empleados obj = new Tabla_Empleados();
   // Tabla_Empleados obj2 = new Tabla_Empleados();
    private Marco_Aplicacion elMarco;
    
    /**
     * para poder cargar el JComboBox de la cl  Marco_Aplicacion
     * @param elMarco para poder cargar el JComboBox de la cl  Marco_Aplicacion.
     */
    public ControladorCargaJCombo(Marco_Aplicacion elMarco) {
        this.elMarco = elMarco;
    }

    /**
     * 1º EJECUTA LA CONSULTA EN LA BBDD
     * @param e
     */
    public void windowOpened(WindowEvent e) {
        obj.ejecutaConsulta(); // 1º EJECUTA LA CONSULTA 
        elMarco.todos.addItem("Oficios");
        try {
            while (obj.rs.next()) {// ahora recorremos el ResulSet que se ha creado al invocar 'ejecutaoConsulta()'.
                elMarco.todos.addItem(obj.rs.getString(1));// colocamos en el JCombo lo almacenado en el ResulSet.
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        obj.ejecutaConsulta2(); // ya ha hallado la consulta.
        // ahora recorremos el ResulSet.
        
        elMarco.todos2.addItem(0);
        try {
            while (obj.rs.next()) {
                //elMarco.setTodos2_JComboBox(obj2.rs.getInt("depnum"));
                elMarco.todos2.addItem(obj.rs.getInt(1));
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }
}
