package cr.ac.uned.estructurasdedatos.tarea1.gui;

import cr.ac.uned.estructurasdedatos.tarea1.RegistroDePartidos;
import cr.ac.uned.estructurasdedatos.tarea1.dominio.Partido;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 * Pantalla para agregar un nuevo partido de beisbol
 * 
 * @author Mayarling Martinez
 */
public class PantallaAgregarPartido extends JFrame {
    private JLabel titulo;
    private JLabel etiquetaFecha;
    private JLabel etiquetaIdJornada;
    private JLabel etiquetaCarrerasEquipoA;
    private JLabel etiquetaCarrerasEquipoB;
    private JLabel etiquetaNombreEquipoA;
    private JLabel etiquetaNombreEquipoB;
    private JLabel etiquetaExtraInnings;
    
    private JButton botonAgregar;
    
    //private JTextField campoTextoFecha;
    private JSpinner spinnerFecha;
    private JTextField campoIdJornada;
    private JTextField campoCarrerasEquipoA;
    private JTextField campoCarrerasEquipoB;
    private JTextField campoNombreEquipoA;
    private JTextField campoNombreEquipoB;
    private JCheckBox campoExtraInnings;
    
    private RegistroDePartidos registroDePartidos;
    
    private JTable tablaDeDatos;
    
    public PantallaAgregarPartido(RegistroDePartidos registroDePartidos, JTable tablaDeDatos){
        setTitle("Agregar nuevo partido de Béisbol");
        setLayout(null);
        inicializarGUI();
        this.registroDePartidos = registroDePartidos;
        this.tablaDeDatos = tablaDeDatos;
    }
    
    private void inicializarGUI(){
        //Configuramos la etiqueta del titulo
        titulo = new JLabel("Registro de un nuevo partido de Béisbol");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        titulo.setBounds(110,10,360,30);
        add(titulo);
        
        // inicializamos la etiqueta del Id de la jornada.
        etiquetaIdJornada = new JLabel ("ID Jornada:");
        etiquetaIdJornada.setBounds(25,50,100,30);
        add(etiquetaIdJornada);
       
        //Inicializamos el campo apara el texto del Id del partidos
        campoIdJornada = new JTextField();
        campoIdJornada.setBounds(155,50,100,30);
        campoIdJornada.setToolTipText("Digite el ID de la jornada.");
        add(campoIdJornada);
       
        //Inicializamos la etiqueta para el nombre del partidos A.
        etiquetaNombreEquipoA = new JLabel("Nombre del partido A:");
        etiquetaNombreEquipoA.setBounds(25,90,130,30);
        add(etiquetaNombreEquipoA);
       
        // Incializamos el campo para el texto correspondiente al nombre del equipo A.
        campoNombreEquipoA = new JTextField();
        campoNombreEquipoA.setBounds(155,90,100,30);
        campoNombreEquipoA.setToolTipText("Digite el nombre del equipo A. Máximo 20 caracteres.");
        add(campoNombreEquipoA);
       
        //Inicializamos la etiqueta para el nombre del partidos B.
        etiquetaNombreEquipoB = new JLabel("Nombre del partido B:");
        etiquetaNombreEquipoB.setBounds(25,130,130,30);
        add(etiquetaNombreEquipoB);
       
        // Incializamos el campo para el texto correspondiente al nombre del equipo B.
        campoNombreEquipoB = new JTextField();
        campoNombreEquipoB.setBounds(155,130,100,30);
        campoNombreEquipoB.setToolTipText("Digite el nombre del equipo B. Máximo 20 caracteres.");
        add(campoNombreEquipoB);
       
        // inicializamos la etiqueta de la fecha.
        etiquetaFecha = new JLabel("Fecha:");
        etiquetaFecha.setBounds(290,50,100,30);
        add(etiquetaFecha);
        
        spinnerFecha = new JSpinner();
        spinnerFecha.setBounds(400,50,100,30);
        spinnerFecha.setToolTipText("Digite la fecha en el siguiente formato dd/mm/yyyy");
        spinnerFecha.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH));
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
        add(spinnerFecha);
        
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
         
        //Configuramos el boton agregar.
        botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(200,220,150,30);
        botonAgregar.setToolTipText("Presione este botón para agregar los datos del partido.");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String textoDelCampoIdJornada = campoIdJornada.getText();
                String textoDelCampoNombreEquipoA = campoNombreEquipoA.getText();
                String textoDelCampoNombreEquipoB = campoNombreEquipoB.getText();
                String textoCarrerasEquipoA = campoCarrerasEquipoA.getText();
                String textoCarrerasEquipoB = campoCarrerasEquipoB.getText();
                boolean hayExtraInnings = campoExtraInnings.isSelected();
                Partido partido = crearValidarPartido(textoDelCampoIdJornada, textoDelCampoNombreEquipoA,
                        textoDelCampoNombreEquipoB, textoCarrerasEquipoA, textoCarrerasEquipoB, hayExtraInnings);
                if(partido != null){
                    registrarPartido(partido);
                }
            }
        });
        add(botonAgregar);
    }
    
    /**
     * Este metodo valida todos los datos de texto, los pasa a su correspondiente tipo de dato 
     * ya sea numero o fecha, y si todo es valido, crea un objeto Partido con esos datos.
     * 
     * Si hay errores, muestra mensajes de error y devuelve null.
     * 
     * @param textoIdJornada El contenido del campo idJornada
     * @param textoNombreA El contenido del campo nombre del equipo A
     * @param textoNombreB El contenido del campo nombre del equipo B
     * @param textoCarrerasA El contenido del campo carreras del equipo A
     * @param textoCarrerasB El contenido del campo carreras del equipo B
     * @param extraInnings El contenido del checkbox si hubo o no extra innings
     * 
     * @return El objeto partido correspondiente a los datos, o si los datos no son validos, retorna null
     */
    private Partido crearValidarPartido(String textoIdJornada, String textoNombreA,
            String textoNombreB, String textoCarrerasA, String textoCarrerasB, boolean extraInnings){
        boolean datosValidos = true;
        int idJornada = 0;
        int idPartido = this.registroDePartidos.getPartidos().size()+1;
        int carrerasA = 0;
        int carrerasB = 0;
        // Validamos el id de la jornada
        try {
            idJornada = Integer.parseInt(textoIdJornada);
            if(idJornada <= 0){
                JOptionPane.showMessageDialog(this, "El ID de la jornada debe ser un numero mayor a cero.", "ERROR", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "El ID de la jornada debe ser un numero.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // validamos las carreras A
        try {
            carrerasA = Integer.parseInt(textoCarrerasA);
            if(carrerasA < 0 || carrerasA > 99){
                JOptionPane.showMessageDialog(this, "Las carreras del equipo A deben ser un numero entre 0 y 99.", "ERROR", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Las carreras del equipo A deben ser un numero.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // validamos las carreras B
        try {
            carrerasB = Integer.parseInt(textoCarrerasB);
            if(carrerasB < 0 || carrerasB > 99){
                JOptionPane.showMessageDialog(this, "Las carreras del equipo B deben ser un numero entre 0 y 99.", "ERROR", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Las carreras del equipo B deben ser un numero.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Valido el nombre del equipo A. Como es requerido, no puede ser nulo, ni vacio, y no puede ser mayor de 20 caracteres.
        if(textoNombreA == null || textoNombreA.equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre del equipo A es requerido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        } else if(textoNombreA.length() > 20){
            JOptionPane.showMessageDialog(this, "El nombre del equipo A debe ser menor o igual a 20 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Valido el nombre del equipo B. Como es requerido, no puede ser nulo, ni vacio, y no puede ser mayor de 20 caracteres
        if(textoNombreB == null || textoNombreB.equals("")){
            JOptionPane.showMessageDialog(this, "El nombre del equipo B es requerido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;   
        } else if(textoNombreB.length() > 20){
            JOptionPane.showMessageDialog(this, "El nombre del equipo B debe ser menor o igual a 20 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
        
        // Si todos los datos son validos  agrega el nuevo partido
        if(datosValidos){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Partido partido = new Partido(idJornada, idPartido, extraInnings, simpleDateFormat.format((Date)spinnerFecha.getValue()), textoNombreA, textoNombreB, carrerasA, carrerasB);
            return partido;
        } else {
            return null;
        }
    }
    
    /**
     * Metodo que registra el partido en el objeto que guarda los partidos, actualiza la tabla
     * de los datos y oculta la pantalla.
     * 
     * @param partido El partido a registrar
     */
    private void registrarPartido(Partido partido){
        this.registroDePartidos.agregarPartido(partido);
        this.tablaDeDatos.setModel(this.registroDePartidos.getTableModel());
        this.setVisible(false);
    }
}
