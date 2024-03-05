package cr.ac.uned.estructurasdedatos.tarea1.gui;

import cr.ac.uned.estructurasdedatos.tarea1.RegistroDePartidos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Patalla principal del programa para registrar partidos de beisbol
 * @author Mayarling Martinez
 */
public class PantallaPrincipal extends JFrame {
    // Aqui se indican los atributos del objeto PantallaPrincipal
    private JLabel titulo;
    
    private JMenuBar barraDeMenu;
    private JMenu opcionesDeMenu;
    private JMenuItem opcionAgregarPartido;
    private JMenuItem opcionEditarPartido;
    private JMenuItem opcionSalir;
    
    private JTable tablaDeDatos;
    private JScrollPane panelConDesplazamiento;
    
    private RegistroDePartidos registroDePartidos = new RegistroDePartidos();
    
    /**
     * Constructor por defecto para la panatalla principal.
     */
    public PantallaPrincipal(){
        // configuramos la ventana
        setTitle("Grandes Ligas De Béisbol");
        setLayout(null);
        inicializarGUI();
    }
    
    private void inicializarGUI(){
        titulo = new JLabel("Listado de partidos de Béisbol");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        titulo.setBounds(220,10,350,30);
        add(titulo);
        
        // Iniciamos las opciones de menu
        this.barraDeMenu = new JMenuBar();
        
        this.opcionesDeMenu = new JMenu("Opciones");
        this.barraDeMenu.add(this.opcionesDeMenu);
        
        this.opcionAgregarPartido = new JMenuItem("Agregar Partido");
        this.opcionAgregarPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                crearPantallaAgregarPartido();
            }
        });
        this.opcionesDeMenu.add(this.opcionAgregarPartido);
        
        this.opcionEditarPartido = new JMenuItem("Buscar y Editar Partido");
        this.opcionEditarPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                crearPantallaBusquedaEdicion();
            }
        });
        this.opcionesDeMenu.add(this.opcionEditarPartido);
        
        this.opcionSalir = new JMenuItem("Salir");
        this.opcionSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        this.opcionesDeMenu.add(this.opcionSalir);
        
        this.setJMenuBar(this.barraDeMenu);
        
        //Inicializamos la tabla
        AbstractTableModel modeloDeDatosParaLaTabla = this.registroDePartidos.getTableModel();
        this.tablaDeDatos = new JTable(modeloDeDatosParaLaTabla);
        this.tablaDeDatos.setEnabled(false);
        
        panelConDesplazamiento = new JScrollPane(this.tablaDeDatos);
        panelConDesplazamiento.setBounds(25, 50, 660, 300);
        add(panelConDesplazamiento);
    }
    
    /**
     * Metodo para crear la pantalla para agregar un nuevo partido
     */
    private void crearPantallaAgregarPartido(){
        PantallaAgregarPartido pantallaAgregarPartido = new PantallaAgregarPartido(this.registroDePartidos, this.tablaDeDatos);
        pantallaAgregarPartido.setBounds(0, 0, 525, 300);
        pantallaAgregarPartido.setResizable(false);
        pantallaAgregarPartido.setVisible(true);
        pantallaAgregarPartido.setLocationRelativeTo(this);
    }
    
    /**
     *  Metodo para crear la pantalla de busqueda y edicion de partidos
     */
    private void crearPantallaBusquedaEdicion() {
        PantallaBusquedaEdicionPartido pantallaBusquedaEdicionPartido = new PantallaBusquedaEdicionPartido(this.registroDePartidos, this.tablaDeDatos);
        pantallaBusquedaEdicionPartido.setBounds(0, 0, 525, 300);
        pantallaBusquedaEdicionPartido.setResizable(false);
        pantallaBusquedaEdicionPartido.setVisible(true);
        pantallaBusquedaEdicionPartido.setLocationRelativeTo(this);
    }
}
