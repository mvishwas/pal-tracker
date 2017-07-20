package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry) ;

    public TimeEntry find(long l) ;

    public List list() ;

    public TimeEntry  update(long id, TimeEntry timeEntry);

    public TimeEntry delete(long id) ;
}
