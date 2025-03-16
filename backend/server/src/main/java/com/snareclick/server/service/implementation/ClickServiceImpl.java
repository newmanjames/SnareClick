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
        return linkRepository.findById(link_id)
                .map(link -> {
                    // TODO: implement location by IP
                    String location = null;

                    Click click = new Click();
                    click.setLink(link);
                    click.setIpAddress(ipAddress);
                    click.setUserAgent(userAgent);
                    click.setLocation(location);
                    click.setCreatedAt(new Date());
                    clickRepository.save(click);
                    return click;
                })
                .orElseThrow(() -> new LinkNotFoundException(link_id));
    }

    @Override
    public List<Click> getClicksbyLinkId(UUID link_id) {
        return linkRepository.findById(link_id)
                .map(link -> clickRepository.findByLink(link))
                .orElseThrow(() -> new LinkNotFoundException(link_id));

    }

}
