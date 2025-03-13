package com.snareclick.server.service;

import java.util.Optional;

import com.snareclick.server.model.Link;

public interface LinkService {
    Link createLink(String redirectURL);

    Optional<Link> findByTrackingCode(String trackingCode);

}
