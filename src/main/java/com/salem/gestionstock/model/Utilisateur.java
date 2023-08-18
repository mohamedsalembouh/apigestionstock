package com.salem.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends abstractEntity{
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String email;
    @Column
    private Instant dateDeNaissance;
    @Column
    private String motDePasse;
    @Embedded
    private Adresse adresse;
    @Column
    private String photo;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise enterprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;
}
