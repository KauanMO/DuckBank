package service.exception;

public class JsonWebTokenException extends RuntimeException {
    public JsonWebTokenException(String type) {
        super(
                switch (type) {
                    case "blank":
                        yield "Json Web Token required";

                    case "invalid":
                        yield "Invalid Json Web Token";

                    case "expired":
                        yield "Expired Json Web Token";

                    default:
                        yield "Unknown Json Web Token error";
                }
        );
    }
}
