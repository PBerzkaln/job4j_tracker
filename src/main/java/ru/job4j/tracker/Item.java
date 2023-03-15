package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Entity указывает, что это модель,
 * которую можно сохранить в базу.
 * Table указывает на таблицу.
 */
@Entity
@Table(name = "items")
@Data
public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    /**
     * В модели нужно указать,
     * какое поле является первичным ключом.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}