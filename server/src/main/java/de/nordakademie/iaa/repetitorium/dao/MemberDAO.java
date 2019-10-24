package de.nordakademie.iaa.repetitorium.dao;

import de.nordakademie.iaa.repetitorium.model.Member;

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
    public Member findBy(String name, String address) {
        return entityManager
                .createQuery("select member from Member member where member.name = :name and member.address = :adress", Member.class)
                .setParameter("name", name)
                .setParameter("address", address)
                .getResultStream()
                .findFirst().orElse(null);
    }

    /**
     * Takes the member and stores it in the database.
     *
     * @param member The Member to be persisted.
     */
    public void persist(Member member) {
        entityManager.persist(member);
    }

    /**
     * List all members currently stored in the database.
     *
     * @return a list of Member entities. If no member was found an empty list is returned.
     */
    public List<Member> findAll() {
        return entityManager.createQuery("select member from Member member", Member.class).getResultList();
    }
    /**
     * Returns the member identified by the given id.
     *
     * @param memberId The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Member findBy(Long memberId) {
        return entityManager.find(Member.class, memberId);
    }
    /**
     * Deletes the member.
     *
     * @param member The room to be deleted.
     */
    public void delete(Member member) {
        entityManager.remove(member);
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
