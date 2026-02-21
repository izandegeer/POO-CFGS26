package ejercicios.Semaforo;

public enum Semaforo {
    AMARILLO, ROJO, VERDE;

    public static Semaforo siguiente(Semaforo actual){
        switch (actual){
            case AMARILLO: return ROJO;
            case ROJO: return VERDE;
            case VERDE: return AMARILLO;
            default: return AMARILLO;
        }
    }
}