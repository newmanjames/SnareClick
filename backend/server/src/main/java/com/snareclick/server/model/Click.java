package com.snareclick.server.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clicks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "link_id", nullable = false)
    private Link link;

    private String ipAddress;
    private String location;
    private String userAgent;

}
