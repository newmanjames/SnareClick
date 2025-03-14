package com.snareclick.server.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.snareclick.server.model.Click;
import com.snareclick.server.model.Link;
import com.snareclick.server.repository.ClickRepository;
import com.snareclick.server.repository.LinkRepository;
import com.snareclick.server.service.ClickService;
import com.snareclick.server.exception.LinkNotFoundException;

@Service
public class ClickServiceImpl implements ClickService {

    private final LinkRepository linkRepository;

    private final ClickRepository clickRepository;

    public ClickServiceImpl(ClickRepository clickRepository, LinkRepository linkRepository) {
        this.clickRepository = clickRepository;
        this.linkRepository = linkRepository;
    }

    @Override
    public Click recordClick(UUID link_id, String ipAddress, String userAgent) {
        Optional<Link> optionalLink = linkRepository.findById(link_id);

        if (optionalLink.isPresent()) {

            Link link = optionalLink.get();

            // TODO: implement location by IP
            String location = null;

            Click click = new Click();
            click.setLink(link);
            click.setIpAddress(ipAddress);
            click.setLocation(location);
            click.setCreatedAt(new Date());
            clickRepository.save(click);
            return click;

        } else {
            throw new LinkNotFoundException("Link with ID " + link_id + " not found");
        }
    }

    @Override
    public List<Click> getClicksbyLinkId(UUID link_id) {
        Optional<Link> optionalLink = linkRepository.findById(link_id);

        if (optionalLink.isPresent()) {
            // get all clicks from provided link
            return clickRepository.findByLink(optionalLink.get());
        } else {
            throw new LinkNotFoundException("Link with ID " + link_id + " not found");
        }
    }

}
