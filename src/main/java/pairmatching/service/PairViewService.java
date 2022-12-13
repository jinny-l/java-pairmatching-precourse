package pairmatching.service;

import java.util.List;
import pairmatching.domain.MatchingInformation;
import pairmatching.repository.MatchingInformationRepository;
import pairmatching.repository.PairRepository;

public class PairViewService {

    public int findMatchingInformationIndex(List<String> information) {
        MatchingInformation matchingInformation =
                MatchingInformationRepository.findInformationOf(new MatchingInformation(information));
        return MatchingInformationRepository.indexOf(matchingInformation);
    }

    public List<List<String>> findPairInformation(int index) {
        return PairRepository.findNamesByIndex(index);
    }

}
