package pe.edu.upc.hirereadyximena.dtos;

public class ErrorCountDTO {
    private String frequentErrors;
    private Long total;

    public ErrorCountDTO(String frequentErrors, Long total) {
        this.frequentErrors = frequentErrors;
        this.total = total;
    }

    public String getFrequentErrors() {
        return frequentErrors;
    }

    public Long getTotal() {
        return total;
    }
}
