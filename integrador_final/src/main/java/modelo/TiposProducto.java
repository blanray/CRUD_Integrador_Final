
package modelo;

public class TiposProducto {
    private int tip_id;
    private String tip_descripcion;
    boolean eliminar;

    public TiposProducto(int tip_id, String tip_descripcion, boolean eliminar) {
        this.tip_id = tip_id;
        this.tip_descripcion = tip_descripcion;
        this.eliminar = eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public int getTip_id() {
        return tip_id;
    }

    public String getTip_descripcion() {
        return tip_descripcion;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public void setTip_descripcion(String tip_descripcion) {
        this.tip_descripcion = tip_descripcion;
    }

    public TiposProducto(int tip_id, String tip_descripcion) {
        this.tip_id = tip_id;
        this.tip_descripcion = tip_descripcion;
    }

    public TiposProducto(String tip_descripcion) {
        this.tip_descripcion = tip_descripcion;
    }

    @Override
    public String toString() {
        return "TipoProductos{" + "tip_id=" + tip_id + ", tip_descripcion=" + tip_descripcion + '}';
    }


}





