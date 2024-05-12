package ru.onthelastjourney.backend.util.exception;

import ru.onthelastjourney.backend.util.factory.ApplicationExceptionFactory;

import java.util.function.Supplier;

public final class ExceptionSupplier {

    private ExceptionSupplier() {
    }

    public static Supplier<EntityNotFoundException> affilationTypeNotFoundById(Long id) {
        return entityNotFoundById("Affilation type", id);
    }

    public static Supplier<EntityNotFoundException> clientNotFoundById(Long id) {
        return entityNotFoundById("Client", id);
    }

    public static Supplier<EntityNotFoundException> employeeNotFoundById(Long id) {
        return entityNotFoundById("Employee", id);
    }

    public static Supplier<EntityNotFoundException> funeralAffilationNotFoundById(Long id) {
        return entityNotFoundById("Funeral affilation", id);
    }

    public static Supplier<EntityNotFoundException> orderNotFoundById(Long id) {
        return entityNotFoundById("Order", id);
    }

    public static Supplier<EntityNotFoundException> providerNotFoundById(Long id) {
        return entityNotFoundById("Provider", id);
    }

    public static Supplier<EntityNotFoundException> serviceNotFoundById(Long id) {
        return entityNotFoundById("Service", id);
    }

    private static <ID> Supplier<EntityNotFoundException> entityNotFoundById(String entityName, ID id) {
        return () -> ApplicationExceptionFactory.EntityNotFound.byId(entityName, id);
    }

}
