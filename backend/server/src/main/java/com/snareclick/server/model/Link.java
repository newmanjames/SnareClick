package com.snareclick.server.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String id;

    @URL
    @Column(nullable = false)
    private String originalLink;

    @URL
    @Column(nullable = false)
    private String createdLink;

    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL)
    private List<Click> clicks = new ArrayList<>();

}
