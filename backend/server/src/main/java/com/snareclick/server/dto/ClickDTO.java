package com.snareclick.server.dto;

import java.util.Date;

import com.snareclick.server.model.Click;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClickDTO {

    private Date createdAt;
    private String ipAddress;
    private String location;
    private String userAgent;

    public ClickDTO(Click click) {
        this.createdAt = click.getCreatedAt();
        this.ipAddress = click.getIpAddress();
        this.location = click.getLocation();
        this.userAgent = click.getUserAgent();
    }
}
