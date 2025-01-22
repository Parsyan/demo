package com.example.demo.model;

import com.example.demo.model.other.Countries;
import com.example.demo.model.other.Role;
import com.example.demo.model.relationship.Basket;
import com.example.demo.model.relationship.BoughtItem;
import com.example.demo.model.relationship.ShopUserRegistration;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

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
    @Size(max = 255, message = "Имя должно содержать больше 2 символов но не больше 15 "  )
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

//    @NotEmpty(message = "Имя не должно быть пустым")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "country")
    private Countries country;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private Date birthday;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String activationCode;

    private boolean active;

    @Column(name = "password", nullable = false)
    private String password;

// Ժամանակավոր փոփոխական
    private String confirmPassword;

    @OneToMany
    private List<Item> items;

    @OneToMany(mappedBy = "person")
    private List<ShopUserRegistration> shopUserRegistrationList;

    @OneToMany(mappedBy = "person")
    private List<Basket> basketList;

    @OneToMany(mappedBy = "person")
    private List<BoughtItem> boughtItemList;

    @Override
    public String toString() {
        return "\n Person" + '\n' +
                "   id : " + id + '\n' +
                "   first_name : " + first_name + '\n' +
                "   last_name : " + last_name + '\n' +
                "   email : " + email + '\n' +
                "   phone_number : " + phone_number + '\n' +
                "   gender : " + gender + '\n' +
                "   country : " + country + '\n' +
                "   yearOfBirth : " + birthday + '\n' +
                "   role : " + role + '\n' +
                "   activationCode : " + activationCode + '\n' +
                "   active : " + active + '\n' +
                "   password : " + password + '\n' +
                "   confirmPassword : " + confirmPassword + '\n';
    }
}
