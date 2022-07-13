package datos;

import static datos.Conexion.*;
import modelo.Productos;
import java.sql.*;
import java.util.*;

public class ProductosDAO {

    private static final String SQL_READ = "SELECT a.*, b.tip_descripcion FROM productos a, tipos_producto b WHERE a.prd_tip_id = b.tip_id order by prd_id";
    private static final String SQL_READ_BY_TIPO = "SELECT * FROM productos WHERE prd_tip_id = ?";
    private static final String SQL_INSERT = "INSERT INTO productos(prd_descripcion, prd_tip_id, prd_stock , prd_precio) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE_ALL = "UPDATE productos SET prd_descripcion = ?, prd_tip_id = ?, prd_stock = ?, prd_precio = ? WHERE prd_id = ?";
    private static final String SQL_UPDATE_DESCRIPCION = "UPDATE productos SET prd_descripcion = ? WHERE prd_id = ?";
    private static final String SQL_UPDATE_TIPO = "UPDATE productos SET prd_tip_id = ? WHERE prd_id = ?";
    private static final String SQL_UPDATE_STOCK = "UPDATE productos SET prd_stock = ? WHERE prd_id = ?";
    private static final String SQL_UPDATE_PRECIO = "UPDATE productos SET prd_precio = ? WHERE prd_id = ?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE prd_id = ?";
    private static final String SQL_COUNT_TIPO = "SELECT count(*) FROM productos WHERE prd_tip_id = ?";

    
    public List<Productos> seleccionarTodos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Productos producto;
        List<Productos> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int prd_id = rs.getInt(1);
                String prd_descripcion = rs.getString(2);
                int prd_tip_id = rs.getInt(3);
                int prd_stock = rs.getInt(4);
                double prd_precio = rs.getDouble(5);
                String tip_descripcion = rs.getString(6);
                
                producto = new Productos(prd_id, prd_descripcion, prd_tip_id, tip_descripcion, prd_stock, prd_precio);

                productos.add(producto);
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

        return productos;
    }

    public List<Productos> seleccionarPorTipo(int tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Productos producto;
        List<Productos> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_TIPO);
            stmt.setInt(1, tipo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int prd_id = rs.getInt(1);
                String prd_descripcion = rs.getString(2);
                int prd_tip_id = rs.getInt(3);
                int prd_stock = rs.getInt(4);
                double prd_precio = rs.getDouble(5);

                producto = new Productos(prd_id, prd_descripcion, prd_tip_id, prd_stock, prd_precio);

                productos.add(producto);
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

        return productos;
    }

    public int insertar(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getPrd_descripcion());
            stmt.setInt(2, producto.getPrd_tip_id());
            stmt.setInt(3, producto.getPrd_stock());
            stmt.setDouble(4, producto.getPrd_precio());
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

    public int actualizarTodos(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_ALL);
            stmt.setString(1, producto.getPrd_descripcion());
            stmt.setInt(2, producto.getPrd_tip_id());
            stmt.setInt(3, producto.getPrd_stock());
            stmt.setDouble(4, producto.getPrd_precio());
            stmt.setInt(5, producto.getPrd_id());
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

    public int actualizarDescripcion(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_DESCRIPCION);
            stmt.setString(1, producto.getPrd_descripcion());
            stmt.setInt(2, producto.getPrd_id());
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

    public int actualizarTipo(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_TIPO);
            stmt.setInt(1, producto.getPrd_tip_id());
            stmt.setInt(2, producto.getPrd_id());
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

    public int actualizarStock(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_STOCK);
            stmt.setInt(1, producto.getPrd_stock());
            stmt.setInt(2, producto.getPrd_id());
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

    public int actualizarPrecio(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, producto.getPrd_precio());
            stmt.setInt(2, producto.getPrd_id());
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

    public int borrar(Productos producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getPrd_id());
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

        public int contarPorTipo(int tipo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_COUNT_TIPO);
            stmt.setInt(1, tipo);
            rs = stmt.executeQuery();
            registros = rs.getInt(1);
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
