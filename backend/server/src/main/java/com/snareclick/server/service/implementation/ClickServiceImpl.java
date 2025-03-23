package com.snareclick.server.service.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.snareclick.server.dto.ClickDTO;
import com.snareclick.server.exception.LinkNotFoundException;
import com.snareclick.server.model.Click;
import com.snareclick.server.repository.ClickRepository;
import com.snareclick.server.repository.LinkRepository;
import com.snareclick.server.service.ClickService;

import reactor.core.publisher.Mono;

@Service
public class ClickServiceImpl implements ClickService {

    private final WebClient webClient;

    private final LinkRepository linkRepository;

    private final ClickRepository clickRepository;

    public ClickServiceImpl(ClickRepository clickRepository, LinkRepository linkRepository,
            WebClient webClient) {
        this.clickRepository = clickRepository;
        this.linkRepository = linkRepository;
        this.webClient = webClient;
    }

    @Override
    public ClickDTO recordClick(String link_id, String ipAddress, String userAgent) {
        return linkRepository.findById(link_id)
                .map(link -> {
                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss Z");
                    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String location = getLocationFromIP(ipAddress).block();

                    Click click = new Click();
                    click.setLink(link);
                    click.setIpAddress(ipAddress);
                    click.setUserAgent(userAgent);
                    click.setLocation(location);
                    click.setCreatedAt(dateFormat.format(new Date()));
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

    private Mono<String> getLocationFromIP(String ip) {
        String apiUrl = "http://ip-api.com/json/" + ip;

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> response.get("status").equals("success")
                        ? response.get("city") + ", " + response.get("region") + ", " + response.get("country")
                        : "Unknown Location")
                .defaultIfEmpty("Unknown Location");
    }

}
