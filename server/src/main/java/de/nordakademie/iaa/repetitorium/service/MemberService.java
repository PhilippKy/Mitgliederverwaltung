package de.nordakademie.iaa.repetitorium.service;

import de.nordakademie.iaa.repetitorium.model.ClubMember;

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
     * @param clubMember The member to be persisted.
     * @throws EntityAlreadyPresentException if a member with the same Name/Address/birthday
     *                                       combination is already present in the database.
     */
    void createNew(ClubMember clubMember) throws EntityAlreadyPresentException;

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Member entities. If no member was found an empty list is
     * returned.
     */
    List<ClubMember> findAll();

    /**
     * Returns the room identified by the given id.
     *
     * @param memberId The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    ClubMember findBy(Long memberId);

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
     * //@param familyClubMember   family member.
     * @throws EntityNotFoundException if no room could be found for the given id.
     */
    void update(Long memberId, String name,String address, Long birthday ,String memberType, Integer membershipFee,
                Integer payedFee, Integer bankInfo
            //, ClubMember familyClubMember
                ) throws EntityNotFoundException;

    /**
     * Deletes the room with the given id.
     *
     * @param memberId The identifier.
     * @throws EntityNotFoundException if no room could be fount for the given id.
     */
    void delete(Long memberId) throws EntityNotFoundException;
}

