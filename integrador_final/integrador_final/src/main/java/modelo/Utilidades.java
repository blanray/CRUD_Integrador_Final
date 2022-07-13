package modelo;

public class Utilidades {

    private String tip_descripcion;
    private int cantidad;
    private double valor;

    public Utilidades(String tip_descripcion, int cantidad, double valor) {
        this.tip_descripcion = tip_descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getTip_descripcion() {
        return tip_descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setTip_descripcion(String tip_descripcion) {
        this.tip_descripcion = tip_descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
