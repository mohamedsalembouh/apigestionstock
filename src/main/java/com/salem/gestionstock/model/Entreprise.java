package com.salem.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enterprise")
public class Entreprise extends abstractEntity{
    @Column
    private String name;
    @Column
    private String description;
    @Embedded
    private Adresse adresse;
    @Column
    private String codeFiscal;
    @Column
    private String photo;
    @Column
    private String email;
    @Column
    private String numTel;
    @Column
    private String steweb;
    @OneToMany(mappedBy = "enterprise")
    private List<Utilisateur> utilisateurs;
}
