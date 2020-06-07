package src.View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class LessonPanel extends JPanel{
    private JTextField text;
    private JTextPane ans;

    private JProgressBar progressBar;
    private JLabel currentTime;
    private JLabel trackLen;
    private JPanel nextPanel;
    private XYSeriesCollection dataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private JLabel bNext;
    private JLabel bListen;
    private JLabel bPlay;
    JLabel hint;
    private JComboBox trackBox;
    Box boxContainer;
    private JLabel bBack;
    public LessonPanel(){
        initComponents();
    }
    private void initComponents(){
        
        

        // panel for back button
        JPanel buttonPanel = new JPanel();
        bBack = new JLabel("Trở về");
        bBack.setFont(new java.awt.Font("Tahoma", 0, 18));
        bBack.setIcon(new ImageIcon("Image/back.png", "back button"));
        
        boxContainer = Box.createHorizontalBox();
        boxContainer.add(bBack);
        boxContainer.setPreferredSize(new Dimension(850, 50));
        buttonPanel.add(boxContainer);
        buttonPanel.setPreferredSize(new Dimension(850, 100));
        //buttonPanel.setBackground(new Color(240,248,255));
        buttonPanel.setBackground(new Color(204, 204, 255));
        // chart panel
        dataset = createDataset(0, null);
        chart = createChart(dataset, 1);
        chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(240,248,255)));
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);
        //chartPanel.setBackground(new Color(245,255,250));
        
        // panel for user typing
        JPanel textPanel = new JPanel();
        text = new JTextField();
        text.setPreferredSize(new Dimension(700, 30));
        text.setTransferHandler(null);
        text.setBackground(new Color(255,250,250));
        textPanel.add(text);
        hint = new JLabel();
        textPanel.add(hint);
        //textPanel.setBackground(new Color(240,248,255));
        textPanel.setBackground(new Color(204, 204, 255));
        // panel containing answerPanel and nextPanel 
        JPanel audioPanel = new JPanel();
        audioPanel.setPreferredSize(new Dimension(600, 300));
        audioPanel.setLayout(new BoxLayout(audioPanel, BoxLayout.Y_AXIS));

        ans = new JTextPane();
        ans.setEditable(false);        
        ans.setPreferredSize(new Dimension(600, 30));
        ans.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        //ans.setBackground(new Color(240,248,255));
        ans.setBackground(new Color(204, 204, 255));
        // Containing next and listen button
        nextPanel = new JPanel();
        bNext = new JLabel("Track tiếp theo");
        bNext.setFont(new java.awt.Font("Tahoma", 0, 18));
        bNext.setIcon(new ImageIcon("Image/fast_forward_25px.png", "next"));
        bListen = new JLabel("Nghe lại");
        bListen.setFont(new java.awt.Font("Tahoma", 0, 18));
        bListen.setIcon(new ImageIcon("Image/audio_25px.png", "listen"));


    
        nextPanel.add(bNext);
        // adding space between two labels
        for (int i = 0; i < 20; ++i)
            nextPanel.add(new JLabel());
        //
        nextPanel.add(bListen);
        //nextPanel.setBackground(new Color(240,248,255));
        nextPanel.setBackground(new Color(204, 204, 255));
        nextPanel.setVisible(false);

        // Containing text area to show transcript when user types correctly
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        answerPanel.add(ans);
        answerPanel.add(nextPanel);
        audioPanel.add(answerPanel);

        // Panel containing media playing bar and time tracking
        JPanel musicPanel = new JPanel();
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setPreferredSize(new Dimension(700, 5));
        currentTime = new JLabel("00:00");
        trackLen = new JLabel("00:00");
        
        
        bPlay = new JLabel();
        ImageIcon playIcon = new ImageIcon("Image/play_25px.png", "play button");
        bPlay.setIcon(playIcon);
        bPlay.setBackground(Color.white);
        bPlay.setPreferredSize(new Dimension(30, 30));
        //bPlay.addActionListener(lessonController);
        musicPanel.add(bPlay, LEFT_ALIGNMENT);
        musicPanel.add(currentTime);
        musicPanel.add(progressBar);
        musicPanel.add(trackLen);
        //musicPanel.setBackground(new Color(250,250,210));
        musicPanel.setBackground(new Color(176,224,230));
        musicPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(240,248,255)));
        
        
        
        // main panel
        //JPanel mainPanel = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonPanel);
        this.add(chartPanel);
        this.add(musicPanel);
        this.add(audioPanel);
        this.add(textPanel);
        //this.setBackground(Color.white);

    }

    public JLabel getHint() {
        return hint;
    }

    public void setHint(JLabel hint) {
        this.hint = hint;
    }
    
    public Box getBoxContainer() {
        return boxContainer;
    }

    public void setBoxContainer(Box boxContainer) {
        this.boxContainer = boxContainer;
    }
    
    public JComboBox getTrackBox() {
        return trackBox;
    }

    public void setTrackBox(JComboBox trackBox) {
        this.trackBox = trackBox;
    }
    
    public JLabel getbBack() {
        return bBack;
    }
    
    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }


    public JTextPane getAns() {
        return ans;
    }

   public void setAns(JTextPane ans) {
        this.ans = ans;
    }
    


    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public JLabel getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(JLabel currentTime) {
        this.currentTime = currentTime;
    }

    public JLabel getTrackLen() {
        return trackLen;
    }

    public void setTrackLen(JLabel trackLen) {
        this.trackLen = trackLen;
    }

    public XYSeriesCollection getDataset() {
        return dataset;
    }

    public void setDataset(XYSeriesCollection dataset) {
        this.dataset = dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    public void setChartPanel(ChartPanel chartPanel) {
        this.chartPanel = chartPanel;
    }

    public JLabel getbNext() {
        return bNext;
    }

    public void setbNext(JLabel bNext) {
        this.bNext = bNext;
    }

    public JLabel getbListen() {
        return bListen;
    }

    public void setbListen(JLabel bListen) {
        this.bListen = bListen;
    }

    public JLabel getbPlay() {
        return bPlay;
    }

    public void setbPlay(JLabel bPlay) {
        this.bPlay = bPlay;
    }

    public JPanel getNextPanel() {
        return nextPanel;
    }

    public void setNextPanel(JPanel nextPanel) {
        this.nextPanel = nextPanel;
    }

    

    public XYSeriesCollection createDataset(int currentAttempt, int[] points) {
        
        XYSeries series = new XYSeries("Current Attempt");
        for (int i = 0; i < currentAttempt; ++i){
            series.add(i + 1, points[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
//        XYSeries org = dataset.getSeries(0);
//        
//        for (int i = 0; i < org.getItemCount(); ++i)
//            System.out.println(org.getItems().get(i).getClass());
        return dataset;
    }
    public JFreeChart createChart(XYDataset dataset, int currentTrack) {
        String trackNum = Integer.toString(currentTrack);
        //XYSeriesCollection data = (XYSeriesCollection)dataset;
        JFreeChart chart = ChartFactory.createXYLineChart("Track " + trackNum, "Attempts", "Points", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        ValueAxis domainAxis =  plot.getDomainAxis();
        domainAxis.setRange(0, 20);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setRange(0, 100);
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(new Color(250,250,210));
        //plot.setBackgroundPaint(new Color(176,224,230));
        //plot.setRangeGridlinesVisible(true);
       // plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        chart.getLegend().visible = false;
        //chart.getLegend().setFrame(BlockBorder.NONE);
        
        //chart.setTitle(new TextTitle("Average Salary per Age",
        //                new Font("Serif", java.awt.Font.BOLD, 18)
        //        )
        //);
        return chart;
    }
    
    
    
}
