package io.pivotal.services.dataTx.spring.batch.geode;

import nyla.solutions.core.exception.SystemException;
import nyla.solutions.core.security.user.data.UserProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case for JavaBeanPropertyKeyFunction
 * @author Gregory Green
 */
class KeyJavaBeanPropertyFunctionTest
{

    @Test
    void test_key_from_property()
    {
        String propertyName= "email";
        KeyJavaBeanPropertyFunction<UserProfile,String> keyJavaBeanPropertyFunction = new KeyJavaBeanPropertyFunction<>(propertyName);

        assertNull(keyJavaBeanPropertyFunction.apply(null));

        UserProfile userProfile = new UserProfile();
        assertNotNull(keyJavaBeanPropertyFunction.apply(userProfile));
        assertEquals("", keyJavaBeanPropertyFunction.apply(userProfile));
        userProfile.setEmail("imani@vmware.com");
        assertEquals(userProfile.getEmail(), keyJavaBeanPropertyFunction.apply(userProfile));

    }

    @Test
    void test_invalid_property()
    {
        String propertyName= "invalid";
        KeyJavaBeanPropertyFunction<UserProfile,String> keyJavaBeanPropertyFunction = new KeyJavaBeanPropertyFunction<>(propertyName);

        UserProfile userProfile = new UserProfile();
        assertThrows(SystemException.class, () -> keyJavaBeanPropertyFunction.apply(userProfile));

    }
}