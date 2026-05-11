package pe.edu.upc.hirereadyximena.dtos;

import java.math.BigDecimal;

public class ProgressDTO {
    private Integer simulationId;
    private String mode;
    private String difficulty;
    private BigDecimal overallScore;
    private BigDecimal verbalScore;
    private BigDecimal emotionalScore;
    private BigDecimal technicalScore;

    public ProgressDTO(Integer simulationId, String mode, String difficulty, BigDecimal overallScore, BigDecimal verbalScore, BigDecimal emotionalScore, BigDecimal technicalScore) {
        this.simulationId = simulationId;
        this.mode = mode;
        this.difficulty = difficulty;
        this.overallScore = overallScore;
        this.verbalScore = verbalScore;
        this.emotionalScore = emotionalScore;
        this.technicalScore = technicalScore;
    }

    public Integer getSimulationId() {
        return simulationId;
    }

    public String getMode() {
        return mode;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public BigDecimal getOverallScore() {
        return overallScore;
    }

    public BigDecimal getVerbalScore() {
        return verbalScore;
    }

    public BigDecimal getEmotionalScore() {
        return emotionalScore;
    }

    public BigDecimal getTechnicalScore() {
        return technicalScore;
    }

}
