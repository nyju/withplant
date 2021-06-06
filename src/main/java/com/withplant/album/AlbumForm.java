package com.withplant.album;

import com.withplant.attachment.Attachement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class AlbumForm {

    private static final long serialVersionUID = 1L;
    String content;
    Set<Attachement> attachements;

    @Getter
    @Setter
    public static class AlbumFile {
        private String fileName;
        private String saveName;
        private String path;
    }
}
