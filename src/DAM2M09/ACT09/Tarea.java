package DAM2M09.ACT09;


import java.time.LocalTime;
class Tarea {
    private LocalTime horaExecucio;
    private String nom;

    public Tarea(LocalTime horaExecucio, String nom) {
        this.horaExecucio = horaExecucio;
        this.nom = nom;
    }

    public LocalTime getHoraExecucio() {
        return horaExecucio;
    }

    public void setHoraExecucio(LocalTime horaExecucio) {
        this.horaExecucio = horaExecucio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
