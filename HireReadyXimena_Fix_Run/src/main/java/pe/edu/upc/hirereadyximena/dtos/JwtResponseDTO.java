package pe.edu.upc.hirereadyximena.dtos;

public class JwtResponseDTO {

    private String jwtToken;
    private String role;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}