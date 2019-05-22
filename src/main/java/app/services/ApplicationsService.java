package app.services;

import app.entities.Application;
import app.repositories.ApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationsService {
    private final ApplicationsRepository applicationsRepository;

    @Autowired
    public ApplicationsService(ApplicationsRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }

    public Optional<Application> applicationById(Long id) {
        return applicationsRepository.findById(id);
    }

    public void save(Application application) {
        applicationsRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationsRepository.findAll();
    }

    public Optional<Application> findByProfileAndJob(Long profileId, Long jobId) {
        return applicationsRepository.findByProfileIdAndJobId(profileId, jobId);
    }

    public void rejectApplication(Application application) {
        application.setIsRejected(1);
        applicationsRepository.save(application);
    }

    public void acceptApplication(Application application) {
        application.setIsAccepted(1);
        applicationsRepository.save(application);
    }
}
