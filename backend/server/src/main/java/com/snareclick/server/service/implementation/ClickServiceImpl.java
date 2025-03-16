package com.snareclick.server.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.snareclick.server.dto.ClickDTO;
import com.snareclick.server.exception.LinkNotFoundException;
import com.snareclick.server.model.Click;
import com.snareclick.server.repository.ClickRepository;
import com.snareclick.server.repository.LinkRepository;
import com.snareclick.server.service.ClickService;

@Service
public class ClickServiceImpl implements ClickService {

    private final LinkRepository linkRepository;

    private final ClickRepository clickRepository;

    public ClickServiceImpl(ClickRepository clickRepository, LinkRepository linkRepository) {
        this.clickRepository = clickRepository;
        this.linkRepository = linkRepository;
    }

    @Override
    public ClickDTO recordClick(String link_id, String ipAddress, String userAgent) {
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
                    click = clickRepository.save(click);

                    return new ClickDTO(click);
                })
                .orElseThrow(() -> new LinkNotFoundException(link_id));
    }

    @Override
    public List<ClickDTO> getClicksbyLinkId(String link_id) {
        return linkRepository.findById(link_id)
                .map(link -> clickRepository.findByLink(link).stream()
                        .map(click -> new ClickDTO(click))
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new LinkNotFoundException(link_id));

    }

}
