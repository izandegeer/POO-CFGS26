package Concurso_Programamelo;

@SuppressWarnings("ALL")
public class AppProgramaMeLo {
    public static void main (String[] args){
        Concurso.ObtenerFecha();

        Concurso iesmutxamel = new Concurso();
        System.out.println(iesmutxamel);

        Equipo maquinitas = new Equipo("Los maquinitas");
        System.out.println(maquinitas);
        iesmutxamel.inscribirEquipo(maquinitas);
        System.out.println(iesmutxamel);

        maquinitas.insertarMiembros("Daniel","Lucas");
        System.out.println(maquinitas);

        maquinitas.insertarMiembros("Carla","Eros","Lucía");

        Equipo triunfitos = new Equipo("Los triunfitos");
        iesmutxamel.inscribirEquipo(triunfitos);
        triunfitos.insertarMiembros("Juan","Patri","Alexia");
        System.out.println(triunfitos);

        maquinitas.setProblemas_resueltos(2);
        maquinitas.calcularPuntuacion();
        triunfitos.setProblemas_resueltos(3);
        triunfitos.calcularPuntuacion();

//        //a)
//        iesmutxamel.imprimirDatosEquipos();
//
//        //b)
//        iesmutxamel.equipoGanador();
    }
}
