package com.snareclick.server.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snareclick.server.dto.LinkDTO;
import com.snareclick.server.service.LinkService;

@RestController
@RequestMapping(path = "/api/track")
public class TrackController {

    private LinkService linkService;

    public TrackController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id:^[0-9a-zA-Z_-]{8}$}")
    public ResponseEntity<LinkDTO> getMethodName(@PathVariable String id) {
        return linkService.findByID(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
