package pairmatching.service;

import pairmatching.repository.MatchingInformationRepository;
import pairmatching.repository.PairRepository;

public class ResetService {

    public void reset() {
        MatchingInformationRepository.reset();
        PairRepository.reset();
    }

}
