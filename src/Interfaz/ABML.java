package Interfaz;
import Control.Producto;
import Modelo.Catalogo;
import javax.swing.*;
public class ABML extends javax.swing.JFrame {
private Tabla tabla;
    public ABML() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Productos");
        setBounds(25,200,738,345);
        setResizable(false);
        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });
        bguardar.setEnabled(true);
        beditar.setEnabled(false);
    }
    private boolean edit= false;
        
    public void cargarDesdeTabla(int codigo, String nombre, double precio, String categoria, int stock) {
        txtnombre.setText(nombre);
        txtprecio.setText(String.valueOf(precio));
        txtstock.setText(String.valueOf(stock));
        cbcategorias.setSelectedItem(categoria);
        edit=true;
        bguardar.setEnabled(false);
        beditar.setEnabled(true);
    }
    
    public void cargarDesdeTabla(String nombre,double precio, int stock, String categoria) {
        txtnombre.setText(nombre);
        txtprecio.setText(String.valueOf(precio));
        txtstock.setText(String.valueOf(stock));
        cbcategorias.setSelectedItem(categoria);
        edit=true;
        bguardar.setEnabled(false);
        beditar.setEnabled(true);
    }
    private void limpiarFormulario() {
        txtnombre.setText("");
        txtprecio.setText("");
        txtstock.setText("");
        cbcategorias.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        ltitulo = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        beditar = new javax.swing.JButton();
        bborrar = new javax.swing.JButton();
        bmostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        abmlnombre = new javax.swing.JLabel();
        abmlcategoria = new javax.swing.JLabel();
        cbcategorias = new javax.swing.JComboBox<>();
        abmlprecio = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        lstock = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        blimpiar = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 97, 97));

        ltitulo.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        ltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltitulo.setText("REGISTRAR PRODUCTO");

        bguardar.setBackground(new java.awt.Color(38, 58, 160));
        bguardar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bguardar.setText("Guardar");
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });

        beditar.setBackground(new java.awt.Color(38, 58, 160));
        beditar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        beditar.setText("Editar");
        beditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditarActionPerformed(evt);
            }
        });

        bborrar.setBackground(new java.awt.Color(38, 58, 160));
        bborrar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bborrar.setText("Borrar");
        bborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bborrarActionPerformed(evt);
            }
        });

        bmostrar.setBackground(new java.awt.Color(38, 58, 160));
        bmostrar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bmostrar.setText("Mostrar");
        bmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmostrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(38, 58, 160));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        abmlnombre.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        abmlnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abmlnombre.setText("NOMBRE:");

        abmlcategoria.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        abmlcategoria.setText("CATEGORIA:");

        cbcategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria", "Aceites", "Liquido de freno", "Aceite suspension", "Juegos de transmision", "Fundas", "Zapatas de freno trasera", "Pastillas de freno delantera", "Rulemanes", "Focos", "Cables", "Camaras", "Baterias", "Accesorios Varios" }));

        abmlprecio.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        abmlprecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abmlprecio.setText("PRECIO:");

        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        lstock.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lstock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lstock.setText("STOCK:");

        txtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstockKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/motoproductos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(abmlnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lstock, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(abmlprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(abmlcategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbcategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abmlnombre)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abmlcategoria)
                            .addComponent(cbcategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abmlprecio)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lstock)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        blimpiar.setBackground(new java.awt.Color(38, 58, 160));
        blimpiar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        blimpiar.setText("Limpiar");
        blimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blimpiar)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bguardar)
                    .addComponent(beditar)
                    .addComponent(bborrar)
                    .addComponent(bmostrar)
                    .addComponent(blimpiar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void bmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmostrarActionPerformed
        if (tabla == null) {
            tabla = new Tabla(this);
        }
        tabla.cargarProductos(); 
        tabla.setVisible(true);
        tabla.toFront();
        // TODO add your handling code here:
    }//GEN-LAST:event_bmostrarActionPerformed

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        if (edit) return;
        if(txtnombre.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Por favor ingrese el nombre del producto.");
            return;
        }
        if(txtprecio.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Por favor ingrese el precio del producto.");
            return;
        }
        if(cbcategorias.getSelectedItem().equals("Seleccione una categoria")){
            JOptionPane.showMessageDialog(null,"Por favor seleccione una categoria.");
            return;
        }
        if(txtstock.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Por favor ingrese cuanto tiene en stock.");
            return;
        }
        double precio;
        int stock;
        try {
        precio = Double.parseDouble(txtprecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
            return;
        }

        try {
            stock = Integer.parseInt(txtstock.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El stock debe ser un número entero.");
            return;        
        }
        String nombre = txtnombre.getText();
        String categoria = cbcategorias.getSelectedItem().toString();
        

        Modelo.Catalogo c = new Modelo.Catalogo();
        int id_categoria = c.categoria(categoria);
        
        if (id_categoria <= 0) {
        JOptionPane.showMessageDialog(null, "Error: Categoría no válida o no encontrada en la base de datos.");
        return;
        }
        Control.Producto p = new Control.Producto(0, nombre, precio, id_categoria, stock);
        c.guardar(p);
        
        txtnombre.setText("");
        txtprecio.setText("");
        txtstock.setText("");
        cbcategorias.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(null, "Producto guardado correctamente.");
        // TODO add your handling code here:
    }//GEN-LAST:event_bguardarActionPerformed

    private void beditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditarActionPerformed
        String ids = JOptionPane.showInputDialog("Ingrese el Codigo del producto a editar");
            if(ids == null) return;
        int confirm = JOptionPane.showConfirmDialog(this,
        "Esta seguro que desea editar este producto?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            int id;
        
            try{
                id = Integer.parseInt(ids);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese un Codigo valido:");
                return;
            }
            
            String nombre = txtnombre.getText();
            double precio;
            int stock;
            try{
                precio = Double.parseDouble(txtprecio.getText());
                stock = Integer.parseInt(txtstock.getText());
            }catch (NumberFormatException e){
             return;   
            }

            String categoria = cbcategorias.getSelectedItem().toString();
            Catalogo c = new Catalogo();
            int id_categoria = c.categoria(categoria);

            Producto p = new Producto(id, nombre, precio, id_categoria, stock);

            if (c.editar(p)) {
                JOptionPane.showMessageDialog(null, "Producto editado correctamente.");
            } else {
            JOptionPane.showMessageDialog(null, "No se pudo editar el producto.");
        }
            edit=false;
            bguardar.setEnabled(true);
            beditar.setEnabled(false);
            limpiarFormulario();
            
            if (tabla != null && tabla.isVisible()) {
            tabla.cargarProductos();
            }
        }
    }//GEN-LAST:event_beditarActionPerformed

    private void bborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bborrarActionPerformed
        String ids = JOptionPane.showInputDialog("Ingrese el Codigo del producto a borrar:");
        if (ids == null) return;

        int confirm = JOptionPane.showConfirmDialog(this,
        "Esta seguro que desea eliminar este producto?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
        int id;

        try {
            id = Integer.parseInt(ids);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un Codigo válido.");
            return;
        }

        Producto p = new Producto();
        p.codigo = id;

        Catalogo c = new Catalogo();

        if (c.borrar(p)) {
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.");
        }
        if (tabla != null && tabla.isVisible()) {
        tabla.cargarProductos();
        }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_bborrarActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        if(txtprecio.getText().length()>5){
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockKeyTyped
        if(txtstock.getText().length()>3){
            evt.consume();
        }
    }//GEN-LAST:event_txtstockKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
            if(txtnombre.getText().length()>30){
                evt.consume();
            }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        txtnombre.setText("");
        cbcategorias.setSelectedIndex(0);
        txtprecio.setText("");
        txtstock.setText("");
        bguardar.setEnabled(true);
        beditar.setEnabled(false);
        if(tabla != null){
        tabla.setVisible(false);
        }
    }//GEN-LAST:event_blimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(ABML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abmlcategoria;
    private javax.swing.JLabel abmlnombre;
    private javax.swing.JLabel abmlprecio;
    private javax.swing.JButton bborrar;
    private javax.swing.JButton beditar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton blimpiar;
    private javax.swing.JButton bmostrar;
    private javax.swing.JComboBox<String> cbcategorias;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lstock;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables
}
