package com.example.demo.db.model;

import com.example.demo.db.model.other.Countries;
import com.example.demo.db.model.other.Role;
import com.example.demo.db.model.relationship.Cart;
import com.example.demo.db.model.relationship.Order;
import com.example.demo.db.model.relationship.rating.PersonRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "birthDate")
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private Date birthDate;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String activationCode;

    private boolean active;

    @Column(name = "password", nullable = false)
    private String password;

    private String confirmPassword;

//    @DateTimeFormat(pattern = "yyyy:mm:dd")
    @CreatedDate
    private LocalDate createdDate;

    @OneToMany
    private List<Item> items;


    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    private List<Cart> cartList;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Order> purchases;

    @OneToMany(mappedBy = "seller")
    @ToString.Exclude
    private List<Order> sold;

    @OneToMany(mappedBy = "rater")
    private List<PersonRating> favoritesUser;

    @OneToMany(mappedBy = "rated")
    private List<PersonRating> ratings;

//    @Override
//    public String toString() {
//        return "\n Person" + '\n' +
//                "   id : " + id + '\n' +
//                "   first_name : " + first_name + '\n' +
//                "   last_name : " + last_name + '\n' +
//                "   email : " + email + '\n' +
//                "   phone_number : " + phone_number + '\n' +
//                "   gender : " + gender + '\n' +
//                "   country : " + country + '\n' +
//                "   yearOfBirth : " + birthDate + '\n' +
//                "   role : " + role + '\n' +
//                "   activationCode : " + activationCode + '\n' +
//                "   active : " + active + '\n' +
//                "   password : " + password + '\n';
//    }
}
