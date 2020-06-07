package src.View;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import src.Model.LevelModel;

import java.awt.*;

public class TopicPanel extends JPanel{
    private JLabel backLabel;
    private JPanel panelRight;
    private JPanel panelLeft;
    private JLabel chooseTopicLabel;
    private LevelModel lm;
    private JPanel[] topic;
    private JLabel[] information;
    private JLabel[] title;
    private JLabel[] transcript;
    private JPanel[] panel0,panel1, panel2,panel3;
    private JSeparator[] separators;

    public TopicPanel(int level) {
        lm = new LevelModel(level);
        int size = lm.getAllExerciseByLevel(level).size();
        panelLeft = new JPanel();
        panelRight = new JPanel();
        backLabel = new JLabel();
        chooseTopicLabel = new JLabel();
        topic = new JPanel[3];
        title = new JLabel[3];
        panel0 = new JPanel[3];
        panel1 = new JPanel[3];
        panel2 = new JPanel[3];
        panel3 = new JPanel[3];
        information = new JLabel[3];
        transcript = new JLabel[3];
        separators = new JSeparator[2];

        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        panelLeft.setBackground(new Color(153, 153, 255));
        panelLeft.setMaximumSize(new Dimension(200, 600));
        panelLeft.setMinimumSize(new Dimension(200, 600));
        panelLeft.setPreferredSize(new Dimension(200, 600));

        backLabel.setFont(new Font("Arial", 0, 18));
        backLabel.setIcon(new ImageIcon("Image\\back.png")); // NOI18N
        backLabel.setText("Trở về");

        chooseTopicLabel.setFont(new Font("Arial", 0, 24)); // NOI18N
        chooseTopicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chooseTopicLabel.setText("Chọn mức nghe");

        GroupLayout panelLeftLayout = new GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(backLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chooseTopicLabel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240)
                .addComponent(chooseTopicLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 240, Short.MAX_VALUE))
        );
        
        add(panelLeft);
        panelRight.setMaximumSize(new Dimension(600, 600));
        panelRight.setMinimumSize(new Dimension(600, 600));
        panelRight.setPreferredSize(new Dimension(600, 600));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.PAGE_AXIS));

        for(int i=0 ; i<3 ; i++){
            title[i] = new JLabel();
            // title[i].setBackground(new Color(51,204,255));
            title[i].setFont(new Font("Arial", 0, 24));
            title[i].setText(lm.getAllExerciseByLevel(level).get(i).getTitle());
            title[i].setPreferredSize(new Dimension(600, 70));

            information[i] = new JLabel();
            information[i].setFont(new Font("Arial", 0, 18));
            information[i].setBackground(new java.awt.Color(102, 102, 255));
            information[i].setText("Level: "+lm.getLevel()+  "   Time: "+ lm.getAllExerciseByLevel(level).get(i).getTime() +"     HighScore: " + lm.getAllExerciseByLevel(level).get(i).getHighScore());
            information[i].setPreferredSize(new Dimension(600, 70));

            transcript[i] = new JLabel();
            transcript[i].setFont(new Font("Arial", 0, 18));
            transcript[i].setText(lm.getAllExerciseByLevel(level).get(i).getDescription());
            transcript[i].setPreferredSize(new Dimension(600, 60));
            }
        // set back ground
        for(int i=0 ; i<3 ;i++){
        // panel0 này để cách ra khoảng trống ban đầu
            panel0[i] = new JPanel();
            panel0[i].setPreferredSize(new Dimension(600, 0));

            panel1[i] = new JPanel();
            panel1[i].setBackground(new Color(255,204,153));
            panel1[i].setPreferredSize(new Dimension(600, 30));
            panel1[i].add(title[i]);

            panel2[i] = new JPanel();
            panel2[i].setBackground(new Color(255,204,204));
            panel2[i].setPreferredSize(new Dimension(600, 30));
            panel2[i].add(information[i]);

            panel3[i] = new JPanel();
            panel3[i].setBackground(new Color(204,204,255));
            panel3[i].setPreferredSize(new Dimension(600, 40));
            panel3[i].add(transcript[i]);
        }
        
        for(int i=0 ; i<3 ;i++){
        topic[i] = new JPanel();
        topic[i].setPreferredSize(new Dimension(600, 200));
        topic[i].setLayout(new BoxLayout(topic[i], BoxLayout.PAGE_AXIS));
        topic[i].add(panel0[i]);
        topic[i].add(panel1[i]);
        topic[i].add(panel2[i]);
        topic[i].add(panel3[i]);
        }
            
        for(int i=0 ; i<3 ;i++){
            panelRight.add(topic[i]);
            if(i != 2){
                separators[i] = new JSeparator();
                panelRight.add(separators[i]);
            }
        }

        add(panelRight);
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
        this.backLabel = backLabel;
    }

    public JLabel[] getInformation() {
        return information;
    }

    public void setInformation(JLabel[] information) {
        this.information = information;
    }

    public JLabel[] getTitle() {
        return title;
    }

    public void setTitle(JLabel[] title) {
        this.title = title;
    }

    public JLabel[] getTranscript() {
        return transcript;
    }

    public void setTranscript(JLabel[] transcript) {
        this.transcript = transcript;
    }

    public JLabel getChooseTopicLabel() {
        return chooseTopicLabel;
    }

    public void setChooseTopicLabel(JLabel chooseTopicLabel) {
        this.chooseTopicLabel = chooseTopicLabel;
    }

}