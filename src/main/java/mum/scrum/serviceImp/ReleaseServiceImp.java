package mum.scrum.serviceImp;

import mum.scrum.model.Release;
import mum.scrum.repository.ReleaseRepository;
import mum.scrum.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ishwor on 11/12/15.
 */
@Service
public class ReleaseServiceImp implements ReleaseService{


    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public boolean saveRelease(Release release) {
        if(releaseRepository.save(release)!=null)
            return true;
        return false;
    }

    @Override
    public List<Release> findAllRelease() {
        return releaseRepository.findAll();
    }

    @Override
    public Release findReleaseById(int id) {
        return releaseRepository.findOne(id);
    }

    @Override
    public boolean updateRelease(Release release) {
         if(releaseRepository.save(release)!=null){
             return true;
         }
        return false;
    }

    @Override
    public void deleteRelease(int id) {
        releaseRepository.delete(id);
    }
}
