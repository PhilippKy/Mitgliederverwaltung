package de.nordakademie.iaa.repetitorium.dao;

import de.nordakademie.iaa.repetitorium.model.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberDAO {

    private EntityManager entityManager;

    /**
     * Finds a member by given memberId.
     *
     * @param memberId   The Number associated with a specific member.
     * @return a member or {@code null}.
     */
    public Member findBy(Integer memberId) {
        return entityManager
                .createQuery("select member from Member member where member.memberId = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .getResultStream()
                .findFirst().orElse(null);
    }

    /**
     * Takes the member and stores it in the database.
     *
     * @param member The Member to be persisted.
     */
    public void persistMember(Member member) {
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
}
