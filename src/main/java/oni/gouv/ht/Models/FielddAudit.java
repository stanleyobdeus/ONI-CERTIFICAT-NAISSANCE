package oni.gouv.ht.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true
)
public class FielddAudit {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    @LastModifiedDate
    private LocalDateTime updated_at;

    private Long updated_by;
    private Long created_by;
}
