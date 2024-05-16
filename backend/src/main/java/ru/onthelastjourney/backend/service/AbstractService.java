package ru.onthelastjourney.backend.service;

import org.postgresql.util.PSQLException;
import org.springframework.transaction.annotation.Transactional;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;

@Transactional(rollbackFor = { EntityNotFoundException.class, PSQLException.class })
public abstract class AbstractService {

}
