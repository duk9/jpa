package jpabook.start;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME","AGE"})})
@Getter
@Setter
public class Member {

    @Id
    @Column(name="ID")
    private String id;
    @Column(name="NAME", nullable = false, length = 10)
    private String name;
    private Integer age;
    @Enumerated
    @Column(name = "role_type")
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;


}

 enum RoleType {
    ADMIN, USER
}
