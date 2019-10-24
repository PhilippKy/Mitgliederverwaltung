package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.model.Member;

import java.util.List;

/**
 * Public interface of the member service.
 *
 * @author Iurii Chernovalov
 */
public interface MemberService {

    /**
     * Takes the new member and stores it in the database.
     *
     * @param member The member to be persisted.
     * @throws EntityAlreadyPresentException if a member with the same Name/Address/birthday
     *                                       combination is already present in the database.
     */
    void createNew(Member member) throws EntityAlreadyPresentException;

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Member entities. If no member was found an empty list is
     * returned.
     */
    List<Member> findAll();

    /**
     * Returns the room identified by the given id.
     *
     * @param memberId The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    Member findBy(Long memberId);

    /**
     * Updates a Member entity and stores the changes into the database.
     *
     * @param memberId       The identifier.
     * @param name           The name.
     * @param address        The address.
     * @param memberType     The type of member.
     * @param membershipFee  Membership fee.
     * @param payedFee       payed fee.
     * @param bankInfo       bank information.
     * @param familyMember   family member.
     * @throws EntityNotFoundException if no room could be found for the given id.
     */
    void update(Long memberId, String name,String address, String memberType, Integer membershipFee,
                Integer payedFee, Integer bankInfo, Member familyMember) throws EntityNotFoundException;

    /**
     * Deletes the room with the given id.
     *
     * @param memberId The identifier.
     * @throws EntityNotFoundException if no room could be fount for the given id.
     */
    void delete(Long memberId) throws EntityNotFoundException;
}

