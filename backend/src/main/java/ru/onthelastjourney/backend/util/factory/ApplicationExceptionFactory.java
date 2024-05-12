package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;

public class ApplicationExceptionFactory {

    private ApplicationExceptionFactory() {
    }

    public static class EntityNotFound {

        private EntityNotFound() {
        }

        public static <ID> EntityNotFoundException byId(String entityName, ID id) {
            return byParam(entityName, "id", id);
        }

        public static <PV> EntityNotFoundException byParam(String entityName, String paramName, PV paramValue) {
            String message = EntityNotFoundException
                    .messageBuilder()
                    .entity(entityName)
                    .withParamNameAndValue(paramName, paramValue)
                    .notFound();

            return new EntityNotFoundException(message);
        }

        public static <PV1, PV2>
        EntityNotFoundException byParams(String entityName,
                                         String paramName1, PV1 paramValue1,
                                         String paramName2, PV2 paramValue2) {
            String message = EntityNotFoundException
                    .messageBuilder()
                    .entity(entityName)
                    .withParamNameAndValue(paramName1, paramValue1)
                    .and()
                    .withParamNameAndValue(paramName2, paramValue2)
                    .notFound();

            return new EntityNotFoundException(message);
        }

        public static <PV1, PV2, PV3>
        EntityNotFoundException byParams(String entityName,
                                         String paramName1, PV1 paramValue1,
                                         String paramName2, PV2 paramValue2,
                                         String paramName3, PV3 paramValue3) {
            String message = EntityNotFoundException
                    .messageBuilder()
                    .entity(entityName)
                    .withParamNameAndValue(paramName1, paramValue1)
                    .and()
                    .withParamNameAndValue(paramName2, paramValue2)
                    .and()
                    .withParamNameAndValue(paramName3, paramValue3)
                    .notFound();

            return new EntityNotFoundException(message);
        }

        public static <PV1, PV2, PV3, PV4>
        EntityNotFoundException byParams(String entityName,
                                         String paramName1, PV1 paramValue1,
                                         String paramName2, PV2 paramValue2,
                                         String paramName3, PV3 paramValue3,
                                         String paramName4, PV4 paramValue4) {
            String message = EntityNotFoundException
                    .messageBuilder()
                    .entity(entityName)
                    .withParamNameAndValue(paramName1, paramValue2)
                    .and()
                    .withParamNameAndValue(paramName2, paramValue2)
                    .and()
                    .withParamNameAndValue(paramName3, paramValue3)
                    .and()
                    .withParamNameAndValue(paramName4, paramValue4)
                    .notFound();

            return new EntityNotFoundException(message);
        }

        public static <PV1, PV2, PV3, PV4, PV5>
        EntityNotFoundException byParams(String entityName,
                                         String paramName1, PV1 paramValue1,
                                         String paramName2, PV2 paramValue2,
                                         String paramName3, PV3 paramValue3,
                                         String paramName4, PV4 paramValue4,
                                         String paramName5, PV5 paramValue5) {
            String message = EntityNotFoundException
                    .messageBuilder()
                    .entity(entityName)
                    .withParamNameAndValue(paramName1, paramValue1)
                    .and()
                    .withParamNameAndValue(paramName2, paramValue2)
                    .and()
                    .withParamNameAndValue(paramName3, paramValue3)
                    .and()
                    .withParamNameAndValue(paramName4, paramValue4)
                    .and()
                    .withParamNameAndValue(paramName5, paramValue5)
                    .notFound();

            return new EntityNotFoundException(message);
        }

    }

}
