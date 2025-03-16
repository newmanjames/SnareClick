package com.snareclick.server.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snareclick.server.service.ClickService;
import com.snareclick.server.service.LinkService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class RedirectController {

    private LinkService linkService;

    private ClickService clickService;

    public RedirectController(LinkService linkService, ClickService clickService) {
        this.linkService = linkService;
        this.clickService = clickService;
    }

    @GetMapping("/{link_id:^[0-9a-zA-Z_-]{8}$}")
    public ResponseEntity<Object> redirect(HttpServletRequest request, @PathVariable String link_id) {

        String userAgent = request.getHeader("user-agent");
        String ipAddress = request.getRemoteAddr();

        return linkService.findByID(link_id)
                .map(link -> {
                    clickService.recordClick(link_id, ipAddress, userAgent);
                    return ResponseEntity
                            .status(HttpStatus.FOUND)
                            .location(URI.create(link.getRedirectURL()))
                            .build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
