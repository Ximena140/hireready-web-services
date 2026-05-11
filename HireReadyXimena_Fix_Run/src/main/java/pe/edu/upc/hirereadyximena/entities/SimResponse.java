package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sim_responses")
public class SimResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer responseId;

    @ManyToOne
    @JoinColumn(name = "simulation_id")

    private Simulation simulation;

    @ManyToOne
    @JoinColumn(name = "question_id")

    private Question question;

    @Column(columnDefinition = "TEXT")
    private String responseText;
    private String responseAudioUrl;
    private String responseType;
    private Boolean aiHintUsed = false;

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
