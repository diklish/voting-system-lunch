package com.diplom.klishin.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    protected String name;


    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    protected String contents;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dish")
    //@OrderBy("name DESC")
    private Set<Menu> menu;

    public Dish() {
    }

    public Dish(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 2, max = 100) String contents, @NotNull Set<Menu> menu) {
        this.name = name;
        this.contents = contents;
        this.menu = menu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }
}
