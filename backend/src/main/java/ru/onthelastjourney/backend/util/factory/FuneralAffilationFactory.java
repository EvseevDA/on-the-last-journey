package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.entity.FuneralAffilation;

public class FuneralAffilationFactory {

    private FuneralAffilationFactory() {
    }

    public static FuneralAffilation createFuneralAffilationById(Long id) {
        return FuneralAffilation.builder().id(id).build();
    }

}
