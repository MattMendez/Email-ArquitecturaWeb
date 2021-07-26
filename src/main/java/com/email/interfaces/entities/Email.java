package com.email.interfaces.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User sender;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "email")
    private List<User> receivers;

    private String subject;

    private String body;

    private String date;

    private Boolean read;

    private String folder;

    private byte[] file;


}
