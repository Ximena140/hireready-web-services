package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;
    @ManyToOne
    @JoinColumn(name = "result_id")
    private SimResult simResult;
    @Column(columnDefinition = "TEXT")
    private String frequentErrors;
    @Column(columnDefinition = "TEXT")
    private String recommendation;

    public Integer getFeedbackId() {
        return feedbackId;
    }


    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public SimResult getSimResult() {
        return simResult;
    }

    public void setSimResult(SimResult simResult) {
        this.simResult = simResult;
    }

    public String getFrequentErrors() {
        return frequentErrors;
    }

    public void setFrequentErrors(String frequentErrors) {
        this.frequentErrors = frequentErrors;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
