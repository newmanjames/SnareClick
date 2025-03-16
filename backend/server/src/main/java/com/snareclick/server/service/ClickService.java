package com.snareclick.server.service;

import java.util.List;

import com.snareclick.server.dto.ClickDTO;

public interface ClickService {
    ClickDTO recordClick(String link_id, String ipAddress, String userAgent);

    List<ClickDTO> getClicksbyLinkId(String link_id);

}
