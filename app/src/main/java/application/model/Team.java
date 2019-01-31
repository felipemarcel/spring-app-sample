package application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private Integer score;

    @NotNull
    private String name;

    @Min(0)
    @NotNull
    private Integer goalsScored;

    @Min(0)
    @NotNull
    private Integer goalsConceded;

    @NotNull
    private String uniformPrimaryColor;

    @NotNull
    private String uniformSecondaryColor;

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = ALL)
    private Set<Player> players;

    @ManyToMany(mappedBy = "teams")
    private Set<League> leagues;

    public Team() {
    }

    public Team(@JsonProperty("name") String name,
                @JsonProperty("uniformSecondaryColor") @NotNull String uniformSecondaryColor,
                @JsonProperty("uniformPrimaryColor") @NotNull String uniformPrimaryColor,
                @JsonProperty("score") @Min(0) @NotNull Integer score,
                @JsonProperty("goalsConceded") @Min(0) @NotNull Integer goalsConceded,
                @JsonProperty("goalsScored") @Min(0) @NotNull Integer goalsScored,
                @JsonProperty("leagues") Set<League> leagues) {
        this.name = name;
        this.uniformSecondaryColor = uniformSecondaryColor;
        this.uniformPrimaryColor = uniformPrimaryColor;
        this.score = score;
        this.goalsConceded = goalsConceded;
        this.goalsScored = goalsScored;
        this.leagues = leagues;
    }

    public Long getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public String getUniformPrimaryColor() {
        return uniformPrimaryColor;
    }

    public String getUniformSecondaryColor() {
        return uniformSecondaryColor;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public void setUniformPrimaryColor(String uniformPrimaryColor) {
        this.uniformPrimaryColor = uniformPrimaryColor;
    }

    public void setUniformSecondaryColor(String uniformSecondaryColor) {
        this.uniformSecondaryColor = uniformSecondaryColor;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, players);
    }
}
