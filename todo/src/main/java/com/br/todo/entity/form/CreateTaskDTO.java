package com.br.todo.entity.form;

import com.br.todo.types.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDTO {

    private String title;

    private String description;

    private  final Status status = Status.pending;

    private Long userId;

}
