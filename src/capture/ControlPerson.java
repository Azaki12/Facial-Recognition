package capture;

import util.ConnectDB;
import util.ModelTable;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class ControlPerson {

    ConnectDB con = new ConnectDB();

    public void insert(ModelPerson mod) {
        // String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));

        try {
            con.createConnection();
            PreparedStatement pst = con.conn.prepareStatement("INSERT INTO person (id, first_name, last_name) VALUES (?, ?, ?)");
            pst.setInt(1, mod.getId());
            pst.setString(2, mod.getFirst_name());
            pst.setString(3, mod.getLast_name());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Name of saved person " + mod.getFirst_name() + " " + mod.getLast_name());
            con.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void update(ModelPerson mod, int id) {
        con.createConnection();
        try {
            PreparedStatement pst = con.conn.prepareStatement("UPDATE person SET first_name= ?, last_name= ? WHERE id=?");
            
            pst.setString(1, mod.getFirst_name());
            pst.setString(2, mod.getLast_name());
            pst.setInt(3, id);
            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error\n Error: " + ex);
        }
        con.disconnect();
    }

    public void preencherTabela(String SQL, JTable tabela) {
        String id = null;

        con.createConnection();
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"", "ID", "Name"};
        con.executeSQL(SQL);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{
                    "",
                    con.rs.getString("id"),
                    con.rs.getString("first_name") + " " + con.rs.getString("last_name")});

            } while (con.rs.next());
        } catch (SQLException ex) {

        } finally {
            con.disconnect();
        }

        ModelTable modelo = new ModelTable(dados, Colunas);
        tabela.setModel((TableModel) modelo);
        tabela.getColumnModel().getColumn(0).setCellRenderer(new ControlPerson.ImageRenderer());
        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getColumnModel().getColumn(1).setMinWidth(0);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    class ImageRenderer implements TableCellRenderer {

        public JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                Object text = table.getValueAt(row, 1);
                File image = new File("src\\photos\\person." + text + ".1.jpg");
                String path = image.getAbsolutePath();
                ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage().getScaledInstance(lbl.getWidth() + 50, lbl.getHeight() + 50, Image.SCALE_SMOOTH));
                lbl.setIcon(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lbl;
        }
    }

}
