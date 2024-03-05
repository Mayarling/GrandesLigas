package cr.ac.uned.estructurasdedatos.tarea1;

import cr.ac.uned.estructurasdedatos.tarea1.gui.PantallaPrincipal;

/**
 * Clase con el metodo principal.
 * 
 * @author Mayarling Martinez
 */
public class Aplicacion {

    /**
     * metodo principal del programa
     * @param args Los argumentos del programa
     */
    public static void main(String[] args) {
       PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
       pantallaPrincipal.setBounds(0, 0, 720, 440);
       pantallaPrincipal.setVisible(true);
       pantallaPrincipal.setResizable(false);
       pantallaPrincipal.setLocationRelativeTo(null);
    }
}
