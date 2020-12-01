package volleyball.model.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.common.model.member.Member;

import java.util.Optional;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Integer> {

    default Member saveObject(Member member) {
        Optional<Member> dbObjet = findAll().stream().filter(o -> o.equals(member)).findFirst();

        if (!dbObjet.isPresent()) {
            save(member);
            return member;
        } else {
            return dbObjet.get();
        }
    }
}


