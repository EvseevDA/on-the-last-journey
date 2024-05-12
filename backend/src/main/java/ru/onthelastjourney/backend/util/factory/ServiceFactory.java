package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.entity.Service;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static Service createServiceById(Long id) {
        return Service.builder().id(id).build();
    }

}
