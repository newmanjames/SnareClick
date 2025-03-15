package com.snareclick.server.controller.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snareclick.server.dto.LinkDTO;
import com.snareclick.server.model.Link;
import com.snareclick.server.service.ClickService;
import com.snareclick.server.service.LinkService;

@RestController
@RequestMapping("/api/create")
public class CreateController {

    private final LinkService linkService;

    public CreateController(ClickService clickService, LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkDTO> createLink(@RequestBody Link link) {

        String redirectURL = link.getRedirectURL();

        Link savedLink = linkService.createLink(redirectURL);

        return ResponseEntity.ok(new LinkDTO(savedLink.getId()));

    }

}
