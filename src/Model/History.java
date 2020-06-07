package src.Model;
import java.sql.*;
import java.time.*;
public class History {
    private int Level;
    private String Topic;
    private LocalDateTime date;
    private int Score;
    public History() {
    }
    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
    

    public History(int Level, String Topic, int Score, LocalDateTime date) {
        this.Level = Level;
        this.Topic = Topic;
        this.date = date;
        this.Score = Score;
    }
    
}