package ru.kogtev.datasportteam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
public class Team {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "team_name")
    @NotNull
    @Size(min = 2, max = 50, message = "Название команды не должно пустым")
    private String teamName;

    @Column(name = "sport_type")
    @NotNull
    @Size(min = 2, max = 50, message = "Наименование дисциплины не должно быть пустым")
    private String sportType;

    @Column(name = "found_date")
    @NotNull
    @Range(min = 1000, max = 2024, message = "Год основания должен быть записан по форме 'YYYY' от 1000 до 2024 гг. ")
    private int foundDate;

    @OneToMany(mappedBy = "teamOwner")
    private List<Player> players;

    public Team(String teamName, String sportType, int foundDate) {
        this.teamName = teamName;
        this.sportType = sportType;
        this.foundDate = foundDate;
    }
}
