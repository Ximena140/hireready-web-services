package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "simulations")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer simulationId;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private Users user;
    private String mode;
    private Integer durationMins;
    private String difficulty;
    private String simLanguage;
    private String status;
    private Boolean coachActive = false;
    private LocalDate simulationDate;

    public Integer getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(Integer durationMins) {
        this.durationMins = durationMins;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSimLanguage() {
        return simLanguage;
    }

    public void setSimLanguage(String simLanguage) {
        this.simLanguage = simLanguage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCoachActive() {
        return coachActive;
    }

    public void setCoachActive(Boolean coachActive) {
        this.coachActive = coachActive;
    }

    public LocalDate getSimulationDate() {
        return simulationDate;
    }

    public void setSimulationDate(LocalDate simulationDate) {
        this.simulationDate = simulationDate;
    }
}
