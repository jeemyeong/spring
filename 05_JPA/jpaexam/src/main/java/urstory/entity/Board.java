package urstory.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "board")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Board implements Serializable {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String name;
    @Lob
    private String content;
    private Date regdate;

    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "read_count")
    private int readCount;
}