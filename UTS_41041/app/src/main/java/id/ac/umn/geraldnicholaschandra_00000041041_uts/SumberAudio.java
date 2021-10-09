package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import android.net.Uri;

import java.io.Serializable;

public class SumberAudio implements Serializable {
    private String judul;
    private String keterangan;
    private String videoURI;
    private int AudioURI;
    public SumberAudio(String judul, String keterangan,
                       int AudioURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.AudioURI = AudioURI;
    }
    public String getJudul() { return this.judul; }
    public String getKeterangan() { return this.keterangan; }
    public String getVideoURI() { return this.videoURI; }
    public void setJudul(String judul){ this.judul = judul; }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public void setVideoURI(String videoURI) {
        this.videoURI = videoURI;
    }
    public String toString() {
        return this.getJudul() + " => "
            + this.getKeterangan();
    }
    public int getAudioURI(){
        return this.AudioURI;
    }
}

