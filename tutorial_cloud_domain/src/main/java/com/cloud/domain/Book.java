package com.cloud.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jimmy. 2018/6/3  21:02
 */
@Data
@Entity
@Table(name = "cloud_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 6824399282228308909L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
}
