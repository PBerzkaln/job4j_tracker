package ru.job4j.tracker;

import lombok.Data;
import ru.job4j.tracker.toone.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * <br>name - указывает на таблицу, где идет связь вторичных ключей.
     * <br>joinColumns - определяет ключ родительского объекта.
     * В данном примере Item.id.
     * <br>inverseJoinColumns - определяет ключ объекта,
     * который мы загружаем в родительский объект.
     */
    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> participates = new ArrayList<>();

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