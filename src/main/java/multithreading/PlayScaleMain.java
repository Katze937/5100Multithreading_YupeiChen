/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package multithreading;

public class PlayScaleMain {

    private final Object lock = new Object();
    private volatile int currentNoteIndex = 0;
    private final String[] notes = {"do.wav", "re.wav", "mi.wav", "fa.wav", "sol.wav", "la.wav", "si.wav", "do-octave.wav"};
    private FilePlayer player = new FilePlayer();

    public static void main(String[] args) {
        new PlayScaleMain().playScale();
    }

    public void playScale() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (currentNoteIndex < notes.length) {
                        if (currentNoteIndex % 2 == 0) {  // t1 plays even indexed notes
                            playNote(notes[currentNoteIndex]);
                            currentNoteIndex++;
                        }
                        lock.notify();
                        if (currentNoteIndex < notes.length) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (currentNoteIndex < notes.length) {
                        if (currentNoteIndex % 2 != 0) {  // t2 plays odd indexed notes
                            playNote(notes[currentNoteIndex]);
                            currentNoteIndex++;
                        }
                        lock.notify();
                        if (currentNoteIndex < notes.length) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    private void playNote(String note) {
        player.play("C:\\NetBeansProjects\\5100Multithreading\\sound track\\Sounds\\" + note);
    }
}
