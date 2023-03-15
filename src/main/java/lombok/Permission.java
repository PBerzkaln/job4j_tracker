package lombok;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("rules")
    private List<String> rules;

    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("ADMIN")
                .rules("create")
                .rules("update")
                .rules("read")
                .rules("delete")
                .build();
        System.out.println(permission);
    }
}