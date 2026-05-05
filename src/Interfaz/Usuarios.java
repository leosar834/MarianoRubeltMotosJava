package Interfaz;
import javax.swing.*;
import Modelo.Agenda;
import Control.Usuario;
import java.awt.Color;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JFrame {
    Agenda agenda = new Agenda();
    Usuario usuario = new Usuario();
    DefaultTableModel modelo;
    private boolean edit=false;
    private int idedicion=0;
    
    public Usuarios() {
        initComponents();
        cargarUsuarios();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setBounds(300,100,850,500);
        setResizable(false);
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });
        tablausers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tablausers.getSelectedRow();
                if (fila == -1) return;

        int id = (int) tablausers.getValueAt(fila, 0);
        
        String nombre = tablausers.getValueAt(fila, 1).toString();
        String apellido = tablausers.getValueAt(fila, 2).toString();
        String dni = tablausers.getValueAt(fila, 3).toString();
        String email = tablausers.getValueAt(fila, 4).toString();
        String domicilio = tablausers.getValueAt(fila, 5).toString();
        String usuario = tablausers.getValueAt(fila, 6).toString();
        
        cargarDesdeTabla(id,nombre,apellido,dni,email,domicilio,usuario);
            }
        });
        tablausers.setBackground(new Color(40,40,40));
        tablausers.setSelectionForeground(Color.WHITE);
        panelusers.getViewport().setBackground(new Color(97,97,97));
        panelusers.setBackground(new Color(97,97,97));
        bguardar.setEnabled(true);
        bmodificar.setEnabled(false);
    }
    
    private void cargarDesdeTabla(int id, String nombre, String apellido, String dni, String email, String domicilio,String usuario){
        int fila=tablausers.getSelectedRow();
        txtnombre.setText(nombre);
        txtapellido.setText(apellido);
        txtdni.setText(dni);
        txtemail.setText(email);
        txtdomicilio.setText(domicilio);
        txtusuario.setText(usuario);
        
        idedicion=id;
        edit=true;
        bguardar.setEnabled(false);
        bmodificar.setEnabled(true);
    }
    private void limpiarFormulario() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtdni.setText("");
        txtemail.setText("");
        txtdomicilio.setText("");
        txtusuario.setText("");

        edit = false;

        bguardar.setEnabled(true);
        bmodificar.setEnabled(false);
    }
    
    private void cargarUsuarios() {
        modelo = (DefaultTableModel) tablausers.getModel();
        modelo.setRowCount(0);
        Vector<Usuario> usuarios = agenda.Mostrar();
        int i = 1;

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{
                u.codigo,
                u.nombre,
                u.apellido,
                u.dni,
                u.email,
                u.domicilio,
                u.usuario,
            });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelusuario = new javax.swing.JPanel();
        lusuarios = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        panelusers = new javax.swing.JScrollPane();
        tablausers = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        lnombre = new javax.swing.JLabel();
        lapellido = new javax.swing.JLabel();
        lusuario = new javax.swing.JLabel();
        ldni = new javax.swing.JLabel();
        lemail = new javax.swing.JLabel();
        ldomicilio = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtdomicilio = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        bmodificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelusuario.setBackground(new java.awt.Color(97, 97, 97));

        lusuarios.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lusuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lusuarios.setText("REGISTRO DE USUARIOS");

        bguardar.setBackground(new java.awt.Color(38, 58, 160));
        bguardar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bguardar.setText("Guardar");
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
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

        beliminar.setBackground(new java.awt.Color(38, 58, 160));
        beliminar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
            }
        });

        tablausers.setForeground(new java.awt.Color(255, 255, 255));
        tablausers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod Usuario", "Nombre", "Apellido", "DNI", "Email", "Domicilio", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelusers.setViewportView(tablausers);

        jPanel1.setBackground(new java.awt.Color(38, 58, 160));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        lnombre.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnombre.setText("NOMBRE:");

        lapellido.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lapellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lapellido.setText("APELLIDO:");

        lusuario.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lusuario.setText("USUARIO:");

        ldni.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        ldni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldni.setText("DNI:");

        lemail.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lemail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lemail.setText("EMAIL:");

        ldomicilio.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        ldomicilio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldomicilio.setText("DOMICILIO:");

        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        txtdomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdomicilioKeyTyped(evt);
            }
        });

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lapellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lnombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(202, 202, 202)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ldni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lusuario)
                        .addGap(18, 18, 18)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ldomicilio)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnombre)
                    .addComponent(ldni)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lapellido)
                    .addComponent(lemail)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lusuario)
                    .addComponent(ldomicilio)
                    .addComponent(txtdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        bmodificar.setBackground(new java.awt.Color(38, 58, 160));
        bmodificar.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        bmodificar.setText("Modificar");
        bmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelusuarioLayout = new javax.swing.GroupLayout(panelusuario);
        panelusuario.setLayout(panelusuarioLayout);
        panelusuarioLayout.setHorizontalGroup(
            panelusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lusuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelusuarioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelusers, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(panelusuarioLayout.createSequentialGroup()
                        .addComponent(bguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bmodificar)))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        panelusuarioLayout.setVerticalGroup(
            panelusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelusuarioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lusuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bguardar)
                    .addComponent(blimpiar)
                    .addComponent(beliminar)
                    .addComponent(bmodificar))
                .addGap(27, 27, 27)
                .addComponent(panelusers, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Esta seguro que desea agregar este usuario?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    if(txtnombre.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Por favor ingrese el nombre");
                    return;
                }
            if(txtapellido.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Por favor ingrese el apellido");
                return;
            }
            if(txtdni.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Por favor ingrese el DNI");
                return;
            }
            if(txtemail.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Por favor ingrese el email");
                return;
            }
            if(txtdomicilio.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Por favor ingrese el domicilio");
                return;
            }
            if(txtusuario.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Por favor ingrese el usuario");
                return;
            }
            String nombre,apellido,dni,email,domicilio,usuario,contraseña;
            nombre=txtnombre.getText();
            apellido=txtapellido.getText();
            dni=txtdni.getText();
            email=txtemail.getText();
            domicilio=txtdomicilio.getText();
            usuario=txtusuario.getText();
        
            Usuario user = new Usuario(nombre,apellido,dni,email,domicilio,usuario);
            agenda.GuardarUsuario(user);
        
            cargarUsuarios();
            txtnombre.setText("");
            txtapellido.setText("");
            txtdni.setText("");
            txtemail.setText("");
            txtdomicilio.setText("");
            txtusuario.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        txtnombre.setText("");
        txtapellido.setText("");
        txtdni.setText("");
        txtemail.setText("");
        txtdomicilio.setText("");
        txtusuario.setText("");
        bguardar.setEnabled(true);
        bmodificar.setEnabled(false);
        cargarUsuarios();
        // TODO add your handling code here:
    }//GEN-LAST:event_blimpiarActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        if(txtnombre.getText().length()>=14){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        if(txtapellido.getText().length()>=20){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        if(txtdni.getText().length()>=8){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniKeyTyped

    private void txtdomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdomicilioKeyTyped
        if(txtdomicilio.getText().length()>=50){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdomicilioKeyTyped

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        if(txtusuario.getText().length()>=20){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        String ids = JOptionPane.showInputDialog("Ingrese el Codigo del usuario a borrar:");
        if (ids == null) return;

        int id;

        try {
            id = Integer.parseInt(ids);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un Codigo válido.");
            return;
        }
        Usuario u = new Usuario();
        u.codigo = id;  

         Agenda agenda = new Agenda(); 

        if (agenda.borrar(u)) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.");
        }
        cargarUsuarios();
        limpiarFormulario();
        // TODO add your handling code here:
    }//GEN-LAST:event_beliminarActionPerformed

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        if(txtemail.getText().length() >50){
            evt.consume();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
        if (!edit){
            JOptionPane.showMessageDialog(null, "Seleccione un usuario desde la tabla.");
            return;
        }
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String dni = txtdni.getText();
        String email = txtemail.getText();
        String domicilio = txtdomicilio.getText();
        String usuario = txtusuario.getText();

    Control.Usuario u = new Control.Usuario(idedicion,nombre, apellido, dni, email, domicilio, usuario);

    Modelo.Agenda a = new Modelo.Agenda();

    if (a.editar(u)) {
        JOptionPane.showMessageDialog(null, "Usuario editado correctamente.");
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo editar el usuario.");
    }

    edit = false;
    bguardar.setEnabled(true);
    bmodificar.setEnabled(false);
    limpiarFormulario();
    cargarUsuarios();
    
    }//GEN-LAST:event_bmodificarActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton blimpiar;
    private javax.swing.JButton bmodificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lapellido;
    private javax.swing.JLabel ldni;
    private javax.swing.JLabel ldomicilio;
    private javax.swing.JLabel lemail;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lusuario;
    private javax.swing.JLabel lusuarios;
    private javax.swing.JScrollPane panelusers;
    private javax.swing.JPanel panelusuario;
    private javax.swing.JTable tablausers;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtdomicilio;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
