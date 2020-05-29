package src.Model;

/**
 *
 * @author DELL 7577
 */
public class Track {
    private String Audio, Transcript;
    private int Time;

    public Track() {
    }

    public String getAudio() {
        return Audio;
    }

    public void setAudio(String audio) {
        Audio = audio;
    }

 

    public String getTranscript() {
        return Transcript;
    }

    public void setTranscript(String transcript) {
        Transcript = transcript;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public Track(String audio, String transcript, int time) {
        Audio = audio;
        Transcript = transcript;
        Time = time;
    }

    @Override
    public String toString() {
        return "Track [Audio=" + Audio + ", Time=" + Time + ", Transcript=" + Transcript + "]";
    }


    
}