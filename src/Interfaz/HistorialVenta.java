package Interfaz;

import Conexion.Conexion;
import Control.Usuario;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistorialVenta extends javax.swing.JFrame {

    public HistorialVenta() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cargarVentas();
        cargarUsuarios();
        setTitle("Total de ventas");
        cbusuario.addActionListener(e -> filtrar());
        setResizable(false);
        setBounds(200,100,900,500);
        tablahistventa.setBackground(new Color(40,40,40));
        tablahistventa.setSelectionForeground(Color.WHITE);
        panelscroll.getViewport().setBackground(new Color(97,97,97));
        panelscroll.setBackground(new Color(97,97,97));
    }

    private void cargarUsuarios(){
            cbusuario.addItem(new Usuario (0, "Todos:"));
            try(Connection con = Conexion.getConnection()){
                String sql ="SELECT id_usuario, nombre from usuarios";    
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs  = ps.executeQuery();
                while(rs.next()){
                    Usuario u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre")
                    );
                    cbusuario.addItem(u);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,"Error cargando usuarios"+ e.getMessage());
            }
        }
    private void filtrar(){
         Usuario u = (Usuario) cbusuario.getSelectedItem();
        int idUsuario = u.getCodigo();

        DefaultTableModel modelo = (DefaultTableModel) tablahistventa.getModel();
        modelo.setRowCount(0);

        String sql;

        if (idUsuario == 0) {  // 0 = Todos
            sql = "SELECT v.id_venta, u.nombre AS usuario, v.fecha, v.total, "
                + "GROUP_CONCAT(CONCAT(p.nombre, ' (x', d.cantidad, ')') SEPARATOR ', ') AS productos "
                + "FROM ventas v "
                + "INNER JOIN detalle_venta d ON v.id_venta = d.id_venta "
                + "INNER JOIN productos p ON d.id_producto = p.id_producto "
                + "INNER JOIN usuarios u ON v.id_usuario = u.id_usuario "
                + "GROUP BY v.id_venta "
                + "ORDER BY v.fecha DESC";
        } else {
            sql = "SELECT v.id_venta, u.nombre AS usuario, v.fecha, v.total, "
                + "GROUP_CONCAT(CONCAT(p.nombre, ' (x', d.cantidad, ')') SEPARATOR ', ') AS productos "
                + "FROM ventas v "
                + "INNER JOIN detalle_venta d ON v.id_venta = d.id_venta "
                + "INNER JOIN productos p ON d.id_producto = p.id_producto "
                + "INNER JOIN usuarios u ON v.id_usuario = u.id_usuario "
                + "WHERE v.id_usuario = ? "
                + "GROUP BY v.id_venta "
                + "ORDER BY v.fecha DESC";
        }

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            if (idUsuario != 0) {
                ps.setInt(1, idUsuario);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_venta"),
                    rs.getString("usuario"),
                    rs.getString("fecha"),
                    rs.getDouble("total"),
                    rs.getString("productos")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error filtrando ventas: " + e.getMessage());
        }
    }
    
    public void cargarVentas() {
    DefaultTableModel modelo = (DefaultTableModel) tablahistventa.getModel();
    modelo.setRowCount(0);

    String sql = "SELECT v.id_venta, u.nombre AS usuario, v.fecha, v.total, "
           + "GROUP_CONCAT(CONCAT(p.nombre, ' (x', d.cantidad, ')') SEPARATOR ', ') AS productos "
           + "FROM ventas v "
           + "INNER JOIN detalle_venta d ON v.id_venta = d.id_venta "
           + "INNER JOIN productos p ON d.id_producto = p.id_producto "
           + "INNER JOIN usuarios u ON v.id_usuario = u.id_usuario "
           + "GROUP BY v.id_venta "
           + "ORDER BY v.fecha DESC";


    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_venta"),
                rs.getString("usuario"),
                rs.getString("fecha"),
                rs.getDouble("total"),
                rs.getString("productos")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelscroll = new javax.swing.JScrollPane();
        tablahistventa = new javax.swing.JTable();
        ltitulo = new javax.swing.JLabel();
        lusuario = new javax.swing.JLabel();
        cbusuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 97, 97));

        panelscroll.setForeground(new java.awt.Color(255, 255, 255));

        tablahistventa.setForeground(new java.awt.Color(255, 255, 255));
        tablahistventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod venta", "Usuario", "Fecha", "Total", "Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelscroll.setViewportView(tablahistventa);

        ltitulo.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        ltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltitulo.setText("HISTORIAL VENTAS");

        lusuario.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lusuario.setText("Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelscroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(ltitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lusuario)
                .addGap(18, 18, 18)
                .addComponent(cbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ltitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lusuario)
                    .addComponent(cbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(HistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Usuario> cbusuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JLabel lusuario;
    private javax.swing.JScrollPane panelscroll;
    private javax.swing.JTable tablahistventa;
    // End of variables declaration//GEN-END:variables
}
