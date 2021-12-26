package com.covoid21.panman.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Seating {
    @Id
    @Autowired
    private Long id;

    @ElementCollection
    List<Integer> seatings = new ArrayList<Integer>();
}