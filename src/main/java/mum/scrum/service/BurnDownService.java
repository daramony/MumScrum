package mum.scrum.service;

import java.util.*;

/**
 * Created by ishwor on 11/12/15.
 */
public interface BurnDownService {
    public Map<String,TreeMap<String, Integer>> generateBurnDownData(int sprintId);
}
