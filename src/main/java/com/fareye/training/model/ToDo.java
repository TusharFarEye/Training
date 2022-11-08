package com.fareye.training.model;

import com.fareye.training.annotation.DuplicateTitle;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@DuplicateTitle
@Data
@Entity
@Table(name = "todos")
public class ToDo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dueDate;
    private String createdDate;
    private String modifiedDate;
    private String body;
    private String title;
    private String status;
    private Integer userId;
    public void setBody(String _body) {
        body = _body;
        setCreatedDate();
        setModifiedDate();
    }

    public void setCreatedDate() {
        if(this.createdDate==null){
            LocalDateTime createdDate= LocalDateTime.now();
            this.createdDate = createdDate.toString();
        }
    }
    public void setModifiedDate() {
        LocalDateTime modifiedDate= LocalDateTime.now();
        this.modifiedDate = modifiedDate.toString();
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
                ", user=" + userId +
                '}';
    }
}
