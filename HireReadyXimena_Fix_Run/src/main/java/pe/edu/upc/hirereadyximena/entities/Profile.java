package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer profileId;
    @OneToOne

    @JoinColumn(name = "user_id")
    private Users user;
    private String linkedinUrl;
    private String facebookUrl;
    private String career;

    @Column(columnDefinition = "TEXT")
    private String experience;
    private Integer experienceYears;
    private String eduInstitution;
    private String degree;

    public Integer getProfileId() {
        return profileId;
    }
    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public String getLinkedinUrl() {
        return linkedinUrl;
    }
    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getEduInstitution() {
        return eduInstitution;
    }

    public void setEduInstitution(String eduInstitution) {
        this.eduInstitution = eduInstitution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
