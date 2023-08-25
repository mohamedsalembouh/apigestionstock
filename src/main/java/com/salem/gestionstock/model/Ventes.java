package com.salem.gestionstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "vente")
public class Ventes extends abstractEntity{
    @Column
    private String code;
    @Column(name = "datevente")
    private Instant dateVente;
    @Column
    private String commentaire;
    @Column(name = "identreprise")
    private int identreprise;
    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;
}
