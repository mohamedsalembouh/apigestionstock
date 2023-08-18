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
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fournisseur")

public class Fournisseur extends abstractEntity{

    @Column
    private String nom;
    @Column
    private String prenom;
    @Embedded
    private Adresse adress;
    @Column
    private String photo;
    @Column
    private String mail;
    @Column
    private String numTel;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseur;

}
