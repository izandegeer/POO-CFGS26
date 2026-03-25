package Practicas.MercaDAW;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Pedido {
    private HashMap<Producto, Integer> pedido = null;
    private double importeTotal;

    /**
     * Constructor de Pedido
     * @param importeTotal
     */
    public Pedido(double importeTotal) {
        pedido = new HashMap<>();
        this.importeTotal = importeTotal;
    }

    /**
     * Metodo para sumar la cuantía del importe al importe total
     * @param importe
     */
    public void actualizarImporteTotal(double importe){
        this.importeTotal += importe;
    }

    /**
     * Meotodo para aplicar la promo 3x2
     */
    public void aplicarPromo3x2(){
        for (Map.Entry<Producto, Integer> mapita : pedido.entrySet()){
            if (mapita.getValue() % 3 == 0){
                int unidadesGratis = mapita.getValue() / 3;
                this.importeTotal -= (unidadesGratis * mapita.getKey().getPrecio());
            }
        }
    }

    /**
     * Metodo para aplicar la promo del 10%
     */
    public void aplicarPromo10(){
        this.importeTotal = importeTotal * 0.9;
    }
}
