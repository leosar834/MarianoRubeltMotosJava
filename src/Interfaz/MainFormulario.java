/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainFormulario extends javax.swing.JFrame {

    public MainFormulario() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setTitle("REPUESTERA MOTOS");
        setResizable(false);
        menu.setBackground(new Color (75,75,75));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelfondo = new javax.swing.JPanel();
        panelizquierdo = new javax.swing.JPanel();
        labeltitulo = new javax.swing.JLabel();
        labelmenu = new javax.swing.JLabel();
        labelcomenzar = new javax.swing.JLabel();
        labelhistorial = new javax.swing.JLabel();
        labelmenu1 = new javax.swing.JLabel();
        labelaqui = new javax.swing.JLabel();
        panelbotones = new javax.swing.JPanel();
        lhistorialventa = new javax.swing.JLabel();
        lhistorialcompra = new javax.swing.JLabel();
        labelmoto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        miproductos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        miusuarios = new javax.swing.JMenuItem();
        micompras = new javax.swing.JMenuItem();
        miventas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelfondo.setBackground(new java.awt.Color(38, 58, 160));
        panelfondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelizquierdo.setBackground(new java.awt.Color(97, 97, 97));

        labeltitulo.setBackground(new java.awt.Color(97, 97, 97));
        labeltitulo.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("BIENVENIDO A REPUESTERA DE MOTOS");
        labeltitulo.setOpaque(true);

        labelmenu.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        labelmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelmenu.setText("UTILICE EL MENU SUPERIOR");

        labelcomenzar.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        labelcomenzar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcomenzar.setText("PARA COMENZAR");
        labelcomenzar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelhistorial.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        labelhistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelhistorial.setText("SI DESEA VER HISTORIALES");
        labelhistorial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelmenu1.setFont(new java.awt.Font("Century Gothic", 3, 23)); // NOI18N
        labelmenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelmenu1.setText("MARIANO RUBELT MOTOS");

        labelaqui.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        labelaqui.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaqui.setText("PRESIONE AQUI ABAJO");
        labelaqui.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        panelbotones.setBackground(new java.awt.Color(97, 97, 97));

        lhistorialventa.setBackground(new java.awt.Color(97, 97, 97));
        lhistorialventa.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lhistorialventa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lhistorialventa.setText("Historial Ventas");
        lhistorialventa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lhistorialventa.setOpaque(true);
        lhistorialventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lhistorialventaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lhistorialventaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lhistorialventaMouseExited(evt);
            }
        });

        lhistorialcompra.setBackground(new java.awt.Color(97, 97, 97));
        lhistorialcompra.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        lhistorialcompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lhistorialcompra.setText("Historial Compras");
        lhistorialcompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lhistorialcompra.setOpaque(true);
        lhistorialcompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lhistorialcompraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lhistorialcompraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lhistorialcompraMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lhistorialventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lhistorialcompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lhistorialcompra)
                .addGap(18, 18, 18)
                .addComponent(lhistorialventa)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panelizquierdoLayout = new javax.swing.GroupLayout(panelizquierdo);
        panelizquierdo.setLayout(panelizquierdoLayout);
        panelizquierdoLayout.setHorizontalGroup(
            panelizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelcomenzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelhistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelmenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelizquierdoLayout.createSequentialGroup()
                .addComponent(labeltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelaqui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelbotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelizquierdoLayout.setVerticalGroup(
            panelizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelizquierdoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labeltitulo)
                .addGap(18, 18, 18)
                .addComponent(labelmenu1)
                .addGap(46, 46, 46)
                .addComponent(labelmenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelcomenzar)
                .addGap(105, 105, 105)
                .addComponent(labelhistorial)
                .addGap(18, 18, 18)
                .addComponent(labelaqui)
                .addGap(18, 18, 18)
                .addComponent(panelbotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        panelfondo.add(panelizquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 730));

        labelmoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/motofondo2.png"))); // NOI18N
        labelmoto.setText(".");
        panelfondo.add(labelmoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 1020, 730));

        jMenuBar1.setBackground(new java.awt.Color(75, 75, 75));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        menu.setBackground(new java.awt.Color(75, 75, 75));
        menu.setText("Menu");

        miproductos.setText("Registrar Productos");
        miproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miproductosActionPerformed(evt);
            }
        });
        menu.add(miproductos);

        jMenuItem2.setText("Buscar Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem2);

        miusuarios.setText("Registrar Usuarios");
        miusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miusuariosActionPerformed(evt);
            }
        });
        menu.add(miusuarios);

        micompras.setText("Registrar Compras");
        micompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micomprasActionPerformed(evt);
            }
        });
        menu.add(micompras);

        miventas.setText("Registrar Ventas");
        miventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miventasActionPerformed(evt);
            }
        });
        menu.add(miventas);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miproductosActionPerformed
        ABML abml = new ABML();
        abml.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_miproductosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Buscar buscar = new Buscar();
        buscar.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void miusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miusuariosActionPerformed
        Usuarios usuarios = new Usuarios();
        usuarios.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_miusuariosActionPerformed

    private void micomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micomprasActionPerformed
        Compra compra = new Compra();
        compra.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_micomprasActionPerformed

    private void miventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miventasActionPerformed
        Ventas ventas = new Ventas();
        ventas.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_miventasActionPerformed

    private void lhistorialcompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialcompraMouseClicked
        HistorialCompra historialcompra = new HistorialCompra();
        historialcompra.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lhistorialcompraMouseClicked

    private void lhistorialventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialventaMouseClicked
        HistorialVenta historialventa = new HistorialVenta();
        historialventa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lhistorialventaMouseClicked

    private void lhistorialcompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialcompraMouseEntered
        lhistorialcompra.setBackground (new Color(75,75,75));
    }//GEN-LAST:event_lhistorialcompraMouseEntered

    private void lhistorialcompraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialcompraMouseExited
        lhistorialcompra.setBackground(new Color(97,97,97));
    }//GEN-LAST:event_lhistorialcompraMouseExited

    private void lhistorialventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialventaMouseEntered
        lhistorialventa.setBackground(new Color(75,75,75));
    }//GEN-LAST:event_lhistorialventaMouseEntered

    private void lhistorialventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lhistorialventaMouseExited
        lhistorialventa.setBackground(new Color(97,97,97));
    }//GEN-LAST:event_lhistorialventaMouseExited

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
            java.util.logging.Logger.getLogger(MainFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel labelaqui;
    private javax.swing.JLabel labelcomenzar;
    private javax.swing.JLabel labelhistorial;
    private javax.swing.JLabel labelmenu;
    private javax.swing.JLabel labelmenu1;
    private javax.swing.JLabel labelmoto;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JLabel lhistorialcompra;
    private javax.swing.JLabel lhistorialventa;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem micompras;
    private javax.swing.JMenuItem miproductos;
    private javax.swing.JMenuItem miusuarios;
    private javax.swing.JMenuItem miventas;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JPanel panelfondo;
    private javax.swing.JPanel panelizquierdo;
    // End of variables declaration//GEN-END:variables
}
