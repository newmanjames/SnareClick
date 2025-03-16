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
    private String redirectURL;
    private List<ClickDTO> clicks;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.redirectURL = link.getRedirectURL();
        this.clicks = link.getClicks().stream().map(click -> new ClickDTO(click)).collect(Collectors.toList());
    }
}
