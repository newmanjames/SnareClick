package com.snareclick.server.service;

import java.util.Optional;

import com.snareclick.server.dto.LinkDTO;
import com.snareclick.server.model.Link;

public interface LinkService {

    LinkDTO createLink(String redirectURL);

    LinkDTO createLink(Link link);

    Optional<LinkDTO> findByID(String id);

}
