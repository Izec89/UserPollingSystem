package com.izec.repositories;

import com.izec.domeins.Poll;
import org.springframework.data.repository.CrudRepository;


public interface PollRepository extends CrudRepository<Poll, Long> {
    Poll findByTitle(String filter);
}
