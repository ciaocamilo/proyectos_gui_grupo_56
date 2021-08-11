package p56.tiendaropa;

// import p56.tiendaropa.vista.Menu;
import p56.tiendaropa.conexion.SqliteConnection;
import p56.tiendaropa.vista.VentanaMenu;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("MI TIENDA DE ROPA");

        SqliteConnection conexionBD = new SqliteConnection();
        // Menu menuPrincipal = new Menu();
        // menuPrincipal.generarMenu(conexionBD);
        VentanaMenu menuPrincipal = new VentanaMenu(conexionBD);
        menuPrincipal.setVisible(true);
    }
}
