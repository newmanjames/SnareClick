package com.snareclick.server.service.implementation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snareclick.server.model.Link;
import com.snareclick.server.repository.LinkRepository;
import com.snareclick.server.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link createLink(String redirectURL) {
        // create new link and set URL
        Link link = new Link();
        link.setRedirectURL(redirectURL);

        // save link to database
        linkRepository.save(link);

        return link;

    }

    @Override
    public Optional<Link> findByID(UUID id) {
        return linkRepository.findById(id);
    }

    @Override
    public Link createLink(Link link) {
        return linkRepository.save(link);
    }

}
