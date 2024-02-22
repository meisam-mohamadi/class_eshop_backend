package com.api.eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainSlider
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "longtext")
    private String original;

    @Column(columnDefinition = "longtext")
    private String thumbnail;

    @Column(columnDefinition = "longtext")
    private String url;



}
