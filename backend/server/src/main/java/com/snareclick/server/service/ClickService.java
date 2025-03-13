package com.snareclick.server.service;

import java.util.List;
import java.util.UUID;

import com.snareclick.server.model.Click;

public interface ClickService {
    Click recordClick(UUID link_id, String ipAddress, String userAgent);

    List<Click> getClicksbyLinkId(UUID link_id);

}
