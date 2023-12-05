/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

public class TwinkleTwinkleLittleStar {

    private FilePlayer player = new FilePlayer();
    private final String notePath = "C:\\NetBeansProjects\\5100Multithreading\\sound track\\Sounds\\";

    public static void main(String[] args) {
        new TwinkleTwinkleLittleStar().playTwinkleTwinkleLittleStar();
    }

    private void playTwinkleTwinkleLittleStar() {
        String[] melody = {
            "do", "do", "sol", "sol", "la", "la", "sol",
            "Rest",
            "fa", "fa", "mi", "mi", "re", "re", "do",
            "Rest",
            "sol", "sol", "fa", "fa", "mi", "mi", "re",
            "Rest",
            "sol", "sol", "fa", "fa", "mi", "mi", "re",
            "Rest",
            "do", "do", "sol", "sol", "la", "la", "sol",
            "Rest",
            "fa", "fa", "mi", "mi", "re", "re", "do",
            "Rest"
        };

        for (String note : melody) {
            if ("Rest".equals(note))
            {
                rest (1000);
            }
            else {
                playNote(note);
                rest(5);
            }
        }
    }

    private void playNote(String noteName) {
        String filename = notePath + noteName + ".wav";
        player.play(filename);
    }

    private void rest(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

