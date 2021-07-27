package records;

import util.ConnectDB;
import capture.ControlPerson;
import capture.ModelPerson;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

public class Data extends javax.swing.JDialog {

    ConnectDB con = new ConnectDB();
    ControlPerson cod = new ControlPerson();

    public Data(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        paint_table();
        cod.preencherTabela("SELECT * FROM person ORDER BY id", tabela);
    }

    public Data() {
        initComponents();
        paint_table();
        cod.preencherTabela("SELECT * FROM person ORDER BY id", tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        botaoexcluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        txt_name = new javax.swing.JTextField();
        sendMessage_btn = new keeptoo.KButton();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        txt_lastname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        botaoexcluir.setText("Excluir");
        botaoexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoexcluirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(botaoexcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 158, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.setFillsViewportHeight(true);
        tabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaFocusGained(evt);
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 390, 380));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 780, 10));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(118, 118, 118));
        jLabel2.setText("Last Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        kGradientPanel7.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkFillBackground(false);
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 123, 255));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_name.setBorder(null);
        txt_name.setOpaque(false);
        kGradientPanel7.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 30));

        jPanel2.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, 30));

        sendMessage_btn.setText("Save");
        sendMessage_btn.setkAllowTab(false);
        sendMessage_btn.setkEndColor(new java.awt.Color(118, 195, 118));
        sendMessage_btn.setkHoverEndColor(new java.awt.Color(22, 92, 22));
        sendMessage_btn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        sendMessage_btn.setkHoverStartColor(new java.awt.Color(80, 142, 80));
        sendMessage_btn.setkPressedColor(new java.awt.Color(28, 72, 28));
        sendMessage_btn.setkStartColor(new java.awt.Color(87, 167, 87));
        sendMessage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessage_btnActionPerformed(evt);
            }
        });
        jPanel2.add(sendMessage_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 390, 30));
        sendMessage_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        kGradientPanel8.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkFillBackground(false);
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 123, 255));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_lastname.setBorder(null);
        txt_lastname.setOpaque(false);
        kGradientPanel8.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 30));

        jPanel2.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 180, 30));

        jLabel9.setForeground(new java.awt.Color(118, 118, 118));
        jLabel9.setText("First Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 390, 310));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(100, 100, 100));
        jLabel13.setText("Records");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(57, 129, 215));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(90, 68, 193));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ID Face");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        txt_id_label.setBackground(new java.awt.Color(132, 242, 145));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        jButton1.setBackground(new java.awt.Color(213, 83, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_15px_1.png"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 30, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 680, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(135, 135, 136));
        jLabel12.setText("Info");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 480));

        setSize(new java.awt.Dimension(820, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaFocusGained
      
    }//GEN-LAST:event_tabelaFocusGained

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(tabela, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaMouseReleased

    int id;

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        con.createConnection();
        try {
            String name = "" + tabela.getValueAt(tabela.getSelectedRow(), 1);
            con.executeSQL("SELECT * FROM person WHERE id = '" + name + "'");
            con.rs.first();
            id = con.rs.getInt("id");
            txt_id_label.setText(String.valueOf(id));
            txt_name.setText(String.valueOf(con.rs.getString("first_name")));
            txt_lastname.setText(String.valueOf(con.rs.getString("last_name")));
            
        } catch (SQLException s) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao Selecionar os Dados!\nErro:" + s);
        }
        con.disconnect();
    }//GEN-LAST:event_tabelaMouseClicked

    private void botaoexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoexcluirActionPerformed
       
    }//GEN-LAST:event_botaoexcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendMessage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessage_btnActionPerformed
        ModelPerson mod = new ModelPerson();
        mod.setId(id);
        mod.setFirst_name(txt_name.getText());
        mod.setLast_name(txt_lastname.getText());
        cod.update(mod, id);
    }//GEN-LAST:event_sendMessage_btnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data dialog = new Data(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botaoexcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KButton sendMessage_btn;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

    private void paint_table() {
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(60, 127, 177));
        tabela.getTableHeader().setForeground(new Color(255, 255, 255));
        tabela.setRowHeight(50);
    }

}