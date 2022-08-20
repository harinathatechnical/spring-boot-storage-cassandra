package com.hari.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.Table;

import java.nio.ByteBuffer;
import java.util.UUID;


@Table(value = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

    @PrimaryKey
    private UUID id;
    private String name;
    private String type;

    @Column(value = "imageData")
    private ByteBuffer imageData;

}
