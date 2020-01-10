package com.HW08.maktab32.repositories;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Tag;

public class TagRepository extends CrudRepository<Tag,Long> {
    private static TagRepository tagRepository;

    private TagRepository() {

    }

    public static TagRepository getInstance() {
        if (tagRepository == null) {
            tagRepository = new TagRepository();
        }
        return tagRepository;
    }
    @Override
    protected Class<Tag> getEntityClass() {
        return Tag.class;
    }
}
