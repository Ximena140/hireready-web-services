package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sim_results")
public class SimResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;

    @OneToOne
    @JoinColumn(name = "simulation_id")

    private Simulation simulation;
    private BigDecimal overallScore;
    private BigDecimal verbalScore;
    private BigDecimal emotionalScore;
    private BigDecimal technicalScore;

    @Column(columnDefinition = "TEXT")
    private String aiSummary;
    private LocalDate resultDate;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public BigDecimal getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(BigDecimal overallScore) {
        this.overallScore = overallScore;
    }

    public BigDecimal getVerbalScore() {
        return verbalScore;
    }

    public void setVerbalScore(BigDecimal verbalScore) {
        this.verbalScore = verbalScore;
    }

    public BigDecimal getEmotionalScore() {
        return emotionalScore;
    }

    public void setEmotionalScore(BigDecimal emotionalScore) {
        this.emotionalScore = emotionalScore;
    }

    public BigDecimal getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(BigDecimal technicalScore) {
        this.technicalScore = technicalScore;
    }

    public String getAiSummary() {
        return aiSummary;
    }

    public void setAiSummary(String aiSummary) {
        this.aiSummary = aiSummary;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }
}
