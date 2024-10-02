import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollpane1; 
    private JTextArea textarea1;
    String nombre = "";

    public Licencia() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");

        // Obtiene el nombre de la clase Bienvenida
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;

        // Si el nombre está vacío, solicita al usuario que lo ingrese por consola
        if (nombre.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Por favor, ingresa tu nombre: ");
            nombre = scanner.nextLine();
            scanner.close(); // Cerrar el scanner después de su uso
        }

        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215, 5, 200, 30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Andale Mono", 0, 9));   
        textarea1.setText("Texto de los términos y condiciones...");
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 40, 575, 200);
        add(scrollpane1);   

        check1 = new JCheckBox("Yo " + nombre + " Acepto");
        check1.setBounds(10, 250, 300, 30);
        check1.addChangeListener(this);
        add(check1);

        boton1 = new JButton("Continuar");
        boton1.setBounds(10, 290, 100, 30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("No Acepto");
        boton2.setBounds(120, 290, 100, 30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

        ImageIcon imagen = new ImageIcon("C:\\Users\\josma\\OneDrive\\Documentos\\Universidad\\Cuarto semestre\\Programación\\Ejercicios_Progra\\Proyecto Sistema\\images\\agua3.jpg");
        label2 = new JLabel(imagen);  
        label2.setBounds(315, 135, 300, 300);
        add(label2);
    }

    // Método para cambiar el estado de los botones según la selección del checkbox
    public void stateChanged(ChangeEvent e) {
        boton1.setEnabled(check1.isSelected());
        boton2.setEnabled(!check1.isSelected());
    } 

    // Maneja las acciones de los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            // Si presiona "Continuar", abrir la ventana principal
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setBounds(0, 0, 640, 535);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            this.setVisible(false);
        } else if (e.getSource() == boton2) {
            // Si presiona "No Acepto", regresar a la ventana de Bienvenida
            Bienvenida ventanaBienvenida = new Bienvenida();
            ventanaBienvenida.setBounds(0, 0, 350, 450);  // Establecer el tamaño de la ventana
            ventanaBienvenida.setVisible(true);           // Mostrar la ventana
            ventanaBienvenida.setResizable(false);        // No permitir cambiar el tamaño
            ventanaBienvenida.setLocationRelativeTo(null); // Centrar la ventana
            this.setVisible(false);                        // Ocultar la ventana de Licencia
        } 
    }

    public static void main(String args[]) {
        Licencia ventanalicencia = new Licencia();
        ventanalicencia.setBounds(0, 0, 600, 360);
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
    }
    
}
