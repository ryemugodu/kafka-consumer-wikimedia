package com.wikimedia.kafka.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepositroy extends JpaRepository<Wikimedia, Long> {
}
