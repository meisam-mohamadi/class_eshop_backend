package com.api.eshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "longtext")
    private String original;

    @Column(columnDefinition = "longtext")
    private String thumbnail;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ProductImages_fk_1"))
    @JsonBackReference("product")
    private Products product;
}
