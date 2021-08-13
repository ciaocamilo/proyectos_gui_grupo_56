package p56.tiendaropa.controlador;

import java.util.ArrayList;
import p56.tiendaropa.conexion.SqliteConnection;
import p56.tiendaropa.modelo.Cliente;
import p56.tiendaropa.modelo.ClienteDAO;

public class controladorCliente {

    public void crearCliente(Cliente nuevoCliente, SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        cli1.insertarCliente(nuevoCliente, conexionBD);
    }

    public ArrayList<Cliente> listarClientes(SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        ArrayList<Cliente> clientes = cli1.mostrarClientes(conexionBD);
        return clientes;
    }

    public String listarProductosCliente(String idenCliente, SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        String productos = cli1.listarProductosPorCliente(idenCliente, conexionBD);
        return productos;
    }

}
