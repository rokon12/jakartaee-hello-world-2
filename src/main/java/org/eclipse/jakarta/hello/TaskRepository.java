package org.eclipse.jakarta.hello;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskRepository extends BasicRepository<Task, Long> {
    //List<Task> findByCompleted(boolean completed);

//    @PersistenceContext
//    private EntityManager em;
//
//    public List<Task> findCompleted() {
//        return em.createQuery("SELECT t FROM Task t WHERE t.completed = true", Task.class).getResultList();
//    }
//
//    public List<Task> findAll(){
//        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
//    }
//
//    public List<Task> findPending() {
//        return em.createQuery("SELECT t FROM Task t WHERE t.completed = false", Task.class).getResultList();
//    }
//
//    public Task save(Task task) {
//        if (task.getId() == null) {
//            em.persist(task);  // New task, so persist it
//        } else {
//            em.merge(task);   // Existing task, so merge it
//        }
//        return task;         // Return the saved (or updated) task
//    }
//
//    public void toggleComplete(Long id) {
//        Task task = em.find(Task.class, id);
//        if (task != null) {
//            task.setCompleted(!task.isCompleted());
//        }
//    }
}
