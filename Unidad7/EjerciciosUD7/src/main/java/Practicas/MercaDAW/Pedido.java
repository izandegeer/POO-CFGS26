package Practicas.MercaDAW;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Pedido {
    private HashMap<Producto, Integer> pedido = null;
    private double importeTotal;

    public Pedido(HashMap<Producto, Integer> pedido, double importeTotal) {
        this.pedido = pedido;
        this.importeTotal = importeTotal;
    }

    public void actualizarImporteTotal(double importe){
        double importeTotal = 0;

        importeTotal += importe;
    }

    public void aplicarPromo3x2(){}

    public void aplicarPromo10(){}
}
