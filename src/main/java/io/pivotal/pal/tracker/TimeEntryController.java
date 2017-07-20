package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry te =  timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<TimeEntry>(te, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public  ResponseEntity<TimeEntry> read(@PathVariable("id") long l) {

        TimeEntry timeEntry = timeEntryRepository.find(l);
        if(null!= timeEntry)
        return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
        else{
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/time-entries")
    public  ResponseEntity<List<TimeEntry>>  list() {
       return new  ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(),HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public  ResponseEntity<TimeEntry>  update(@PathVariable("id") long l, @RequestBody TimeEntry expected) {
        TimeEntry t = timeEntryRepository.update(l,expected);

        if(null!=t){
            return new  ResponseEntity<TimeEntry> (t,HttpStatus.OK);
        }else{
            return new  ResponseEntity<TimeEntry> (HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") long l) {

        TimeEntry y = timeEntryRepository.delete(l);

        if(null!=y) {
            return new ResponseEntity<TimeEntry>(y, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
        }
    }
}
