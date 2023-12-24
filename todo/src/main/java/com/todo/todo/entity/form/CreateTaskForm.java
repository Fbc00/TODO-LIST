package com.todo.todo.entity.form;

import com.todo.todo.types.Status;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskForm {

    private String title;

    private String description;

    private  final Status status = Status.pending;

    private Long userId;

}
