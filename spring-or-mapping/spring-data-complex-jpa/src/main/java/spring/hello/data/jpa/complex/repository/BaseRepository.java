package spring.hello.data.jpa.complex.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//基类repository,不用被发现为Bean
@NoRepositoryBean
public interface BaseRepository<T, Long> extends PagingAndSortingRepository<T, Long> {
    // findTop3By 这个后面也要加by
    // 按照updatetime降序，id升序
    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}
