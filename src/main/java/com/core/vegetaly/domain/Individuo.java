package com.core.vegetaly.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "indioviduo")
public class Individuo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Basic
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Basic
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Basic
    @Column(name = "phone")
    private String phone;

    @NotEmpty
    @Email
    @Basic
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Basic
    @Column(name = "age")
    private String age;

}
