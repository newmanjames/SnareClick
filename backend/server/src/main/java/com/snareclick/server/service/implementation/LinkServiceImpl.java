package com.snareclick.server.service.implementation;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.snareclick.server.dto.LinkDTO;
import com.snareclick.server.model.Link;
import com.snareclick.server.repository.LinkRepository;
import com.snareclick.server.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Value("${app.base-url}")
    private String baseUrl;

    LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;

    }

    @Override
    public LinkDTO createLink(String originalLink) {
        // create new link and set URL
        Link link = new Link();
        String id = generateUniqueId();
        link.setId(id);
        link.setOriginalLink(originalLink);
        link.setCreatedLink(baseUrl + "/" + id);

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
        String id = generateUniqueId();
        link.setId(id);
        link.setCreatedLink(baseUrl + "/" + id);
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
