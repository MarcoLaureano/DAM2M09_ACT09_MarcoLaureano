package DAM2M09.ACT09;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Agenda {
    private List<Tarea> llistaTasques = new ArrayList<>();
    private boolean sortir = false;

    public boolean afegeixTasca(Tarea tasca) {
        if (tasca.getHoraExecucio().isBefore(LocalTime.now())) {
            return false;
        }
        llistaTasques.add(tasca);
        return true;
    }

    public Tarea getProperaTasca() {
        Tarea properaTasca = null;
        for (Tarea tasca : llistaTasques) {
            if (properaTasca == null || tasca.getHoraExecucio().isBefore(properaTasca.getHoraExecucio())) {
                properaTasca = tasca;
            }
        }
        llistaTasques.remove(properaTasca);
        return properaTasca;
    }

    public void run() {
        Tarea properaTasca = getProperaTasca();
        if (properaTasca != null && LocalTime.now().isBefore(properaTasca.getHoraExecucio().plusSeconds(2))) {
            System.out.println(properaTasca.getNom() + " executa");
        }
    }

    public boolean getSortir() {
        return sortir;
    }

    public void setSortir(boolean sortir) {
        this.sortir = sortir;
    }
}