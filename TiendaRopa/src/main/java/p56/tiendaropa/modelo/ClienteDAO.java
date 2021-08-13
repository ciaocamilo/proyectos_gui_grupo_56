package p56.tiendaropa.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import p56.tiendaropa.conexion.SqliteConnection;

public class ClienteDAO {

    public void insertarCliente(Cliente nuevoCliente, SqliteConnection conexionBD) {
        String sentencia = "INSERT INTO Clientes (identificacion, nombres, apellidos) VALUES('" + nuevoCliente.getIdentificacion() + "', '"+ nuevoCliente.getNombres() + "', '" + nuevoCliente.getApellidos() + "')";
        conexionBD.ejecutarSentencia(sentencia);
        JOptionPane.showMessageDialog(null, "El cliente fue ingresado satisfactoriamente", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
    }

    public ArrayList<Cliente> mostrarClientes(SqliteConnection conexionBD) {
        ArrayList<Cliente> salida = new ArrayList<>();
        try {
            ResultSet resultadoClientes = conexionBD.ejecutarConsulta("SELECT * FROM Clientes ORDER BY identificacion LIMIT 10");
            while (resultadoClientes.next()) {
                String identificacion = resultadoClientes.getString("identificacion");
                String nombres = resultadoClientes.getString("nombres");
                String apellidos = resultadoClientes.getString("apellidos");
                // salida = salida.concat(identificacion + " - " + nombres + " - " + apellidos + "\n");
                salida.add(new Cliente(identificacion, nombres, apellidos));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }

    public String listarProductosPorCliente(String idenCliente, SqliteConnection conexionBD) {
        String salida = "";
        try {
            String queryProductos = "SELECT c.nombres, c.apellidos, p.nombre, p.precio " +
                                    "FROM Clientes c JOIN Ventas v ON c.identificacion = v.idCliente " +
                                    "JOIN VentasProductos vp ON v.codigoVenta = vp.idVenta " +
                                    "JOIN Productos p ON vp.idProducto = p.codigoBarras " +
                                    "WHERE c.identificacion = '" + idenCliente + "'";
            ResultSet resultadoCliente = conexionBD.ejecutarConsulta(queryProductos);
            while (resultadoCliente.next()) {
                String nombreCliente = resultadoCliente.getString("nombres");
                String apellidoCliente = resultadoCliente.getString("apellidos");
                String nombreProducto = resultadoCliente.getString("nombre");
                float precioProducto = resultadoCliente.getFloat("precio");
                salida = salida.concat(nombreCliente + " - " + apellidoCliente + " - " + nombreProducto + " $" + precioProducto + "\n");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }

}
