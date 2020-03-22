package io.pivotal.services.dataTx.spring.batch.geode;

import nyla.solutions.core.security.user.data.UserProfile;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Test cases for GenerateGuidKeyFunction
 * @author Gregory Green
 */
class KeyGenerateGuidFunctionTest
{

    @Test
    void generate_key_function()
    {
        int numberOfTimes = 100;
        KeyGenerateGuidFunction func1 = new KeyGenerateGuidFunction();

        KeyGenerateGuidFunction func2 = new KeyGenerateGuidFunction();

        UserProfile user = new UserProfile();

        Set<String> set = new HashSet<>(numberOfTimes);

        String key1, key2;
        for (int i = 0; i < numberOfTimes ; i++)
        {
            key1 = func1.apply(user);
            assertNotNull(key1);

            assertTrue(!set.contains(key1));

            set.add(key1);

            key2 = func2.apply(user);
            assertNotNull(key2);

            assertTrue(!set.contains(key2));

            set.add(key2);

        }

    }
}