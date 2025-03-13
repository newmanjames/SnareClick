package com.snareclick.server.service;

import java.util.Optional;
import java.util.UUID;

import com.snareclick.server.model.Link;

public interface LinkService {
    Link createLink(String redirectURL);

    Optional<Link> findByID(UUID id);

}
