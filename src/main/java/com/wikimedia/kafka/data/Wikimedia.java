package com.wikimedia.kafka.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wikimedia_recentchange")
@Data
public class Wikimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String wikiEventData;
}
