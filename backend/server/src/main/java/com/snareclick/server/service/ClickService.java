package com.snareclick.server.service;

import java.util.List;

import com.snareclick.server.model.Click;

public interface ClickService {
    Click recordClick(String trackingCode, String ipAddress, String userAgent);

    List<Click> getClicksbyTrackingCode(String trackingCode);

}
