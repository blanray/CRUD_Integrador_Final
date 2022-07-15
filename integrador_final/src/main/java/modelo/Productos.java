package modelo;

public class Productos {

    private int prd_id;
    private String prd_descripcion;
    private int prd_tip_id;
    private String tip_descripcion;
    private int prd_stock;
    private double prd_precio;

    public Productos(String prd_descripcion, int prd_tip_id, int prd_stock, double prd_precio) {
        this.prd_descripcion = prd_descripcion;
        this.prd_tip_id = prd_tip_id;
        this.prd_stock = prd_stock;
        this.prd_precio = prd_precio;
    }

    public Productos(int prd_id, String prd_descripcion, int prd_tip_id, int prd_stock, double prd_precio) {
        this.prd_id = prd_id;
        this.prd_descripcion = prd_descripcion;
        this.prd_tip_id = prd_tip_id;
        this.prd_stock = prd_stock;
        this.prd_precio = prd_precio;
    }

    public Productos(int prd_id, String prd_descripcion, int prd_tip_id, String tip_descripcion, int prd_stock, double prd_precio) {
        this.prd_id = prd_id;
        this.prd_descripcion = prd_descripcion;
        this.prd_tip_id = prd_tip_id;
        this.tip_descripcion = tip_descripcion;
        this.prd_stock = prd_stock;
        this.prd_precio = prd_precio;
    }

    public void setTip_descripcion(String tip_descripcion) {
        this.tip_descripcion = tip_descripcion;
    }

    public String getTip_descripcion() {
        return tip_descripcion;
    }

    public int getPrd_id() {
        return prd_id;
    }

    public String getPrd_descripcion() {
        return prd_descripcion;
    }

    public int getPrd_tip_id() {
        return prd_tip_id;
    }

    public int getPrd_stock() {
        return prd_stock;
    }

    public double getPrd_precio() {
        return prd_precio;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public void setPrd_descripcion(String prd_descripcion) {
        this.prd_descripcion = prd_descripcion;
    }

    public void setPrd_tip_id(int prd_tip_id) {
        this.prd_tip_id = prd_tip_id;
    }

    public void setPrd_stock(int prd_stock) {
        this.prd_stock = prd_stock;
    }

    public void setPrd_precio(double prd_precio) {
        this.prd_precio = prd_precio;
    }

    @Override
    public String toString() {
        return "Productos{" + "prd_descripcion=" + prd_descripcion + ", prd_tip_id=" + prd_tip_id + ", prd_stock=" + prd_stock + ", prd_precio=" + prd_precio + '}';
    }

}
