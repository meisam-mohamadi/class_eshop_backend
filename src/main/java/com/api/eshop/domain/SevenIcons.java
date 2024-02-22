package com.api.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SevenIcons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String iconName;

    private String url;

    private String label;
}
