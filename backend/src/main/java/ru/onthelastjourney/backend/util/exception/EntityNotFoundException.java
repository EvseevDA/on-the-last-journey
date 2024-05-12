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

        private final StringBuilder messageBuilder;

        public MessageBuilder() {
            messageBuilder = new StringBuilder();
        }

        public MessageBuilder entity(String entityName) {
            messageBuilder.append(entityName).append(' ');

            return this;
        }

        public <V> MessageBuilder withParamNameAndValue(String paramName, V paramValue) {
            messageBuilder.append(String.format("with {%s=%s} ", paramName, paramValue));

            return this;
        }

        public MessageBuilder and() {
            messageBuilder.append("and ");

            return this;
        }

        public String notFound() {
            messageBuilder.append("not found");

            return messageBuilder.toString();
        }

    }

}
