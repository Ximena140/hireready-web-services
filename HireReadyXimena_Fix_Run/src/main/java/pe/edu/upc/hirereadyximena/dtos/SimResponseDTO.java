package pe.edu.upc.hirereadyximena.dtos;

public class SimResponseDTO {
    private Integer responseId;
    private Integer simulationId;
    private Integer questionId;
    private String responseText;
    private String responseAudioUrl;
    private String responseType;
    private Boolean aiHintUsed;

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public Integer getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseAudioUrl() {
        return responseAudioUrl;
    }

    public void setResponseAudioUrl(String responseAudioUrl) {
        this.responseAudioUrl = responseAudioUrl;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Boolean getAiHintUsed() {
        return aiHintUsed;
    }

    public void setAiHintUsed(Boolean aiHintUsed) {
        this.aiHintUsed = aiHintUsed;
    }
}