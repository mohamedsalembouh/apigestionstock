package com.salem.gestionstock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
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

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
}
