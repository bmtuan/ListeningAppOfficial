
package src.Model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String title;
    private int level;
    private String Description;
    private List<Track> listTrack;
    private int time, highScore;
    public Exercise(){
        listTrack = new ArrayList<Track>();
    }
    public Exercise(int time, int highScore, String title, int level, ArrayList<Track> listTrack) {
        this.time = time;
        this.highScore = highScore;
        this.title = title;
        this.level = level;
        this.listTrack = listTrack;
    }

    public List<Track> getListTrack() {
        return listTrack;
    }

    public void setListTrack(List<Track> listTrack) {
        this.listTrack = listTrack;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highscore) {
        this.highScore = highscore;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }   
}
