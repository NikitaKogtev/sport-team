package ru.kogtev.datasportteam.dto;

import ru.kogtev.datasportteam.models.Team;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerDTO {

    private int id;

    @NotNull
    @Size(min = 2, max = 50, message = "Имя игрока не должно быть пустым")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50, message = "Фамилия игрока не должно быть пустым")
    private String secondName;

    @NotNull
    @Size(min = 2, max = 50, message = "Отчество игрока не должно быть пустым")
    private String thirdName;

    @NotNull
    @Size(min = 1950, max = 2020, message = "Дата рождения игрока должна быть заполнена по форме 'YYYY' от 1950 до 2020 гг. ")
    private int birthDate;

    @NotNull
    private String role;

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

}
