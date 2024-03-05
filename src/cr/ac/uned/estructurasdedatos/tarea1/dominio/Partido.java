package cr.ac.uned.estructurasdedatos.tarea1.dominio;

/**
 * Esta clase es para guardar los datos de cada partido de beisbol.
 * 
 * @author Mayarling Martinez
 */
public class Partido {
    // Aqui se indican los atributos del objeto Partido.
    private int idJornada;
    private int idPartido;
    private boolean extraInnings;
    private String fecha;
    private String nombreEquipoA;
    private String nombreEquipoB;
    private int carrerasEquipoA;
    private int carrerasEquipoB;
    
    /**
     * Se crea un nuevo objeto de tipo Partido
     */
    public Partido (){
        this.idJornada = 0;
        this.idPartido = 0;
        this.extraInnings = false;
        this.fecha = null;
        this.nombreEquipoA = "";
        this.nombreEquipoB = "";
        this.carrerasEquipoA = 0;
        this.carrerasEquipoB = 0; 
    }
    
    /**
     * Nuevo objeto de tipo Partido
     * @param idJornada
     * @param idPartido
     * @param extraInnings
     * @param fecha
     * @param nombreEquipoA
     * @param nombreEquipoB
     * @param carreraEquipoA
     * @param carreraEquipoB 
     */
    public Partido (int idJornada,int idPartido, boolean extraInnings, String fecha, String nombreEquipoA,String nombreEquipoB,int carreraEquipoA,int carreraEquipoB ){
        this.idJornada = idJornada;
        this.idPartido = idPartido;
        this.extraInnings = extraInnings;
        this.fecha = fecha;
        this.nombreEquipoA = nombreEquipoA;
        this.nombreEquipoB = nombreEquipoB;
        this.carrerasEquipoA = carreraEquipoA;
        this.carrerasEquipoB = carreraEquipoB;
        
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public boolean isExtraInnings() {
        return extraInnings;
    }

    public void setExtraInnings(boolean extraInnings) {
        this.extraInnings = extraInnings;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreEquipoA() {
        return nombreEquipoA;
    }

    public void setNombreEquipoA(String nombreEquipoA) {
        this.nombreEquipoA = nombreEquipoA;
    }

    public String getNombreEquipoB() {
        return nombreEquipoB;
    }

    public void setNombreEquipoB(String nombreEquipoB) {
        this.nombreEquipoB = nombreEquipoB;
    }

    public int getCarrerasEquipoA() {
        return carrerasEquipoA;
    }

    public void setCarrerasEquipoA(int carrerasEquipoA) {
        this.carrerasEquipoA = carrerasEquipoA;
    }

    public int getCarrerasEquipoB() {
        return carrerasEquipoB;
    }

    public void setCarrerasEquipoB(int carrerasEquipoB) {
        this.carrerasEquipoB = carrerasEquipoB;
    }
}
