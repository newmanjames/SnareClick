package com.snareclick.server.service.implementation;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snareclick.server.dto.LinkDTO;
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
    public LinkDTO createLink(String redirectURL) {
        // create new link and set URL
        Link link = new Link();
        link.setId(generateUniqueId());
        link.setRedirectURL(redirectURL);

        // save link to database
        link = linkRepository.save(link);

        return new LinkDTO(link);

    }

    @Override
    public Optional<LinkDTO> findByID(String id) {
        return linkRepository.findById(id).map(LinkDTO::new);
    }

    @Override
    public LinkDTO createLink(Link link) {
        link.setId(generateUniqueId());
        link = linkRepository.save(link);

        return new LinkDTO(link);
    }

    private String generateUniqueId() {

        String id;
        do {
            UUID uuid = UUID.randomUUID();
            String base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(uuid.toString().getBytes());
            id = base64.substring(0, 8);

        } while (linkRepository.existsById(id));

        return id;
    }

}
