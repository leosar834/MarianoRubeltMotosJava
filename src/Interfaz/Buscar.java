package Interfaz;
import javax.swing.*;
import Conexion.Conexion;
import Control.Producto;
import Modelo.Catalogo;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Buscar extends javax.swing.JFrame {

    public Buscar() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        setTitle("Buscar un Producto");
        setResizable(false);
        setBounds(200,100,750,410);
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });
        tablabuscar.setBackground(new Color(40,40,40));
        tablabuscar.setSelectionForeground(Color.WHITE);
        panetablabuscar.getViewport().setBackground(new Color(97,97,97));
        panetablabuscar.setBackground(new Color(97,97,97));
    }
    
    private void buscarProducto() {
    String nombre = txtbusqueda.getText().trim().toLowerCase();
    String categoria = cmbcategoria.getSelectedItem().toString();
    String precioTexto = txtprecio.getText().trim();
    

    Catalogo catalogo = new Catalogo();
    java.util.Vector<Producto> lista = catalogo.mostrar();
    
    StringBuilder sql = new StringBuilder(
        "SELECT p.id_producto, p.nombre, p.precio, c.nombre AS categoria, p.stock " +
        "FROM productos p " +
        "INNER JOIN categoria c ON p.id_categoria = c.id_categoria " +
        "WHERE 1 = 1 "
    );

    // Lista para parámetros dinámicos
    java.util.List<Object> params = new java.util.ArrayList<>();

    if (!nombre.isEmpty()) {
        sql.append(" AND p.nombre LIKE ? ");
        params.add("%" + nombre + "%");
    }

    if (!categoria.equals("Seleccione una categoria")) {
        sql.append(" AND c.nombre = ? ");
        params.add(categoria);
    }

    if (!precioTexto.isEmpty()) {
        try {
            double precio = Double.parseDouble(precioTexto);
            sql.append(" AND p.precio = ? ");
            params.add(precio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio inválido");
            return;
        }
    }

    DefaultTableModel modelo = (DefaultTableModel) tablabuscar.getModel();
    modelo.setRowCount(0);

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())) {

        // Cargar parámetros en orden
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_producto"),
                rs.getString("nombre"),
                rs.getDouble("precio"),
                rs.getString("categoria"),
                rs.getInt("stock")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panetablabuscar = new javax.swing.JScrollPane();
        tablabuscar = new javax.swing.JTable();
        bbuscar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        lbuscar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cmbcategoria = new javax.swing.JComboBox<>();
        buscarlcategoria = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        buscarlnombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 97, 97));

        tablabuscar.setForeground(new java.awt.Color(255, 255, 255));
        tablabuscar.setModel(new javax.swing.table.DefaultTableModel(
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
        panetablabuscar.setViewportView(tablabuscar);

        bbuscar.setBackground(new java.awt.Color(38, 58, 160));
        bbuscar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bbuscar.setText("Buscar");
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        blimpiar.setBackground(new java.awt.Color(38, 58, 160));
        blimpiar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        blimpiar.setText("Limpiar");
        blimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blimpiarActionPerformed(evt);
            }
        });

        lbuscar.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        lbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbuscar.setText("BUSCAR PRODUCTO");

        jPanel2.setBackground(new java.awt.Color(38, 58, 160));

        cmbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria", "Aceites", "Liquido de freno", "Aceite suspension", "Juegos de Transmision", "Fundas", "Zapatas de freno trasera", "Pastillas de freno delantera", "Rulemanes", "Focos", "Cables", "Camaras", "Baterias", "Accesorios varios" }));

        buscarlcategoria.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        buscarlcategoria.setText("CATEGORIA:");

        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        buscarlnombre.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        buscarlnombre.setText("NOMBRE:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRECIO:");

        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buscarlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(buscarlcategoria)
                        .addGap(18, 18, 18)
                        .addComponent(cmbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarlnombre)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarlcategoria)
                    .addComponent(cmbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(blimpiar))
                    .addComponent(panetablabuscar)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbuscar)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbuscar)
                    .addComponent(blimpiar))
                .addGap(18, 18, 18)
                .addComponent(panetablabuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
        buscarProducto();
        // TODO add your handling code here:
    }//GEN-LAST:event_bbuscarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        txtbusqueda.setText("");
        txtprecio.setText("");
        cmbcategoria.setSelectedIndex(0);
        ((javax.swing.table.DefaultTableModel) tablabuscar.getModel()).setRowCount(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_blimpiarActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        if(txtprecio.getText().length() >5){
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
        if(txtbusqueda.getText().length()>30){
            evt.consume();
        }
    }//GEN-LAST:event_txtbusquedaKeyTyped

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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbuscar;
    private javax.swing.JButton blimpiar;
    private javax.swing.JLabel buscarlcategoria;
    private javax.swing.JLabel buscarlnombre;
    private javax.swing.JComboBox<String> cmbcategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbuscar;
    private javax.swing.JScrollPane panetablabuscar;
    private javax.swing.JTable tablabuscar;
    private javax.swing.JTextField txtbusqueda;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
