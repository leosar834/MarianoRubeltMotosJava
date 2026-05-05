package Interfaz;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Tabla extends javax.swing.JFrame {
private ABML Formulario;
    public Tabla(ABML formu) {
        this.Formulario = formu;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Tabla de productos");
        setBounds(750,120,600,350);
        cargarProductos();
        agregarEventoClick();
        tabla.setBackground(new Color(40,40,40));
        tabla.setSelectionForeground(Color.WHITE);
        panelscroll.getViewport().setBackground(new Color(97,97,97));
        panelscroll.setBackground(new Color(97,97,97));
    }
    
    private void agregarEventoClick() {
    tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int fila = tabla.getSelectedRow();
            if (fila == -1) return;

            // Obtener datos de la tabla
            int codigo = (int) tabla.getValueAt(fila, 0);
            String nombre = (String) tabla.getValueAt(fila, 1);
            double precio = (double) tabla.getValueAt(fila, 2);
            String categoria = (String) tabla.getValueAt(fila, 3);
            int stock = (int) tabla.getValueAt(fila, 4);

            // Enviar datos al formulario ABML
            Formulario.cargarDesdeTabla(codigo, nombre, precio, categoria, stock);
        }
    });
}
    
    public void cargarProductos() {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // limpia la tabla antes de mostrar nuevos datos

    Modelo.Catalogo catalogo = new Modelo.Catalogo();
    java.util.Vector<Control.Producto> lista = catalogo.mostrar();

    for (Control.Producto p : lista) {
        modelo.addRow(new Object[]{
            p.codigo,
            p.nombre,
            p.precio,
            p.categoria,
            p.stock
        });
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelscroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 255));

        panelscroll.setBackground(new java.awt.Color(97, 97, 97));

        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Producto", "Nombre", "Precio", "Categoria", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelscroll.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelscroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelscroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane panelscroll;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
