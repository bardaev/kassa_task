package com.example.kassa.entity;

import com.example.kassa.json.Obj;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sk_example_table")
@TypeDef(name = "JsonbType", typeClass = JsonBinaryType.class)
public class SkExampleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "obj", columnDefinition = "jsonb")
    @Type(type = "JsonbType")
    private Obj obj;
}
