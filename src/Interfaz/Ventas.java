package Interfaz;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Normalizer;

import Modelo.Carrito;
import Control.Items;
import Control.Producto;
import Modelo.Catalogo;
import Conexion.Conexion;
import Control.Usuario;


public class Ventas extends javax.swing.JFrame {

    public Ventas() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cargarProductos();
        cargarUsuarios();
        setTitle("Ventas");
        setBounds(225,100,1075,540);
        setResizable(false);
        tblcarrito.setModel(modelo);
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
});
    }
    
    DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Cod Producto", "Nombre", "Precio", "Cantidad","Subtotal"},0
    );
    
    private Carrito carrito = new Carrito();
    
    private String quitarAcentos(String texto){
        if (texto == null) return null;
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("\\p{M}", "");
    }
    
    private void buscarProducto() {
        String nombreBusqueda = quitarAcentos(txtproducto.getText().trim().toLowerCase());

        DefaultTableModel modelo = (DefaultTableModel) tblproductos.getModel();
        modelo.setRowCount(0); // limpia la tabla antes de mostrar resultados

        Catalogo catalogo = new Catalogo();
        java.util.Vector<Producto> lista = catalogo.mostrar();

        for (Producto p : lista) {
            String nombreProducto = quitarAcentos(p.getNombre().toLowerCase());
            if (nombreProducto.contains(nombreBusqueda)) {
                modelo.addRow(new Object[]{
                    p.getId(),      // o p.codigo según tu clase
                    p.getNombre(),
                    p.getPrecio(),
                    p.getCategoria(),
                    p.getStock()
                });
            }
        }
    }
    
        private void cargarUsuarios(){
            cmbusuario.addItem(new Usuario (0, "Seleccione un usuario:"));
            try(Connection con = Conexion.getConnection()){
                String sql ="SELECT id_usuario, nombre from usuarios";    
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs  = ps.executeQuery();
                while(rs.next()){
                    Usuario u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre")
                    );
                    cmbusuario.addItem(u);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,"Error cargando usuarios"+ e.getMessage());
            }
        }
    private void cargarProductos() {
    DefaultTableModel modelo = (DefaultTableModel) tblproductos.getModel();
    modelo.setRowCount(0);

    Catalogo catalogo = new Catalogo();
    java.util.Vector<Control.Producto> lista = catalogo.mostrar();

    for (Control.Producto p : lista) {
        modelo.addRow(new Object[]{
            p.codigo,      // o p.getId() si lo cambiaste
            p.nombre,
            p.precio,
            p.categoria,
            p.stock
        });
    }
}
    
    private void refreshTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tblcarrito.getModel();
    modelo.setRowCount(0); // limpia todo

    for (Items item : carrito.getItems()){
        modelo.addRow(new Object[]{
            item.getProducto().getId(),
            item.getProducto().getNombre(),
            item.getProducto().getPrecio(),
            item.getCantidad(),
            item.getSubtotal()
        });
    }

    ltotal.setText(String.valueOf(carrito.getTotal()));
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelcompras = new javax.swing.JPanel();
        bquitar = new javax.swing.JButton();
        cmbusuario = new javax.swing.JComboBox<>();
        lusuario = new javax.swing.JLabel();
        lcantidad = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        bagregar = new javax.swing.JButton();
        bvaciar = new javax.swing.JButton();
        bconfirmar = new javax.swing.JButton();
        ltotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ltitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        bbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        blimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lcarrito = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcarrito = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(97, 97, 97));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelcompras.setBackground(new java.awt.Color(97, 97, 97));

        bquitar.setBackground(new java.awt.Color(38, 58, 160));
        bquitar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bquitar.setText("Quitar");
        bquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bquitarActionPerformed(evt);
            }
        });

        lusuario.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lusuario.setText("USUARIO");

        lcantidad.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lcantidad.setText("CANTIDAD");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        bagregar.setBackground(new java.awt.Color(38, 58, 160));
        bagregar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bagregar.setText("Agregar");
        bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagregarActionPerformed(evt);
            }
        });

        bvaciar.setBackground(new java.awt.Color(38, 58, 160));
        bvaciar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bvaciar.setText("Vaciar");
        bvaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvaciarActionPerformed(evt);
            }
        });

        bconfirmar.setBackground(new java.awt.Color(38, 58, 160));
        bconfirmar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bconfirmar.setText("Confirmar");
        bconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconfirmarActionPerformed(evt);
            }
        });

        ltotal.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        ltotal.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel2.setText("Total:");

        ltitulo.setFont(new java.awt.Font("Century Gothic", 3, 20)); // NOI18N
        ltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltitulo.setText("REGISTRAR VENTAS");

        jPanel1.setBackground(new java.awt.Color(38, 58, 160));

        jLabel1.setBackground(new java.awt.Color(38, 70, 200));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS DISPONIBLES");
        jLabel1.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel3.setText("Producto:");

        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproductoKeyTyped(evt);
            }
        });

        bbuscar.setBackground(new java.awt.Color(38, 58, 160));
        bbuscar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bbuscar.setText("Buscar");
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod producto", "Nombre", "Precio", "Categoria", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblproductos);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bbuscar)
                    .addComponent(blimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 58, 160));

        lcarrito.setBackground(new java.awt.Color(38, 70, 200));
        lcarrito.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lcarrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lcarrito.setText("CARRITO");
        lcarrito.setOpaque(true);

        tblcarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod producto", "Nombre", "Precio", "Cantidad", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblcarrito);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lcarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lcarrito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelcomprasLayout = new javax.swing.GroupLayout(panelcompras);
        panelcompras.setLayout(panelcomprasLayout);
        panelcomprasLayout.setHorizontalGroup(
            panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcomprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcomprasLayout.createSequentialGroup()
                        .addComponent(bagregar)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelcomprasLayout.createSequentialGroup()
                        .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelcomprasLayout.createSequentialGroup()
                                .addComponent(lcantidad)
                                .addGap(18, 18, 18)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lusuario)
                                .addGap(18, 18, 18)
                                .addComponent(cmbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelcomprasLayout.createSequentialGroup()
                                .addComponent(bquitar)
                                .addGap(34, 34, 34)
                                .addComponent(bvaciar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addComponent(bconfirmar))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(ltitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelcomprasLayout.setVerticalGroup(
            panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcomprasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(ltitulo)
                .addGap(31, 31, 31)
                .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcantidad)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lusuario)
                    .addComponent(cmbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bquitar)
                    .addComponent(bvaciar)
                    .addComponent(bconfirmar))
                .addGap(24, 24, 24)
                .addGroup(panelcomprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ltotal)
                    .addComponent(bagregar))
                .addGap(37, 37, 37))
        );

        getContentPane().add(panelcompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        int fila = tblproductos.getSelectedRow();

         if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
            return;
        }
         
        if(txtcantidad.getText().equals("0")){
             JOptionPane.showMessageDialog(this,"Cantidad invalida.");
             return;
        }
        int id = (int) tblproductos.getValueAt(fila, 0);
        String nombre = tblproductos.getValueAt(fila, 1).toString();
        double precio = Double.parseDouble(tblproductos.getValueAt(fila, 2).toString());
        int stock = Integer.parseInt(tblproductos.getValueAt(fila, 4).toString());
        int cantidad;
        try {
            cantidad = Integer.parseInt(txtcantidad.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
            return;
        }
        if (cantidad > stock) {
        JOptionPane.showMessageDialog(this,
            "La cantidad ingresada supera el stock disponible.\n" +
            "Stock disponible: " + stock,
            "Stock insuficiente",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

        Producto p = new Producto();
        p.setId(id);
        p.setNombre(nombre);
        p.setPrecio(precio);
        carrito.agregarProducto(p, cantidad);

        refreshTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_bagregarActionPerformed

    private void bquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bquitarActionPerformed
        int fila = tblcarrito.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un producto del carrito.");
        return;
    }

    // Obtiene el ID desde la tabla (columna 0)
    int idProducto = Integer.parseInt(tblcarrito.getValueAt(fila, 0).toString());

    // Quita del carrito
    carrito.quitarProducto(idProducto);

    // Refresca la tabla
    refreshTabla();

    // Actualiza total
    ltotal.setText(String.valueOf(carrito.getTotal()));
        // TODO add your handling code here:
    }//GEN-LAST:event_bquitarActionPerformed

    private void bvaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvaciarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
        "Seguro que desea vaciar carrito?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            carrito.vaciar();
            refreshTabla();
            ltotal.setText("0.0");
            txtcantidad.setText("");
            cmbusuario.setSelectedIndex(0);
        }        
    }//GEN-LAST:event_bvaciarActionPerformed

    private void bconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconfirmarActionPerformed
        if (carrito.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El carrito está vacío. Agregue productos antes de confirmar.",
                    "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
        "Esta seguro de confirmar la venta?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
        Usuario seleccionado = (Usuario) cmbusuario.getSelectedItem();

        if (seleccionado == null || seleccionado.getCodigo() == 0) {
            JOptionPane.showMessageDialog(this,
                "Seleccione un usuario para la venta.",
                "Atención", JOptionPane.WARNING_MESSAGE);
        return;
        }

        int idusuario = seleccionado.getCodigo();
        double totalVenta = carrito.getTotal();
    
        try (Connection con = Conexion.getConnection()){
            String sqlv = " INSERT INTO ventas (id_usuario,fecha,total)VALUES(?,NOW(),?)";
            PreparedStatement psv = con.prepareStatement(sqlv, Statement.RETURN_GENERATED_KEYS);
            psv.setInt(1,idusuario);
            psv.setDouble(2, totalVenta);
            psv.executeUpdate();
        
            ResultSet rs = psv.getGeneratedKeys();
            int idventa=0;
        
            if(rs.next()){
                idventa = rs.getInt(1);
            }
            String sqld = "INSERT INTO detalle_venta(id_venta, id_producto, cantidad, precio_unitario, subtotal) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psd = con.prepareStatement(sqld);
        
            String sqls = "UPDATE productos SET stock = stock - ? WHERE id_producto = ?";
            PreparedStatement pss = con.prepareStatement(sqls);
            
            for (Items item : carrito.getItems()) {

            // Guardar detalle
                psd.setInt(1, idventa);
                psd.setInt(2, item.getProducto().getId());
                psd.setInt(3, item.getCantidad());
                psd.setDouble(4, item.getProducto().getPrecio());
                psd.setDouble(5, item.getSubtotal());
                psd.addBatch();

            // Actualizar stock
                pss.setInt(1, item.getCantidad());
                pss.setInt(2, item.getProducto().getId());
                pss.addBatch();
        
            }
            psd.executeBatch();
            pss.executeBatch();
        
            JOptionPane.showMessageDialog(this,
                "Venta registrada con éxito");

        // 7. Vaciar carrito y refrescar interfaz
            carrito.vaciar();
            refreshTabla();
            ltotal.setText("0.0");
            cargarProductos();
            txtcantidad.setText("");
            txtproducto.setText("");
            cmbusuario.setSelectedIndex(0);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
                "Error al registrar la venta: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_bconfirmarActionPerformed

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
        buscarProducto();
    }//GEN-LAST:event_bbuscarActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        if(txtcantidad.getText().length()>=2){
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyTyped
        if(txtproducto.getText().length()>30){
            evt.consume();
        }
    }//GEN-LAST:event_txtproductoKeyTyped

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        txtproducto.setText("");
        cargarProductos();
    }//GEN-LAST:event_blimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bagregar;
    private javax.swing.JButton bbuscar;
    private javax.swing.JButton bconfirmar;
    private javax.swing.JButton blimpiar;
    private javax.swing.JButton bquitar;
    private javax.swing.JButton bvaciar;
    private javax.swing.JComboBox<Usuario> cmbusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lcantidad;
    private javax.swing.JLabel lcarrito;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JLabel ltotal;
    private javax.swing.JLabel lusuario;
    private javax.swing.JPanel panelcompras;
    private javax.swing.JTable tblcarrito;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
}
