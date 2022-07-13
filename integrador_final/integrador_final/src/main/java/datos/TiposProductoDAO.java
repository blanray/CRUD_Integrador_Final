package datos;

import static datos.Conexion.*;
import modelo.*;
import java.sql.*;
import java.util.*;

public class TiposProductoDAO {

    private static final String SQL_READ = "SELECT * FROM tipos_producto";
    private static final String SQL_READ_BY_TIPO = "SELECT tip_descripcion FROM tipos_productos WHERE tip_id = ?";
    private static final String SQL_INSERT = "INSERT INTO tipos_producto(tip_descripcion) VALUES(?)";
    private static final String SQL_UPDATE_DESCRIPCION = "UPDATE tipos_producto SET tip_descripcion = ? WHERE tip_id = ?";
    private static final String SQL_DELETE = "DELETE FROM tipos_producto WHERE tip_id = ?";

    public List<TiposProducto> seleccionarTodos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposProducto tiposProducto;
        List<TiposProducto> tiposProductos = new ArrayList();
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int tip_id = rs.getInt(1);
                String tip_descripcion = rs.getString(2);
                tiposProducto = new TiposProducto(tip_id, tip_descripcion);
                tiposProductos.add(tiposProducto);
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
        return tiposProductos;
    }

    public String seleccionarPorTipo(int tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String tip_descripcion = "";

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_TIPO);
            stmt.setInt(1, tipo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tip_descripcion = rs.getString(1);
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
        return tip_descripcion;
    }

    public int insertar(TiposProducto tiposProducto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tiposProducto.getTip_descripcion());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizarDescripcion(TiposProducto tiposProducto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_DESCRIPCION);
            stmt.setString(1, tiposProducto.getTip_descripcion());
            stmt.setInt(2, tiposProducto.getTip_id());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int borrar(TiposProducto tiposProducto) {

        ProductosDAO temp = new ProductosDAO();
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            registros = temp.contarPorTipo(tiposProducto.getTip_id());
            if (registros == 0) {
                stmt = conn.prepareStatement(SQL_DELETE);
                stmt.setInt(1, tiposProducto.getTip_id());
                registros = stmt.executeUpdate();
            } else {
                registros = -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
