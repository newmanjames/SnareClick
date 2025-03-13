package com.snareclick.server.model;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String redirectURL;

    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL)
    private List<Click> clicks;

}
