package com.snareclick.server.service;

import java.util.Optional;
import java.util.UUID;

import com.snareclick.server.model.Link;

public interface LinkService {
    Link createLink(String redirectURL);

    Link createLink(Link link);

    Optional<Link> findByID(UUID id);

}
