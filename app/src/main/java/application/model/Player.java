package application.model;

import application.model.enumeration.Position;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Min(0)
    @Max(100)
    private Float skill;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    private Float height;

    @Min(0)
    private Integer goals;

    @NotNull
    private Integer number;

    @NotNull
    private Locale country;

    @Min(0)
    private Float salary;

    @ElementCollection
    private Set<Position> positions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {

    }

    public Player(@JsonProperty("skill") @Min(0) @Max(100) Float skill,
                  @JsonProperty("name") @NotNull String name,
                  @JsonProperty("age") @NotNull Integer age,
                  @JsonProperty("height") Float height,
                  @JsonProperty("team_id") Team team,
                  @JsonProperty("salary") @Min(0) Float salary,
                  @JsonProperty("goals") @Min(0) Integer goals,
                  @JsonProperty("number") @NotNull Integer number,
                  @JsonProperty("positions") Set<Position> positions,
                  @JsonProperty("country") @NotNull Locale country) {
        this.skill = skill;
        this.salary = salary;
        this.name = name;
        this.team = team;
        this.age = age;
        this.height = height;
        this.goals = goals;
        this.number = number;
        this.positions = positions;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSkill() {
        return skill;
    }

    public void setSkill(Float skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id) &&
                Objects.equals(skill, player.skill) &&
                name.equals(player.name) &&
                Objects.equals(age, player.age) &&
                Objects.equals(height, player.height) &&
                Objects.equals(number, player.number) &&
                Objects.equals(country, player.country) &&
                Objects.equals(salary, player.salary) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, name, age, height, number, country, salary, team);
    }
}
