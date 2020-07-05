package com.heiio.bookkafka.mapper;

import com.heiio.bookkafka.model.blog.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface BlogMapper {
    void insertBlog(@Param("blog") Blog blog,
                    @Param("topic") String topic,
                    @Param("partition") int partition,
                    @Param("offset") long offset,
                    Map<String, Integer> returnMap);
}
