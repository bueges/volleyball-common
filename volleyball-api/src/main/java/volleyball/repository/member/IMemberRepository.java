package volleyball.repository.member;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.member.Member;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Integer> {

    default Member saveObject(@NonNull Member member) {
        // define filter
        Predicate<Member> filterByName = m -> m.getName().equals(member.getName());

        Predicate<Member> filterByPreName = m -> m.getPreName().equals(member.getPreName());

        Predicate<Member> filterByGender = m -> m.getGender().equals(member.getGender());

        Predicate<Member> filterByBirthday = m -> m.getBirthday().equals(member.getBirthday());

        Optional<Member> searchResult = findAll()
                .stream()
                .filter(filterByName.and(filterByPreName).and(filterByGender).and(filterByBirthday))
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(member);
        }
    }
}
