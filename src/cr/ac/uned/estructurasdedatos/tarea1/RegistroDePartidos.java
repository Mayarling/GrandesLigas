package cr.ac.uned.estructurasdedatos.tarea1;

import java.util.*;
import cr.ac.uned.estructurasdedatos.tarea1.dominio.Partido;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase sirve para llevar todos los registros de los partidos de beisbol.
 * 
 * @author Mayarling Martinez
 */
public class RegistroDePartidos {
    private List<Partido> partidos;
    
    /**
     * Constructor por defecto. Inicializa la lista de partidos con un ArrayList.
     */
    public RegistroDePartidos(){
        this.partidos = new ArrayList();
    }
    
    /**
     * Este metodo agrega un partido a la lista de partido.
     * @param unPartido objeto Partido que se va a agregar a la lista.
     */
    public void agregarPartido(Partido unPartido){
        this.partidos.add(unPartido);
    }
    
    /**
     * Este metodo nos va a devolver los partidos registrados.
     * @return la lista de partidos registrados.
     */
    public List<Partido> getPartidos(){
        return this.partidos;    
    }
    
    /**
     * Este metodo obtiene el partido dado un ID de un partido.
     * 
     * @param idPartido El Id de un partido a buscar.
     * @return El partido encontrado, o null si no encuentra ningun partido con ese ID.
     */
    public Partido obtenerPartidoPorId(int idPartido){
        return buscarPartidoRecursivamente(idPartido, this.partidos);
    }
    
    /**
     * Este método busca  y edita los datos en un registro.
     * @param idPartido el Id del prtido
     * @param carrerasEquipoA Las carreras del equipo A
     * @param carrerasEquipoB Las careras del equipo B
     * @param extraInnings  Extrainning
     */
    public void modificarPartido(int idPartido, int carrerasEquipoA, int carrerasEquipoB, boolean extraInnings){
        for(int i = 0; i < this.partidos.size(); i++){
            Partido partidoDeLaLista = this.partidos.get(i);
            if(partidoDeLaLista.getIdPartido() == idPartido){
                partidoDeLaLista.setCarrerasEquipoA(carrerasEquipoA);
                partidoDeLaLista.setCarrerasEquipoB(carrerasEquipoB);
                partidoDeLaLista.setExtraInnings(extraInnings);
                break;
            }
        }
    }
    
    /**
     * Este metodo crea el modelo de los datos, que representa los datos de los partidos
     * y los encabezados para poder desplegar los datos en una JTable.
     * @return Un modelo de tabla que usa un DefaultTableModel
     */
    public AbstractTableModel getTableModel(){
        String[] encabezadosDeLaTabla = {"Fecha", "Id Jornada", "Id Partido", "Equipo A", "Carreras Equipo A", "Equipo B", "Carreras Equipo B", "Extra Innings?"};
        String[][] datos = new String[this.partidos.size()][8];
        Iterator<Partido> iteradorDePartidos = this.partidos.iterator();
        int posicionDePartido = 0;
        while(iteradorDePartidos.hasNext()){
            Partido partidoSiguienteEnIterador = iteradorDePartidos.next();
            datos[posicionDePartido][0] = partidoSiguienteEnIterador.getFecha();
            datos[posicionDePartido][1] = Integer.toString(partidoSiguienteEnIterador.getIdJornada());
            datos[posicionDePartido][2] = Integer.toString(partidoSiguienteEnIterador.getIdPartido());
            datos[posicionDePartido][3] = partidoSiguienteEnIterador.getNombreEquipoA();
            datos[posicionDePartido][4] = Integer.toString(partidoSiguienteEnIterador.getCarrerasEquipoA());
            datos[posicionDePartido][5] = partidoSiguienteEnIterador.getNombreEquipoB();
            datos[posicionDePartido][6] = Integer.toString(partidoSiguienteEnIterador.getCarrerasEquipoB());
            datos[posicionDePartido][7] = partidoSiguienteEnIterador.isExtraInnings()? "SI" : "NO";
            posicionDePartido++;
        }
        return new DefaultTableModel(datos, encabezadosDeLaTabla);
    }
    
    /**
     * Metodo para buscar un partido de forma recursiva dado el ID del partido.
     * 
     * @param idPartido El ID del partido a buscar
     * @param partidos La lista de partidos donde se buscara el ID
     * 
     * @return Partido que corresponde al ID indicado, si no encuentra el partido, devuelve null.
     */
    private static Partido buscarPartidoRecursivamente(int idPartido, List<Partido> partidos){
        Partido partidoEncontrado = null;
        if(partidos != null && !partidos.isEmpty()){
            Partido primerPartido = partidos.get(0);
            if(primerPartido.getIdPartido() == idPartido){
                partidoEncontrado = primerPartido;
            } else {
                List<Partido> partidosSinElPrimerElemento = partidos.subList(1, partidos.size());
                partidoEncontrado = buscarPartidoRecursivamente(idPartido, partidosSinElPrimerElemento);
            }
        }
        return partidoEncontrado;
    }
}
