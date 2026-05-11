package pe.edu.upc.hirereadyximena.dtos;

public class SimResultDTO {
    private Integer resultId;
    private Integer simulationId;
    private java.math.BigDecimal overallScore;
    private java.math.BigDecimal verbalScore;
    private java.math.BigDecimal emotionalScore;
    private java.math.BigDecimal technicalScore;
    private String aiSummary;

    public Integer getResultId() {
        return resultId; }

    public void setResultId(Integer resultId) {
        this.resultId = resultId; }

    public Integer getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public java.math.BigDecimal getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(java.math.BigDecimal overallScore) {
        this.overallScore = overallScore;
    }

    public java.math.BigDecimal getVerbalScore() {
        return verbalScore;
    }

    public void setVerbalScore(java.math.BigDecimal verbalScore) {
        this.verbalScore = verbalScore;
    }

    public java.math.BigDecimal getEmotionalScore() {
        return emotionalScore;
    }

    public void setEmotionalScore(java.math.BigDecimal emotionalScore) {
        this.emotionalScore = emotionalScore;
    }

    public java.math.BigDecimal getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(java.math.BigDecimal technicalScore) {
        this.technicalScore = technicalScore;
    }

    public String getAiSummary() {
        return aiSummary;
    }

    public void setAiSummary(String aiSummary) {
        this.aiSummary = aiSummary;
    }
}