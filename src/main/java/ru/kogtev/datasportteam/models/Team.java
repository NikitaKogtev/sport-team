package ru.kogtev.datasportteam.models;

import ru.kogtev.datasportteam.util.SportType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Team")
public class Team {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "team_name")
    @NotEmpty
    @Size(min = 2, max = 50, message = "Название команды не должно пустым")
    private String teamName;

    @Column(name = "sport_type")
    @NotEmpty
    @Size(min = 2, max = 50, message = "Наименование дисциплины не должно быть пустым")
    private String sportType;

    @Column(name = "found_date")
    @NotEmpty
    @Size(min = 1000, max = 2024, message = "Год основания должен быть записан по форме 'YYYY' от 1000 до 2024 гг. ")
    private int foundDate;

    @OneToMany(mappedBy = "teamOwner")
    private List<Player> players;

    public Team() {
    }

    public Team(String teamName, String sportType, int foundDate) {
        this.teamName = teamName;
        this.sportType = sportType;
        this.foundDate = foundDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public int getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(int foundDate) {
        this.foundDate = foundDate;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
