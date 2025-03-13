package com.snareclick.server.repository;

import com.snareclick.server.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<Link, UUID> {
}
