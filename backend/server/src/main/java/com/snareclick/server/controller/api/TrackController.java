package com.snareclick.server.controller.api;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snareclick.server.model.Link;
import com.snareclick.server.service.LinkService;

@RestController
@RequestMapping(path = "/api/track")
public class TrackController {

    private LinkService linkService;

    public TrackController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Link> getMethodName(@PathVariable UUID id) {

        Optional<Link> optionalLink = linkService.findByID(id);

        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            return ResponseEntity.ok(link);
        }
        return ResponseEntity.notFound().build();

    }

}
