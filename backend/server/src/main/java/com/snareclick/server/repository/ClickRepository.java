package com.snareclick.server.repository;

import com.snareclick.server.model.Click;
import com.snareclick.server.model.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {
    List<Click> findByLink(Link link);
}
