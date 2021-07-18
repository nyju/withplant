package com.withplant.attachment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withplant.album.Album;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Attachement {

    /** 파일 번호 (PK) */
    @Id
    @GeneratedValue
    private Long id;

    /** 원본 파일명 */
    private String fileName;

    /** 저장 파일명 */
    private String saveName;

    /** 저장 경로 */
    private String path;

    /** 파일 크기 */
    private long size;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


}
