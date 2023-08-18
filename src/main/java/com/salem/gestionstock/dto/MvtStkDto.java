package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {
    private int id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDto article;
    private TypeMvtStk typeMvt;
}
