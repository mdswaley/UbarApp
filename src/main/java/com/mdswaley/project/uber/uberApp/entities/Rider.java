package com.mdswaley.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne  // one user can assign with one rider and vic versa so that no other rider can allocate for that user.
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;
}
