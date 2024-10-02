import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class Bienvenida extends JFrame implements ActionListener{

  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;
  public static String texto = "";  

  public Bienvenida(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bienvenidos");
    getContentPane().setBackground(new Color(0,0,255));
    
    // Imagen del logo
    ImageIcon imagen = new ImageIcon("C:\\Users\\josma\\OneDrive\\Documentos\\Universidad\\Cuarto semestre\\Programación\\Ejercicios_Progra\\Proyecto_Sistema\\images\\agua2.jpg");
    label1 = new JLabel(imagen);
    label1.setBounds(25,15,300,150);
    add(label1);

    label2 = new JLabel("Sistema de Control Vacacional");
    label2.setBounds(35,135,300,30);
    label2.setFont(new Font("Andale Mono", 3, 18));
    label2.setForeground(new Color(255,255,255));
    add(label2);

    label3 = new JLabel("Ingrese su nombre");
    label3.setBounds(45,212,200,30);
    label3.setFont(new Font("Andale Mono", 1, 12));
    label3.setForeground(new Color(255,255,255));
    add(label3);

    label4 = new JLabel("© 2024 The Company Purificadora FB");
    label4.setBounds(85,375,300,30);
    label4.setFont(new Font("Andale Mono", 1, 12));
    label4.setForeground(new Color(255,255,255));
    add(label4);

    textfield1 = new JTextField ();
    textfield1.setBounds(45,240,255,25);
    textfield1.setBackground(new Color(224,224,224));
    textfield1.setFont(new Font("Andale Mono", 1, 14));
    textfield1.setForeground(new Color(255,0,0));
    add(textfield1);

    boton1 = new JButton("Ingresar");
    boton1.setBounds(125,280,100,30);
    boton1.setBackground(new Color(255,255,255));
    boton1.setFont(new Font("Andale Mono", 1, 14));
    boton1.setForeground(new Color(255,0,0));
    boton1.addActionListener(this);
    add(boton1);
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
      texto = textfield1.getText().trim();
      
      // Si no se ingresa texto en el campo JTextField, se utiliza Scanner para pedirlo por consola
      if(texto.equals("")){
        System.out.println("No ingresaste un nombre en la interfaz gráfica.");
        System.out.println("Ingresa tu nombre desde la consola: ");
        Scanner scanner = new Scanner(System.in);
        texto = scanner.nextLine().trim();  // Pide el nombre en la consola
      }

      if(texto.equals("")){
        JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");  // Si tampoco se ingresa en consola
      } else {
        JOptionPane.showMessageDialog(null, "Bienvenido, " + texto);
        // Aquí puedes abrir la siguiente ventana o continuar la lógica
        Licencia ventanalicencia = new Licencia();
        ventanalicencia.setBounds(0,0,600,360);
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
        this.setVisible(false);
      }
    }
  }

  public static void main(String args[]){
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setBounds(0,0,350,450);
    ventanabienvenida.setVisible(true);
    ventanabienvenida.setResizable(false);
    ventanabienvenida.setLocationRelativeTo(null);
  }
}

