package ru.onthelastjourney.backend.util.exception;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public static MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }

    public static class MessageBuilder {

        private final StringBuilder messageBlank;

        private MessageBuilder() {
            messageBlank = new StringBuilder();
        }

        public MessageBuilder entity(String entityName) {
            messageBlank.append(entityName).append(' ');

            return this;
        }

        public <PV> MessageBuilder withParamNameAndValue(String paramName, PV paramValue) {
            messageBlank.append(String.format("with {%s=%s} ", paramName, paramValue));

            return this;
        }

        public MessageBuilder and() {
            messageBlank.append("and ");

            return this;
        }

        public String notFound() {
            messageBlank.append("not found");

            return messageBlank.toString();
        }

    }

}
