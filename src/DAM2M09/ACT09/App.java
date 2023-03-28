package DAM2M09.ACT09;


import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inici: " + LocalTime.now());

        Agenda agenda = new Agenda();
        for (int i = 0; i < 10; i++) {
            Tarea tasca = new Tarea(LocalTime.now().plusSeconds(10 + i * 5), "Tasca (" + i + ")");
            agenda.afegeixTasca(tasca);
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!agenda.getSortir()) {
                    agenda.run();
                } else {
                    timer.cancel();
                    System.out.println("Completat");
                }
            }
        };

        timer.schedule(task, 2000, 2000);
        Thread.sleep(20000);
        agenda.setSortir(true);
    }
}