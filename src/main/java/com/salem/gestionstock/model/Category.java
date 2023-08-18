package com.salem.gestionstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "category")
public class Category extends abstractEntity{
    @Column
    private String code;
    @Column
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
