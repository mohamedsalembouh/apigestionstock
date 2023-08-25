package com.salem.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends abstractEntity{
    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "prixunitaire")
    private BigDecimal prixunitaire;
    @Column(name = "identreprise")
    private int identreprise;
}
