package ru.kogtev.datasportteam.dto;

import ru.kogtev.datasportteam.models.Player;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TeamDTO {

    @NotNull
    @Size(min = 2, max = 50, message = "Название команды не должно пустым")
    private String teamName;


    @NotNull
    @Size(min = 2, max = 50, message = "Наименование дисциплины не должно быть пустым")
    private String sportType;

    @NotNull
    @Size(min = 1000, max = 2024, message = "Год основания должен быть записан по форме 'YYYY' от 1000 до 2024 гг. ")
    private int foundDate;

    @OneToMany(mappedBy = "teamOwner")
    private List<Player> players;

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
