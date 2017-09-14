import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Conexion implements ActionListener {

    private Connection miConexion;
    private Marco_Aplicacion marcoA;

    private String sentencia1 = "SELECT  oficio, depnum, nombre, dir, fechaalta, salario FROM empresa.nuevaemple WHERE oficio = ? AND depnum = ?";
    private String sentencia2 = "SELECT  oficio, depnum, nombre, dir, fechaalta, salario FROM empresa.nuevaemple WHERE oficio = ? ";
    private String sentencia3 = "SELECT  oficio, depnum, nombre, dir, fechaalta, salario FROM empresa.nuevaemple WHERE depnum = ?";
    private String datos = "\n";
    private String valorFinal = "";

    public Conexion() {

    }

    public Connection dameConexion() {
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "francisco");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miConexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //----- SERIE DE VARIABLES PARA ALMACENAR EL ELEMENTO SELECCIONADO EN LOS JComboBox.
        String valorTodos = (String) marcoA.todos.getSelectedItem();
        int valornumDep2 = (int) marcoA.todos2.getSelectedItem();

        /*if(  valornumDep != 0 ){
        System.out.println("\n 1º Departameno nº.- " + valornumDep);
        }
        // int valorDepNum = (int) marcoA.todos2.getSelectedItem();

        System.out.println(" Oficio seleccionado.- " + valorOficio+ "\n 2º Departamento nº.-  " +
        marcoA.todos2.getSelectedItem()+ "\n ----- " +valornumDep);*/
        Connection miConex = dameConexion();// --conexión con BBDD.
        if (valorTodos.equals("Oficios") && valornumDep2 == 0) {
            datos = "";
            datos += " ---- REALICE UNA SELECCIÓN.\n";

        } else {
            try {
                int valorParametroNumDepar = 1;
                // datos = "";
                if (!valorTodos.equals("Oficios") && valornumDep2 == 0) {
                    valorFinal = sentencia2;
                } else if (!valorTodos.equals("Oficios") && valornumDep2 != 0) {
                    valorFinal = sentencia1;
                    valorParametroNumDepar = 2;
                } else if (valorTodos.equals("Oficios") && valornumDep2 != 0) {
                    valorFinal = sentencia3;
                }

                PreparedStatement miStat = miConex.prepareStatement(valorFinal);// --- consulta que queremos realizar.
                int valorDepNum = (int) marcoA.todos2.getSelectedItem();
                //int valornumDep2 = (int) marcoA.todos2.getSelectedItem();

                miStat.setString(1, valorTodos);// --- carga de parámetros.
                miStat.setInt(valorParametroNumDepar, valornumDep2);

                ResultSet rs = miStat.executeQuery();
                while (rs.next()) {

                    datos += "Nombre.- " + rs.getString("nombre") + ".     Oficio.- " + rs.getString(1) + ".     FechaDeAlta.- "
                    + rs.getDate("fechaalta") + ".     Dir.-   " + rs.getInt("dir") + ".     Departamento nº.- " + rs.getInt(2) + "\n";
                    marcoA.areaTexto.append(datos + "\n");

                }
                datos += "\n";
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        marcoA.setAreaTexto(datos);
    }
}
