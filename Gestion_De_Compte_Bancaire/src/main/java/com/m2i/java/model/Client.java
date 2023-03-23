package com.m2i.java.model;

import com.m2i.java.ENUM.ROLE;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Client extends UserAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;

    @Column(unique = true,nullable=false,updatable=false)
    private String numClient;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn( name="idBanquier" )
    private Banquier banquier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUserDetailsClient")
    private UserDetailsClient userDetailsClient;

    private Boolean isArchived;

    public Client() {
        super();
    }

    @Builder
    public Client(Long id, String numClient, String login , String password, ROLE role,UserDetailsClient userDetailsClient, Banquier banquier,Boolean isArchived) {
        super(login, password, role);
        this.id = id;
        this.numClient = numClient;
        this.userDetailsClient = userDetailsClient;
        this.banquier = banquier;
        this.isArchived = false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", numClient='").append(numClient).append('\'');
        sb.append(", banquier=").append(banquier);
        sb.append(", userDetailsClient=").append(userDetailsClient);
        sb.append('}');
        return sb.toString();
    }
}