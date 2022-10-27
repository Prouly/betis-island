package Juego;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Ejecutar  {
    
    private static final String RUTA_MUSICA = "intro.wav";
    /**
     * Metodo que ejectua la musica y el juego en si
     */
    public static void jugar() {
        try {
            File musicPath = new File(RUTA_MUSICA);
            
            //Abrir archivo de musica
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            
            //Control de volumen
            FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            controlVolumen.setValue(-10.0f); // Reduce el volumen en X decibelios.
            
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            //Ejecucion del juego
            Juego.main();
            
            clip.stop();
           
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
           
    }
}