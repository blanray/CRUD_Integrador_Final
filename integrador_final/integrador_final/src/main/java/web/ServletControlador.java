package web;

import datos.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    break;
                case "editar":
                    // editarProducto(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String queryParam = req.getParameter("accion");
        if (queryParam != null) {
            switch (queryParam) {
                case "insertar":
                    insertarProducto(req, res);
                    break;
                case "insertarTipo":
                    insertarTipoProducto(req, res);
                    break;
                case "actualizarPrecios":
                    actualizarPrecios(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        List<Productos> productos = new ProductosDAO().seleccionarTodos();
        sesion.setAttribute("productos", productos);
        List<TiposProducto> tiposProducto = new TiposProductoDAO().seleccionarTodos();
        sesion.setAttribute("tiposProducto", tiposProducto);
        List<Utilidades> totalesPorTipo = new UtilidadesDAO().totalPorTipo();
        sesion.setAttribute("totalesPorTipo", totalesPorTipo);
        Utilidades totalGeneral = new UtilidadesDAO().totalGeneral();
        sesion.setAttribute("totalGeneral", totalGeneral);
        res.sendRedirect("productos.jsp");
    }

    private void insertarProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String descripcion = req.getParameter("descripcion");
        int tipoId = Integer.parseInt(req.getParameter("selectorTipo"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        Productos producto = new Productos(descripcion, tipoId, stock, precio);
        int registrosMod = new ProductosDAO().insertar(producto);

        System.out.println("insertados = " + registrosMod);

        accionDefault(req, res);
    }

    private void insertarTipoProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String descripcion = req.getParameter("descripcion");
        TiposProducto tipoProducto = new TiposProducto(descripcion);
        int registrosMod = new TiposProductoDAO().insertar(tipoProducto);

        System.out.println("insertados = " + registrosMod);

        accionDefault(req, res);
    }

    private void actualizarPrecios(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double porcentaje = Double.parseDouble(req.getParameter("porcentaje"));
        int registros = new UtilidadesDAO().actualizarPrecios(porcentaje);
   
         System.out.println("actualizados = " + registros);
         
        accionDefault(req, res);
    }

    protected void doGetOLD(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Productos> productos = new ProductosDAO().seleccionarTodos();
        req.setAttribute("productos", productos);
        List<TiposProducto> tiposProducto = new TiposProductoDAO().seleccionarTodos();
        req.setAttribute("tiposProducto", tiposProducto);
        List<Utilidades> totalesPorTipo = new UtilidadesDAO().totalPorTipo();
        req.setAttribute("totalesPorTipo", totalesPorTipo);
        Utilidades totalGeneral = new UtilidadesDAO().totalGeneral();
        req.setAttribute("totalGeneral", totalGeneral);
        req.getRequestDispatcher("productos.jsp").forward(req, res);
    }

}
