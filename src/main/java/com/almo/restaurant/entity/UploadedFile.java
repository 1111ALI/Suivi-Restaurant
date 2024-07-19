package com.almo.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="uploads")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UploadedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fileName;
    private String fileType;
}
