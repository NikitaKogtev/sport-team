package ru.kogtev.datasportteam.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
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
    @Size(min = 1950, max = 2020, message = "Дата рождения игрока должна быть заполнена по форме 'YYYY' от 1950 до 2020 гг. ")
    private int birthDate;

    @Column(name = "role")
    @NotNull
    private String role;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamOwner;


    public Player() {
    }

    public Player(String firstName, String secondName, String thirdName, int birthDate, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthDate = birthDate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeamOwner() {
        return teamOwner;
    }

    public void setTeamOwner(Team teamOwner) {
        this.teamOwner = teamOwner;
    }
}
