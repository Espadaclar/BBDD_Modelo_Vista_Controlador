import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class Productos_Empleados {

    private int idempleado, dir, depnum;
    private String nombre, oficio;
    private Date fechaalta;
    private float salario, comision;

    public Productos_Empleados() {
        idempleado = 0;
        dir = 0;
        depnum = 0;
        nombre = "";
        oficio = "";
        fechaalta = null;
        salario = 0;
        comision = 0;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void setDepnum(int dep) {
        depnum = dep;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOficio(String ofi) {
        oficio = ofi;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public int getDir() {
        return dir;
    }

    public int getDepnum() {
        return depnum;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public float getSalario() {
        return salario;
    }

    public float getComision() {
        return comision;
    }

}
