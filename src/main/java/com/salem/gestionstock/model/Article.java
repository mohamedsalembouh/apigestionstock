package com.salem.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article extends abstractEntity{
    @Column
    private String codeArticle;
    @Column
    private String designation;
    @Column
    private BigDecimal prixUnitaireHt;
    @Column
    private BigDecimal tauxtva;
    @Column
    private BigDecimal prixUnitaireTtc;
    @Column
    private String photo;
    @Column(name = "identreprise")
    private int identreprise;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;
    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;
}
