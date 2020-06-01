
package src.View;
import javax.swing.*;
// import org.netbeans.lib.awtextra;
public class MenuPanel extends View {
    JPanel jPanel2,jPanel3,jPanel4,jPanel5,jPanel6,jPanel7;
    JLabel startLabel1,startLabel2,historyLabel2,historyLabel1,jLabel5,jLabel6,helpLabel1,helpLabel2,exitLabel1,exitLabel2,jLabel11;
    /**
     * Creates new form MenuPanel
     */
    public MenuPanel(){
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        startLabel1 = new JLabel();
        startLabel2 = new JLabel();
        jPanel4 = new  JPanel();
        historyLabel2 =  new JLabel();
        historyLabel1 =  new JLabel();
        jPanel5 = new JPanel();
        jLabel5 = new  JLabel();
        jLabel6 = new  JLabel();
        jPanel6 = new  JPanel();
        helpLabel1 = new  JLabel();
        helpLabel2 = new JLabel();
        jPanel7 = new JPanel();
        exitLabel1 = new JLabel();
        exitLabel2 = new JLabel();
        jLabel11 = new JLabel();
        setBackground(new java.awt.Color(102, 102, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));

        startLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\start.png")); // NOI18N
        startLabel1.setDoubleBuffered(true);
        startLabel1.setName(""); // NOI18N

        startLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startLabel2.setText("Bắt đầu");
        startLabel2.setToolTipText("");
        startLabel2.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(startLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(startLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startLabel1)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 137, 410, -1));

        jPanel4.setBackground(new java.awt.Color(51, 204, 255));

        historyLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        historyLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historyLabel2.setText("Lịch sử");
        historyLabel2.setDoubleBuffered(true);

        historyLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\history.png")); // NOI18N
        historyLabel1.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(historyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(historyLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 410, 90));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lịch sử");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\history.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 410, 80));

        jPanel6.setBackground(new java.awt.Color(51, 204, 255));

        helpLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\hint.png")); // NOI18N
        helpLabel1.setDoubleBuffered(true);

        helpLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        helpLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpLabel2.setText("Hướng dẫn");
        helpLabel2.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(helpLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addComponent(helpLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 410, 80));

        jPanel7.setBackground(new java.awt.Color(51, 204, 255));

        exitLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\exit.png")); // NOI18N
        exitLabel1.setDoubleBuffered(true);

        exitLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel2.setText("Thoát");
        exitLabel2.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(exitLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(exitLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 410, 80));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Listening Pro");
        jLabel11.setToolTipText("");
        jLabel11.setDoubleBuffered(true);
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 240, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }

public JLabel getStartLabel2() {
    return startLabel2;
}

public void setStartLabel2(JLabel startLabel2) {
    this.startLabel2 = startLabel2;
}

public JLabel getHistoryLabel2() {
    return historyLabel2;
}

public void setHistoryLabel2(JLabel historyLabel2) {
    this.historyLabel2 = historyLabel2;
}

public JLabel getHelpLabel2() {
    return helpLabel2;
}

public void setHelpLabel2(JLabel helpLabel2) {
    this.helpLabel2 = helpLabel2;
}

public JLabel getExitLabel2() {
    return exitLabel2;
}

public void setExitLabel2(JLabel exitLabel2) {
    this.exitLabel2 = exitLabel2;
}
}
