package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Имя не должно быть пустым")
//    @Size(min = 3 , max = 15, message = "Имя пользователя должно содержать больше 2 символов но не больше 15 "  )
//    @Column(name = "username", unique = true)
//    private String username;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 3 , max = 15, message = "Имя должно содержать больше 2 символов но не больше 15 "  )
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 3 , max = 15, message = "Имя должно содержать больше 2 символов но не больше 15 "  )
    @Column(name = "last_name")
    private String last_name;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 0 , max = 255, message = "Имя должно содержать больше 2 символов но не больше 15 "  )
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size( max = 255, message = "Имя должно содержать больше 8 символов но не больше 15 "  )
    @Column(name = "phone_number")
    private String phone_number;

//    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "gender")
    private String gender;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(max = 255, message = "Имя должно содержать больше 2 символов но не больше 15 "  )
    @Column(name = "country")
    private String country;

    @Max(value = 2005, message = "Вы должны быть совершенналетным")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "role")
//    @Enumerated(value = EnumType.STRING)
    private String role;

    private String activationCode;

    private boolean active;

    @Column(name = "password", nullable = false)
    private String password;

// Ժամանակավոր փոփոխական
    private String confirmPassword;


}
