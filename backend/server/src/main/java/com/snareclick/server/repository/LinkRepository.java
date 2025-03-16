package com.snareclick.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snareclick.server.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, String> {
}
