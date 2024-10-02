import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {

    // Componentes de la interfaz gráfica
    private JTextField nombreField;
    private JTextField apellidoPField;
    private JTextField apellidoMField;
    private JComboBox<String> departamentoCombo;
    private JComboBox<String> antiguedadCombo;
    private JTextArea resultadoArea;
    
     private JLabel label1;
       

     private JTextField edadField;  // agreggar otro campo
    
    public Principal() {
        
   /*
    label1 = new JLabel("\n© Purificadora FB,Josman Lorenzo Morales");
    label1.setBounds(85,375,500,30);
    label1.setFont(new Font("Andale Mono", 1, 12));
    label1.setForeground(new Color(0,0,0));
    add(label1);
    
    */
                               
        // Configuración de la ventana
        setTitle("Calculadora de Vacaciones");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new FlowLayout());
        
        getContentPane().setBackground(new Color(0,0,255));
        
        
        // Inicialización de componentes
        nombreField = new JTextField(20);
        apellidoPField = new JTextField(20);
        apellidoMField = new JTextField(20);
        
        
       edadField = new JTextField(20); // agregar otro cmampo
        
        
        // Opciones de departamento
        String[] departamentos = {
            "Trabajadores de Atención al Cliente",
            "Trabajadores de Logística",
            "Gerentes de Gerencia"
        };
        
        departamentoCombo = new JComboBox<>(departamentos);

        // Opciones de antigüedad
        String[] antiguedades = {
            "1 año de servicio",
            "2 a 6 años de servicio",
            "7 años o más de servicio"
        };
        
        
        antiguedadCombo = new JComboBox<>(antiguedades);

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        // Botón para calcular vacaciones
        JButton calcularButton = new JButton("Calcular Vacaciones");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVacaciones();
            }
        });

        // Botón para limpiar campos
        JButton limpiarButton = new JButton("Limpiar Campos");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Botón para regresar a la pantalla de bienvenida
        JButton regresarButton = new JButton("Regresar a Bienvenida");
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        // Botón para nuevo cálculo
        JButton nuevoCalculoButton = new JButton("Nuevo Cálculo");
        nuevoCalculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoCalculo();
            }
        });

        // Agregar componentes a la ventana
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido Paterno:"));
        add(apellidoPField);
        add(new JLabel("Apellido Materno:"));
        add(apellidoMField);
        add(new JLabel("Departamento:"));
        add(departamentoCombo);
        add(new JLabel("Antigüedad:"));
        add(antiguedadCombo);
        
      add(new JLabel("Edad:")); //  agregar otro campo
      add(edadField);
        
        
        add(calcularButton);
        add(limpiarButton);
        add(regresarButton);
        add(nuevoCalculoButton);
        add(new JScrollPane(resultadoArea)); // Agregar scroll para el área de texto
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true); // Hacer visible la ventana
    }

    private void calcularVacaciones() {
        String nombreTrabajador = nombreField.getText();
        String AP = apellidoPField.getText();
        String AM = apellidoMField.getText();
        String departamento = (String) departamentoCombo.getSelectedItem();
        String antiguedad = (String) antiguedadCombo.getSelectedItem();
        
       String edad = edadField.getText(); // agregar otro campo
        

        String resultado = calcularVacaciones(nombreTrabajador, AP, AM, departamento, antiguedad  ,edad);
        resultadoArea.setText(resultado); 
    }

    public static String calcularVacaciones(String nombre, String AP, String AM, String departamento, String antiguedad , String edad) {
        String resultado = "";

        if (departamento.equals("Trabajadores de Atención al Cliente")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM + "\nEdad "+ edad+ 
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 6 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad+
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 14 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            }
        } else if (departamento.equals("Trabajadores de Logística")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 7 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad+
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 15 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 22 días de vacaciones.";
            }
        } else if (departamento.equals("Gerentes de Gerencia")) { // Corrección aquí
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 10 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +  "\nEdad "+ edad +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 30 días de vacaciones.";
            }
        }

        return resultado;
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        nombreField.setText("");
        apellidoPField.setText("");
        apellidoMField.setText("");
        resultadoArea.setText("");
        
        // edadField.setText(""); // agregar otro campo
        
        departamentoCombo.setSelectedIndex(0);
        antiguedadCombo.setSelectedIndex(0);
    }
    
    // Método para preparar un nuevo cálculo
    private void nuevoCalculo() {
        limpiarCampos();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible); 
    }
}
