

import java.awt.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class Marco_Aplicacion extends JFrame {

    //////////////////////////////////////////////////////////////////

    private JPanel laminaN, laminaS;
    public static JComboBox todos, todos2;
    public static JTextArea areaTexto;
    private JButton botonC;
    private JScrollPane barra;

   // private CargaJComboBoxS_Empleados carga ;
    //////////////////////////////////////////////////////////////
    public Marco_Aplicacion() {

        JPanel lamina = new JPanel();
        add(lamina);

        setBounds(500, 30, 800, 450);
        setTitle("Aplicación para BBDD_Modelo_Vista_Controlador");

        ////////////////////////////////////////////////////////////////////////////////////
        setLayout(new BorderLayout());//-----------Lamina pricipal.
        laminaN = new JPanel();// ----------lamina que alberga los ComboBox.
        todos = new JComboBox();
        todos2 = new JComboBox();
        /*todos.addItem("Oficios");
         todos2.addItem("Nuom_Depart");*/

        laminaN.add(todos);
        laminaN.add(todos2);

        areaTexto = new JTextArea(); // ----------- area donde aparecen los datos de la consulta a la BBDD.
        barra = new JScrollPane(areaTexto);

        laminaS = new JPanel(); // ---------- lamina que alberga el botón Consulta.
        botonC = new JButton(" Consulta ");
        laminaS.add(botonC);

        add(laminaN, BorderLayout.NORTH);
        add(barra, BorderLayout.CENTER);
        add(laminaS, BorderLayout.SOUTH);

        // ---DECIMOS AL MARCO QUE ESTÉ A LA ESCUCHA DE LOS EVENTOS DE VENTANA
        addWindowListener(new ControladorCargaJCombo(this));
        botonC.addActionListener(new Conexion());

        ///////////////////////////////////////////////////////////////////////////////////
        Toolkit icon = Toolkit.getDefaultToolkit();
        Image imag = icon.getImage("../iconos/a.gif");
        setIconImage(imag);

        setVisible(true);

    }

    public static String getTodos_JComboBox() {
        String empleos1 = (String) todos.getSelectedItem();
        return empleos1;
    }

    public static int getTodos2_JComboBox_Int() {
        int numerosD1 = Integer.parseInt((String) todos2.getSelectedItem());
        return numerosD1;
    }

    public static String getTodos2_JComboBox_String() {
        String numerosD1 = (String) todos2.getSelectedItem();
        return numerosD1;
    }

    public String getAreaTexto() {
        return areaTexto.getText();
    }

    public JButton getBotonC() {
        return botonC;
    }

    public static void setAreaTexto(String valor) {
        areaTexto.setText(valor);
    }

    public void setTodos_JComboBox(String tod) {
        todos.addItem(tod);
    }

    //Añade elementos al JComboBox

    public void setTodos2_JComboBox(int tod2) {
        todos2.addItem(tod2);
    }

}
