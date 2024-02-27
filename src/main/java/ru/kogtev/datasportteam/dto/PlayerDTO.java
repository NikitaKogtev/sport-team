package ru.kogtev.datasportteam.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
    @Range(min = 1950, max = 2020, message = "Дата рождения игрока должна быть заполнена по форме 'YYYY' от 1950 до 2020 гг. ")
    private int birthDate;

    @NotNull
    private String role;
}
