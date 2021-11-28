package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones,panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion() {
        initGUI();

        //Configuracion base de la ventana
        this.setTitle("Mi presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos escucha y control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("¡Hola! Soy Juanes, oprime los botones...", Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);



        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",TitledBorder.CENTER,
                TitledBorder.DEFAULT_JUSTIFICATION, new Font("Calibri",Font.PLAIN,20 ), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);


        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.setFocusable(true);

        this.add(panelBotones, BorderLayout.SOUTH);


        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,12);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }
// Codigo anterior implementando AccionListener
    /*private class Escucha implements ActionListener{
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
           // JOptionPane.showMessageDialog(null, "Me oprimiste");
            panelDatos.removeAll();
            if(e.getSource()== miFoto){
                image =  new ImageIcon(getClass().getResource("/recursos/yo2.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()== miHobby){
                    image =  new ImageIcon(getClass().getResource("/recursos/gamer2.png"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectativas.setText("Se programar en general pero no se mucho sobre la sintaxis de java. \n" +
                            "Quiero ser capaz de crear programas con GUI´s y poder mostrar mi trabajo para facilitar tareas de personas \n" +
                            "que conozco, que tienen su propio negocio.");
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }*/

    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getComponent()==miFoto && e.getClickCount()==1){
                panelDatos.removeAll();
                image =  new ImageIcon(getClass().getResource("/recursos/yo2.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }if(e.getComponent()==miHobby && e.getClickCount()==2){
                panelDatos.removeAll();
                image =  new ImageIcon(getClass().getResource("/recursos/gamer2.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar()== 'm' || e.getKeyChar()=='M'){
                panelDatos.removeAll();
                textoExpectativas.setText("Se programar en general pero no se mucho sobre la sintaxis de java. \n" +
                        "Quiero ser capaz de crear programas con GUI´s y poder mostrar mi trabajo para facilitar tareas de personas \n" +
                        "que conozco, que tienen su propio negocio.");
                textoExpectativas.setBackground(null);
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
