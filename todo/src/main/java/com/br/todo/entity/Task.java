package com.br.todo.entity;

import com.br.todo.types.Status;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_task")
public class Task {
    @Id
    @jakarta.persistence.Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Status status;

    private  String title;

    private  String Description;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;



}
