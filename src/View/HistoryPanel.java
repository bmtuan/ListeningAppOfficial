package src.View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import src.Model.*;
import src.Controller.*;
public class HistoryPanel extends View implements MouseListener {
    private javax.swing.JLabel backLabel;
    private javax.swing.JTable historyTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;

    public HistoryPanel() {
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        backLabel = new JLabel();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jPanel4 = new JPanel();
        jScrollPane1 = new JScrollPane();
        historyTable = new JTable();
        backLabel.addMouseListener(this);
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        historyTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Level");
        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Score");
        defaultTableModel.addColumn("Date");
        if (historyTable.getColumnModel().getColumnCount() > 0) {
            historyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            historyTable.getColumnModel().getColumn(1).setPreferredWidth(500);
            historyTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            historyTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        }
        historyTable.setBackground(new java.awt.Color(204, 204, 255));
        HistoryModel historyModel = new HistoryModel();
        String pattern = "HH:mm EEEEE MMMMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (History x : historyModel.getListHistory()) {
            Date out = Date.from(x.getDate().atZone(ZoneId.systemDefault()).toInstant());
            String date = simpleDateFormat.format(out);
            defaultTableModel.addRow(new Object[] { x.getLevel(), x.getTopic(), x.getScore(), date });
        }
        for (int i = 0; i < historyTable.getColumnModel().getColumnCount(); i++) {
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            historyTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        defaultTableModel.isCellEditable(defaultTableModel.getRowCount(), defaultTableModel.getColumnCount());
        historyTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));

        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        backLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backLabel
                .setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\back.png")); // NOI18N
        backLabel.setText("Trở về");
        backLabel.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lịch sử");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addComponent(backLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setViewportView(historyTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0).addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        MenuController menuController = new MenuController(new MenuPanel());
        MainFrame.getInstance().add(menuController.getView());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.BLUE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel x = (JLabel) e.getSource();
        x.setForeground(Color.black);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}