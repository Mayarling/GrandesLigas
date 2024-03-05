package cr.ac.uned.estructurasdedatos.tarea1.gui;

import cr.ac.uned.estructurasdedatos.tarea1.RegistroDePartidos;
import cr.ac.uned.estructurasdedatos.tarea1.dominio.Partido;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Pantalla para buscar y editar un partido existente.
 * 
 * @author Mayarling Martinez
 */
public class PantallaBusquedaEdicionPartido extends JFrame {
    private JLabel titulo;
    private JLabel etiquetaFecha;
    private JLabel etiquetaIdPartido;
    private JLabel etiquetaIdJornada;
    private JLabel etiquetaCarrerasEquipoA;
    private JLabel etiquetaCarrerasEquipoB;
    private JLabel etiquetaNombreEquipoA;
    private JLabel etiquetaNombreEquipoB;
    private JLabel etiquetaExtraInnings;
    
    private JButton botonBuscar;
    private JButton botonGuardar;
    
    //private JTextField campoTextoFecha;
    private JTextField campoFecha;
    private JTextField campoIdPartido;
    private JTextField campoIdJornada;
    private JTextField campoCarrerasEquipoA;
    private JTextField campoCarrerasEquipoB;
    private JTextField campoNombreEquipoA;
    private JTextField campoNombreEquipoB;
    private JCheckBox campoExtraInnings;
    
    private RegistroDePartidos registroDePartidos;
    
    private JTable tablaDeDatos;
    
    private Partido partido = null;
    
    public PantallaBusquedaEdicionPartido(RegistroDePartidos registroDePartidos, JTable tablaDeDatos){
        setTitle("Buscar y Editar partido de Béisbol");
        setLayout(null);
        inicializarGUI();
        this.registroDePartidos = registroDePartidos;
        this.tablaDeDatos = tablaDeDatos;
    }
    
    private void inicializarGUI(){
        //Configuramos la etiqueta del titulo
        titulo = new JLabel("Buscar y Editar un partido de Béisbol");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        titulo.setBounds(110,10,360,30);
        add(titulo);
        
        //Inicializamos la etiqueta para el Id partido
        etiquetaIdPartido = new JLabel("ID Partido:");
        etiquetaIdPartido.setBounds(25,50,100,30);
        add(etiquetaIdPartido);
        
        //Inicializamos el campo que corresponde al Id del partido.
        campoIdPartido = new JTextField();
        campoIdPartido.setBounds(155,50,100,30);
        campoIdPartido.setToolTipText("Digite el ID del partido a buscar.");
        add(campoIdPartido);
        
        // inicializamos la etiqueta del Id de la jornada.
        etiquetaIdJornada = new JLabel ("ID Jornada:");
        etiquetaIdJornada.setBounds(25,90,100,30);
        add(etiquetaIdJornada);
       
        //Inicializamos el campo apara el texto del Id del partidos
        campoIdJornada = new JTextField();
        campoIdJornada.setBounds(155,90,100,30);
        campoIdJornada.setEditable(false);
        add(campoIdJornada);
       
        //Inicializamos la etiqueta para el nombre del partidos A.
        etiquetaNombreEquipoA = new JLabel("Nombre del partido A:");
        etiquetaNombreEquipoA.setBounds(25,130,130,30);
        add(etiquetaNombreEquipoA);
       
        // Incializamos el campo para el texto correspondiente al nombre del equipo A.
        campoNombreEquipoA = new JTextField();
        campoNombreEquipoA.setBounds(155,130,100,30);
        campoNombreEquipoA.setEditable(false);
        add(campoNombreEquipoA);
       
        //Inicializamos la etiqueta para el nombre del partidos B.
        etiquetaNombreEquipoB = new JLabel("Nombre del partido B:");
        etiquetaNombreEquipoB.setBounds(25,170,130,30);
        add(etiquetaNombreEquipoB);
       
        // Incializamos el campo para el texto correspondiente al nombre del equipo B.
        campoNombreEquipoB = new JTextField();
        campoNombreEquipoB.setBounds(155,170,100,30);
        campoNombreEquipoB.setEditable(false);
        add(campoNombreEquipoB);
       
        // inicializamos la etiqueta de la fecha.
        etiquetaFecha = new JLabel("Fecha:");
        etiquetaFecha.setBounds(290,50,100,30);
        add(etiquetaFecha);
        
        campoFecha = new JTextField();
        campoFecha.setBounds(400,50,100,30);
        campoFecha.setEditable(false);
        add(campoFecha);
        
        //Inicializamos la etiqueta para las carrerars del equipo A.
        etiquetaCarrerasEquipoA = new JLabel("Carreras Equipo A:");
        etiquetaCarrerasEquipoA.setBounds(290,90,130,30);
        add(etiquetaCarrerasEquipoA);
         
        //Inicializamos el campo correspondiente a la etiqueta de las carreras del equipo A.
        campoCarrerasEquipoA = new JTextField();
        campoCarrerasEquipoA.setBounds(400,90,100,30);
        campoCarrerasEquipoA.setToolTipText("Digite la cantidad de carreras del equipo A. Mínimo 0. Máximo 99.");
        add(campoCarrerasEquipoA);
         
        //Inicializamos la etiqueta para las carrerars del equipo B.
        etiquetaCarrerasEquipoB = new JLabel("Carreras Equipo B:");
        etiquetaCarrerasEquipoB.setBounds(290,130,130,30);
        add(etiquetaCarrerasEquipoB);
         
        //Inicializamos el campo correspondiente a la etiqueta de las carreras del equipo A.
        campoCarrerasEquipoB = new JTextField();
        campoCarrerasEquipoB.setBounds(400,130,100,30);
        campoCarrerasEquipoB.setToolTipText("Digite la cantidad de carreras del equipo B. Mínimo 0. Máximo 99.");
        add(campoCarrerasEquipoB);
        
         //Inicializamos la etiqueta correspondiente para extra-innings.
        etiquetaExtraInnings = new JLabel("Extra-inning:");
        etiquetaExtraInnings.setBounds(290,170,100,30);
        add(etiquetaExtraInnings);
         
        //Inicializamos el campo correspondiente a la etiqueta de extra-inning.
        campoExtraInnings = new JCheckBox();
        campoExtraInnings.setBounds(400,170,100,30);
        campoExtraInnings.setToolTipText("Check si hubo extra-innings.");
        add(campoExtraInnings);
         
        //Configuramos el boton buscar.
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(25,220,150,30);
        botonBuscar.setToolTipText("Presione este botón para buscar por ID del partido.");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                buscarPartido();
            }
        });
        add(botonBuscar);
        
        //Configuramos el boton Guardar.
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(290,220,150,30);
        botonGuardar.setToolTipText("Presione este botón para guardar los datos del partido.");
        botonGuardar.setEnabled(false);
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                guardarEdicionPartido();
            }
        });
        add(botonGuardar);
    }
    
    /**
     * Busca el partido con base en el ID del partido indicado.
     */
    private void buscarPartido() {
        try {
            int idPartido = Integer.parseInt(this.campoIdPartido.getText());
            this.partido = this.registroDePartidos.obtenerPartidoPorId(idPartido);
            if(this.partido != null) {
                this.campoIdJornada.setText(Integer.toString(this.partido.getIdJornada()));
                this.campoNombreEquipoA.setText(this.partido.getNombreEquipoA());
                this.campoNombreEquipoB.setText(this.partido.getNombreEquipoB());
                this.campoFecha.setText(this.partido.getFecha());
                this.campoCarrerasEquipoA.setText(Integer.toString(this.partido.getCarrerasEquipoA()));
                this.campoCarrerasEquipoB.setText(Integer.toString(this.partido.getCarrerasEquipoB()));
                this.campoExtraInnings.setSelected(this.partido.isExtraInnings());
                this.botonGuardar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro ningún partido con el ID " + idPartido + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.resetearCampos();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "El ID del partido debe ser un número.", "ERROR", JOptionPane.ERROR_MESSAGE);
            this.resetearCampos();
        }
    }
    
    /**
     * Guardamos los datos que se editaron del partido encontrado.
     */
    private void guardarEdicionPartido() {
        if(this.partido != null) {
            boolean datosValidos = true;
            int carrerasEquipoA = 0;
            int carrerasEquipoB = 0;
            boolean extraInnings = this.campoExtraInnings.isSelected();
            
            // Validamos que el ID del partido del campo de busqueda sea el mismo id del partido cargado
            try {
                int idPartido = Integer.parseInt(this.campoIdPartido.getText());
                if(this.partido.getIdPartido() != idPartido) {
                    JOptionPane.showMessageDialog(
                        this,
                        "El ID del partido ("+idPartido+") es distinto del id del partido que se busco originalmente ("+this.partido.getIdPartido()+").",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                    );
                    datosValidos = false;
                    this.resetearCampos();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "El ID del partido debe ser un número.", "ERROR", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
                this.resetearCampos();
            }
            if(datosValidos){
                // Obtenemos y validamos las carreras del equipo A
                try {
                    carrerasEquipoA = Integer.parseInt(this.campoCarrerasEquipoA.getText());
                    if(carrerasEquipoA < 0 || carrerasEquipoA > 99) {
                        JOptionPane.showMessageDialog(this, "Las carreras del equipo A deben ser un numero entre 0 y 99.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    }
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "Las carreras del equipo A deben ser un numero.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }

                // Obtenemos y validamos las carreras del equipo B
                try {
                    carrerasEquipoB = Integer.parseInt(this.campoCarrerasEquipoB.getText());
                    if(carrerasEquipoB < 0 || carrerasEquipoB > 99) {
                        JOptionPane.showMessageDialog(this, "Las carreras del equipo B deben ser un numero entre 0 y 99.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    }
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "Las carreras del equipo B deben ser un numero.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            }
            
            if(datosValidos){
                this.registroDePartidos.modificarPartido(this.partido.getIdPartido(), carrerasEquipoA, carrerasEquipoB, extraInnings);
                this.tablaDeDatos.setModel(this.registroDePartidos.getTableModel());
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay un partido cargado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Este metodo resetea los campos a vacio
     */
    private void resetearCampos() {
        this.partido = null;
        this.campoIdJornada.setText("");
        this.campoNombreEquipoA.setText("");
        this.campoNombreEquipoB.setText("");
        this.campoFecha.setText("");
        this.campoCarrerasEquipoA.setText("");
        this.campoCarrerasEquipoB.setText("");
        this.campoExtraInnings.setSelected(false);
        this.botonGuardar.setEnabled(false);
    }
}
