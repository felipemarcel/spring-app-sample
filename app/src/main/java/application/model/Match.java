package application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


public class Match {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "team_home_id")
//    private Team home;
////
////    @NotNull
////    @ManyToOne
////    @JsonBackReference
////    @JoinColumn(name = "team_guest_id")
////    private Team guest;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "league_id")
//    private League league;

    @NotNull
    private String stadium;

    @NotNull
    private LocalDateTime time;

    public Match() {

    }

    public Match(@JsonProperty("stadium") @NotNull String stadium,
                 @JsonProperty("time") @NotNull LocalDateTime time) {
        this.stadium = stadium;
        this.time = time;
    }

}
