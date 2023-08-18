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
@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends abstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "datecomande")
    private Instant dateComand;
    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

}
