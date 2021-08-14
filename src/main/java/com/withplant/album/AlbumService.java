package com.withplant.album;

import com.withplant.attachment.Attachement;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;

    public void registerAlbum(AlbumForm albumForm, Member member) {

        Album album = new Album();
        album.setAttachements(albumForm.getAttachements());
        for (Attachement att : albumForm.getAttachements()) {
            album.addAttachement(att);
        }

        album.setContent(albumForm.getContent());
        album.setMember(member);
        album.setRgstDate(LocalDateTime.now());
        repository.save(album);

    }

    public void deleteAlbum(Long itemid) {
        repository.deleteById(itemid);
    }

    public AlbumForm getAlbum(Long itemid) {
        Optional<Album> albumWrapper = repository.findById(itemid);
        Album album = albumWrapper.get();

        AlbumForm albumForm = new AlbumForm();
        albumForm.setContent(album.getContent());
        albumForm.setAttachements(album.getAttachements());

        return albumForm;
    }
}
