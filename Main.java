public class Main {
    public static void main(String[] args) {
        Runnable playtask1 = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                FilePlayer player = new FilePlayer();
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\do.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\mi.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\sol.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\si.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\do-octave.wav");
            }
        };
        Thread t1 = new Thread(playtask1);
        t1.start();
        Runnable playtask2 = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                FilePlayer player = new FilePlayer();
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\re.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\fa.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\la.wav");
                player.play("C:\\Users\\isabe\\OneDrive\\桌面\\5100\\Bonus\\sound track\\Sounds\\do-octave.wav");
            }
        };
        Thread t2 = new Thread(playtask2);
        t2.start();
    };
}
