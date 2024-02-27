package ru.kogtev.datasportteam.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
public class Player {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 50, message = "Имя игрока не должно быть пустым")
    private String firstName;

    @Column(name = "second_name")
    @NotNull
    @Size(min = 2, max = 50, message = "Фамилия игрока не должно быть пустым")
    private String secondName;

    @Column(name = "third_name")
    @NotNull
    @Size(min = 2, max = 50, message = "Отчество игрока не должно быть пустым")
    private String thirdName;

    @Column(name = "birth_date")
    @NotNull
    @Range(min = 1950, max = 2020, message = "Дата рождения игрока должна быть заполнена по форме 'YYYY' от 1950 до 2020 гг. ")
    private int birthDate;

    @Column(name = "role")
    @NotNull
    private String role;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamOwner;

    public Player(String firstName, String secondName, String thirdName, int birthDate, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthDate = birthDate;
        this.role = role;
    }
}
