package datos;

import static datos.Conexion.*;
import modelo.*;
import java.sql.*;
import java.util.*;

public class UtilidadesDAO {

    private static final String SQL_TOTAL_POR_TIPO = "SELECT tip_descripcion as descripcion, count(distinct(prd_id)) as productos, sum(prd_precio*prd_stock) as valor FROM productos a, tipos_producto b where a.prd_tip_id = b.tip_id group by b.tip_descripcion";
    private static final String SQL_TOTAL_GENERAL = "SELECT sum(prd_stock) as cantidad, sum(prd_precio*prd_stock) as valor FROM productos";

    public List<Utilidades> totalPorTipo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Utilidades temp;
        List<Utilidades> totalPorTipo = new ArrayList();
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_TOTAL_POR_TIPO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString(1);
                int cantidad = rs.getInt(2);
                double valor = rs.getDouble(3);

                temp = new Utilidades(descripcion, cantidad, valor);
                totalPorTipo.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return totalPorTipo;
    }

    public Utilidades totalGeneral() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Utilidades temp = new Utilidades("Total General", 0, 0);
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_TOTAL_GENERAL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt(1);
                double valor = rs.getDouble(2);
                temp.setCantidad(cantidad);
                temp.setValor(valor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return temp;
    }

    public int actualizarPrecios(double porcentaje) {
        Connection conn = null;
        int registros = 0;
        double nuevoPrecio;
        ProductosDAO temp = new ProductosDAO();
        List<Productos> productos = new ProductosDAO().seleccionarTodos();

        for (int i = 0; i < productos.size(); i++) {
            nuevoPrecio = 0;
            nuevoPrecio = productos.get(i).getPrd_precio() * ((porcentaje / 100) + 1);
            productos.get(i).setPrd_precio(nuevoPrecio);
            try {
                conn = getConexion();
                temp.actualizarPrecio(productos.get(i));
                registros++;
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                try {
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }

        return registros;
    }


}
