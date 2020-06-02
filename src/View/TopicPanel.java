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
    LevelModel lm;
    private JPanel[] topic;
    private JLabel[] information;
    private JLabel[] title;
    private JLabel[] transcript;
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
        backLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\ListeningAppOfficial\\Image\\back.png")); // NOI18N
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
            title[i].setFont(new Font("Arial", 0, 18));
            title[i].setText(lm.getAllExerciseByLevel(level).get(i).getTitle());
            title[i].setPreferredSize(new Dimension(600, 60));

            information[i] = new JLabel();
            information[i].setFont(new Font("Arial", 0, 14));
            information[i].setText("Level: "+lm.getLevel()+  "   Time: "+ lm.getAllExerciseByLevel(level).get(i).getTime() +"     HighScore: " + lm.getAllExerciseByLevel(level).get(i).getHighScore());
            information[i].setPreferredSize(new Dimension(600, 60));

            transcript[i] = new JLabel();
            transcript[i].setFont(new Font("Arial", 0, 14));
            transcript[i].setText(lm.getAllExerciseByLevel(level).get(i).getDescription());
            transcript[i].setPreferredSize(new Dimension(600, 60));
            }

            for(int i=0 ; i<3 ;i++){
            topic[i] = new JPanel();
            topic[i].setPreferredSize(new Dimension(600, 200));
            topic[i].setLayout(new BoxLayout(topic[i], BoxLayout.PAGE_AXIS));
            topic[i].add(title[i]);
            topic[i].add(information[i]);
            topic[i].add(transcript[i]);
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


}
     