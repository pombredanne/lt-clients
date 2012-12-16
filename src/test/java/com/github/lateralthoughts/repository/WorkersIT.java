package com.github.lateralthoughts.repository;

import com.github.lateralthoughts.config.TestConfiguration;
import com.github.lateralthoughts.domain.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class WorkersIT {

    @Inject
    private WorkersRepository workerRepository;

    @Test
    public void should_insert_a_worker() {
        Worker worker = worker("Florent", "Biville", "f.biville@lateral-thoughts.com");
        workerRepository.save(worker);

        assertThat(workerRepository.findAll()).hasSize(1);
    }

    @Test
    public void should_delete_a_worker() {
        Worker savedWorker = workerRepository.save(worker("Jean-Baptiste", "Lemée", "jbl@lateral-thoughts.com"));
        workerRepository.delete(savedWorker);

        assertThat(workerRepository.findAll()).hasSize(0);
    }

    @Test
    public void should_update_a_worker() {
        Worker worker = worker("Hugo", "Lessiège", "h.lessiege@lateral-thoughts.com");
        Worker savedWorker = workerRepository.save(worker);
        savedWorker.setLastName("Lassiège");
        savedWorker.setEmail("h.lassiege@lateral-thoughts.com");
        workerRepository.save(savedWorker);

        assertThat(workerRepository.findByLastName("Lassiège").getFirstName()).isEqualTo("Hugo");
        assertThat(workerRepository.findByLastName("Lassiège").getEmail()).isEqualTo("h.lassiege@lateral-thoughts.com");
    }

    private Worker worker(String firstName, String lastName, String email) {
        return new Worker(firstName, lastName, email);
    }


}
