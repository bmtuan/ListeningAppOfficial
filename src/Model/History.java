
package src.Model;
public class History {
    private int Level;
    private String Topic;
    private String date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public History(int Level, String Topic, int Score, String date) {
        this.Level = Level;
        this.Topic = Topic;
        this.date = date;
        this.Score = Score;
    }

    @Override
    public String toString() {
        return "History [" + "Level =" + Level +", Score = " + Score + ", Topic =" + Topic + ", date =" + date
                + "]";
    }
    
}