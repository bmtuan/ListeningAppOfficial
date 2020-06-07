package src.View;

import javax.swing.*;

public class HelpPanel extends View {
    private JLabel backLabel;
    private JTextArea helpTextArea;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public HelpPanel() {
        jPanel1 = new JPanel();
        backLabel = new JLabel();
        jLabel3 = new JLabel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        helpTextArea = new JTextArea();
        helpTextArea.setColumns(20);
        helpTextArea.setFont(new java.awt.Font("Arial", 0, 19));
        helpTextArea.setRows(5);
        helpTextArea.setFocusable(false);
        jScrollPane1.setViewportView(helpTextArea);
        helpTextArea.setText("\t   Ứng dụng luyện nghe Tiếng Anh \n");
        helpTextArea.append("Hệ thống có 3 cấp độ nghe: 01, 02, 03:\n");
        helpTextArea.append(" *Level 01: \n");
        helpTextArea.append("       - Gợi ý cho người dùng khi phải nhập tên riêng, địa danh.\n");
        helpTextArea.append(" *Level 02: \n");
        helpTextArea.append("       - Người dùng phải nhập tên riêng mà không có gợi ý.\n");
        helpTextArea.append("       - Thời lượng của phần nghe ít hơn hoặc bằng 15 giây.\n");
        helpTextArea.append(" *Level 03: \n");
        helpTextArea.append("       - Người dùng phải nhập tên riêng mà không có gợi ý.\n");
        helpTextArea.append("       - Thời lượng của phần nghe dài hơn 20 giây.\n");
        helpTextArea.append(
                "     Khi người nghe  chọn được bài nghe. Chương trình sẽ phát lần lượt từng phần nghe một cho người nghe. Người nghe sau khi hoàn thành phần nghe thứ N thì mới được nghe tiếp phần nghe thứ (N+1).\n"
                        + "     Khi phát phần nghe thứ N, người dùng phải nhập lần lượt từng từ một của phần nghe. Chương trình sẽ kiểm tra xem với phím mà người dùng vừa nhấn, có phải sẽ tạo thành một từ hợp lệ hay không? Nếu đúng thì sẽ xóa từ đó đi và cho phép người dùng nhập từ mới."
                        + " Nếu không thì chương trình sẽ xóa đi chữ cái mà người dùng vừa nhấn.\n");
        helpTextArea.append(
                "     Chương trình sẽ chỉ tính điểm theo công thức sau: 10* (11 – x/y). Trong đó x là tổng thời gian người dùng từ lúc bắt đầu nghe đến lúc kết thúc. Còn y là tổng thời lượng của bài nghe.");
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 600));

        backLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backLabel
                .setIcon(new javax.swing.ImageIcon("Image\\back.png")); // NOI18N
        backLabel.setText("Trở về");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hướng dẫn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(backLabel,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)));

        helpTextArea.setBackground(new java.awt.Color(153, 204, 255));
        helpTextArea.setColumns(20);
        helpTextArea.setRows(5);
        jScrollPane1.setViewportView(helpTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0).addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE));
    }


    public JLabel getBackLabel() {
            return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
            this.backLabel = backLabel;
    }
}