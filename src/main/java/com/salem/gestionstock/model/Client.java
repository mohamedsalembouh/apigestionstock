package com.salem.gestionstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
public class Client extends abstractEntity{
    @Column
    private String nom;
    @Column
    private String prenom;
//    private String adress;
    @Column
    private String photo;
    @Column
    private String mail;
    @Column
    private String numTel;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClient;
}
