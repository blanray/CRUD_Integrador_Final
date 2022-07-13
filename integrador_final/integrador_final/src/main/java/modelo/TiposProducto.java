
package modelo;

public class TiposProducto {
    private int tip_id;
    private String tip_descripcion;

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





