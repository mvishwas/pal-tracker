package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    List<TimeEntry> telist = new ArrayList<TimeEntry>();
    private long sequence =1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry tn =new TimeEntry(sequence++,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        telist.add(tn);
        return tn;
    }

    @Override
    public TimeEntry  find(long l) {
        for (TimeEntry e:telist) {
            if (e.getId() == l) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List list() {

        return telist;
    }

    @Override
    public TimeEntry  update(long id, TimeEntry timeEntry) {
        for (int i=0;i<telist.size();i++) {
            if (telist.get(i).getId() == id) {
                telist.remove(telist.get(i));

                telist.add(new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours()));

                return telist.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {

        Iterator<TimeEntry> itr = telist.iterator();

        while (itr.hasNext())
        {

            TimeEntry e = itr.next();
            if (e.getId()== id) {
                itr.remove();
            }
   }
    }
}
