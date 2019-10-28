package de.nordakademie.iaa.repetitorium.dao;

import de.nordakademie.iaa.repetitorium.model.ClubMember;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MemberDAO {

    private EntityManager entityManager;

    /**
     * Finds a member by given memberId.
     * @param name   The name.
     * @param address The address.
     * @return a member or {@code null}.
     */
    public ClubMember findBy(String name, String address) {
        return entityManager
                .createQuery("select clubMember from ClubMember clubMember where clubMember.name = :name", ClubMember.class)
                .setParameter("name", name)
                .getResultStream()
                .findFirst().orElse(null);
    }

    /**
     * Takes the member and stores it in the database.
     *
     * @param clubMember The Member to be persisted.
     */
    public void persist(ClubMember clubMember) {
        entityManager.persist(clubMember);
    }

    /**
     * List all members currently stored in the database.
     *
     * @return a list of Member entities. If no member was found an empty list is returned.
     */
    public List<ClubMember> findAll() {
        return entityManager.createQuery("select clubMember from ClubMember clubMember", ClubMember.class).getResultList();
    }
    /**
     * Returns the member identified by the given id.
     *
     * @param memberId The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public ClubMember findBy(Long memberId) {
        return entityManager.find(ClubMember.class, memberId);
    }
    /**
     * Deletes the member.
     *
     * @param clubMember The room to be deleted.
     */
    public void delete(ClubMember clubMember) {
        entityManager.remove(clubMember);
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
