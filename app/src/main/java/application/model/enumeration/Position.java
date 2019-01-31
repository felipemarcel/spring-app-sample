package application.model.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@JsonFormat(shape = OBJECT)
public enum Position {

    GOALKEEPER("GK"),
    RIGHT_BACK("RB"),
    CENTRE_BACK("CB"),
    LEFT_BACK("LB"),
    RIGHT_WING_BACK("RWB"),
    LEFT_WING_BACK("LWB"),
    CENTRE_DEFENSIVE_MID_FIELDER("CDMF"),
    CENTRE_MID_FIELDER("CMF"),
    CENTRE_ATTACKING_MID_FIELDER("CAMF"),
    RIGHT_MID_FIELDER("RMF"),
    LEFT_MID_FIELDER("LMF"),
    RIGHT_WINGER("RW"),
    LEFT_WINGER("LW"),
    CENTRE_FORWARD("CF"),
    RIGHT_FORWARD("RF"),
    LEFT_FORWARD("LF"),
    STRIKER("S");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Position(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Position{" +
                "value='" + value + '\'' +
                '}';
    }
}
