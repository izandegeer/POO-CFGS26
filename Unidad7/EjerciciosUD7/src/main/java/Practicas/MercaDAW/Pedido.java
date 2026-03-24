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

    public Pedido(double importeTotal) {
        pedido = new HashMap<>();
        this.importeTotal = importeTotal;
    }

    public void actualizarImporteTotal(double importe){
        this.importeTotal += importe;
    }

    public void aplicarPromo3x2(){
        for (Map.Entry<Producto, Integer> mapita : pedido.entrySet()){
            if (mapita.getValue() % 3 == 0){
                int unidadesGratis = mapita.getValue() / 3;
                this.importeTotal -= (unidadesGratis * mapita.getKey().getPrecio());
            }
        }
    }

    public void aplicarPromo10(){
        this.importeTotal = importeTotal * 0.9;
    }
}
