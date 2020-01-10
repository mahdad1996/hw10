package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.AddNewTagByAdminUseCase;
import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Tag;
import com.HW08.maktab32.repositories.TagRepository;

public class AddNewTagByAdminUseCaseImpl implements AddNewTagByAdminUseCase {
    @Override
    public void Add(Tag tag) {

        TagRepository tagRepository = TagRepository.getInstance();
        tagRepository.save(tag);
        System.out.println("tag Added Succesfuly!");

    }
}
