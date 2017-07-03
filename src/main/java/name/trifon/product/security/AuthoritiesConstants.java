package name.trifon.product.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN"; //@Trifon(GardenWorld Admin) old: ROLE_ADMIN

    public static final String USER = "ROLE_USER"; //@Trifon(GardenWorld User) old: ROLE_USER

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}
