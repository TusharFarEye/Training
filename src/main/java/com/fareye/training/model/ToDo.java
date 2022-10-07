package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class ToDo {
    @NotNull
    private LocalDateTime dueDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    @NotNull
    private String body;
    @NotNull
    private String title;
    private boolean status;
    @NotNull
    private User user;

    public void setBody(String _body) {
        body = _body;
        setCreatedDate();
        setModifiedDate();
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setCreatedDate() {
        if(this.createdDate==null){
            LocalDateTime createdDate= LocalDateTime.now();
            this.createdDate = createdDate;
        }
    }
    public void setModifiedDate() {
        LocalDateTime modifiedDate= LocalDateTime.now();
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "dueDate=" + dueDate +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
