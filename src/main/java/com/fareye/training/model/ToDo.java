package com.fareye.training.model;

import com.fareye.training.annotation.DuplicateTitle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @DuplicateTitle @Service
public class ToDo {
    private LocalDateTime dueDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String body;

    private String title;
    private boolean status;
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
