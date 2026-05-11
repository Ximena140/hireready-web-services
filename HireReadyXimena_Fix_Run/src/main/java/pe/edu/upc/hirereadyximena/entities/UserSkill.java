package pe.edu.upc.hirereadyximena.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_skills")
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSkillId;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    private String skillName;

    @Column(columnDefinition = "TEXT")
    private String skillDescription;
    private String skillType;

    public Integer getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(Integer userSkillId) {
        this.userSkillId = userSkillId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
