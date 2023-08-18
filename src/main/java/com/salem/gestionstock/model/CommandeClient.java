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
@Table(name = "commandeclient")
public class CommandeClient extends abstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "datecomande")
    private Instant dateComande;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    @OneToMany(mappedBy = "comandeclient")
    private List<LigneCommandeClient> ligneCommandeClient;
}
