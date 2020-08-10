package com.harry.Audio_Forum.pojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostResourceRepository extends CrudRepository<PostResource, Long> {
}
