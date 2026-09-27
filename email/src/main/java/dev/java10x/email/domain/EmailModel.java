package dev.java10x.email.domain;

import dev.java10x.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    private final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID emailId;
    private UUID userId;
    private String to;
    private String emailFrom;
    private String emailSubject;
    @Column(columnDefinition = "BODY")
    private String body;
    private EmailStatus statusEmail;
    private LocalDateTime sendDateEmail;
}
