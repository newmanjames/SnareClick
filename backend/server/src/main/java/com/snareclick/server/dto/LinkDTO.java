package com.snareclick.server.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.snareclick.server.model.Link;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String id;
    private String originalLink;
    private String createdLink;
    private List<ClickDTO> clicks;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.originalLink = link.getOriginalLink();
        this.createdLink = link.getCreatedLink();
        this.clicks = link.getClicks().stream().map(click -> new ClickDTO(click)).collect(Collectors.toList());
    }
}
