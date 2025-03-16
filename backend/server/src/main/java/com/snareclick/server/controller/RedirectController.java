package com.snareclick.server.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snareclick.server.service.ClickService;
import com.snareclick.server.service.LinkService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
public class RedirectController {

    private LinkService linkService;

    private ClickService clickService;

    public RedirectController(LinkService linkService, ClickService clickService) {
        this.linkService = linkService;
        this.clickService = clickService;
    }

    @GetMapping("/{link_id:^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$}")
    public ResponseEntity<Object> redirect(HttpServletRequest request, @PathVariable UUID link_id) {

        System.out.println(link_id);

        String userAgent = request.getHeader("user-agent");
        String ipAddress = request.getRemoteAddr();

        return linkService.findByID(link_id)
                .map(link -> {
                    System.out.println(link);
                    clickService.recordClick(link_id, ipAddress, userAgent);
                    return ResponseEntity
                            .status(HttpStatus.FOUND)
                            .location(URI.create(link.getRedirectURL()))
                            .build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
