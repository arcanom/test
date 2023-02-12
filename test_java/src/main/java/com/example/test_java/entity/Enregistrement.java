package com.example.test_java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enregistrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_Enregistrement")
    private Date dateEnregistrement;

    @Column(name = "rate_Measure")
    private float rateMeasure;

    @Column(name = "temperature_Measure")
    private float temperatureMeasure;

    @JoinColumn(name = "module_id")
    private int moduleId;


}
