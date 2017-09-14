
//import controlador.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * PARA CARGAR EN UNO DE LOS JComboBox TODOS LOS OFICIOS QUE APARECEN EN LA
 * TABLA DE Empleados. -------------------------- CLASE capaz de realizar la
 * consulta necesaria a una ---------------------------BBDD y almacenar los
 * datos en un 'ResulSet'
 *
 * @author Usuario
 */
public class Tabla_Empleados extends WindowAdapter {

    private Conexion miConexion;
    private Productos_Empleados oficios = null;// para obtener el campo oficios de la tabla Empleados.

    public ResultSet rs, rs2;
    private Statement miStatement;
    private String valorColumna;

    public Tabla_Empleados() {
        miConexion = new Conexion();
        //marco2 = new Marco_Aplicacion();
    }

    /**
     * mt capaz de realizar la consulta necesaria a una BBDD y almacenar los
     * datos en un 'ResulSet'.
     *
     * @param e
     */
    public String ejecutaConsulta() {
        //valorColumna = ""; //------almacena los campos de una columna.
        Productos_Empleados miProducto = null;
        Connection conE = miConexion.dameConexion();// ---CREA LA CONEXIÓN.
        try {
            miStatement = conE.createStatement();
            //--ALMACENA EN EL ResulSet TODOS LOS OFICIOS QUE TIENE LA TABLA DE Empleados.
            rs = miStatement.executeQuery("SELECT DISTINCTROW oficio FROM empresa.empleado");
            while (rs.next()) {
                rs.previous();// previous() EVITA QUE LA SENTENCIA 'DISTINCTROW' SE SALTE EL 1º ELEMENTO DE LA TABLA.
                miProducto = new Productos_Empleados();//se crea un objeto Empleado.
                miProducto.setOficio(rs.getString(1));// asigna al objeto el valor del oficio

                return miProducto.getOficio();// este return es para que devuelva el producto nada más  crearlo.

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tabla_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miProducto.getOficio();
    }

    public int ejecutaConsulta2() {
        //valorColumna = ""; //------almacena los campos de una columna.
        Productos_Empleados miProducto = null;
        Connection conE = miConexion.dameConexion();// ---CREA LA CONEXIÓN.
        try {
            miStatement = conE.createStatement();
            rs = miStatement.executeQuery("Select DISTINCTROW depnum from empresa.empleado");
            while (rs.next()) {
                rs.previous();// previous() EVITA QUE LA SENTENCIA 'DISTINCTROW' SE SALTE EL 1º ELEMENTO DE LA TABLA.
                miProducto = new Productos_Empleados();
                miProducto.setDepnum(rs.getInt(1));

               // return miProducto.getDepnum();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tabla_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miProducto.getDepnum();
    }

}
