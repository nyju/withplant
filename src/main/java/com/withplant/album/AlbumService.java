package com.withplant.album;

import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;

    public Album createNewAlbum(Album album, Member member){
        Album newAlbum = repository.save(album);

        return newAlbum;
    }
}
