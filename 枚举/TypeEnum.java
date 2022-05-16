@Getter
public enum  TypeEnum {
    APPLE("apple"),
    ORANGE("orange");

    TypeEnum (String code) {
        this.code = code;
    }
    private String code;

    public static TypeEnum get(String code) {
        Optional<TypeEnum> first = Arrays.stream(values())
                .filter(item -> StringUtils.equalsIgnoreCase(item.getCode(), code))
                .findFirst();
        return first.orElse(null);
    }

    public static boolean contains(String code) {
        Optional<TypeEnum> first = Arrays.stream(values())
                .filter(item -> item.code.equalsIgnoreCase(code))
                .findFirst();
        return first.isPresent();
    }

}