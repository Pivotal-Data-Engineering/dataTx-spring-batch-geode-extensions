package io.pivotal.services.dataTx.spring.batch.geode;

import java.util.UUID;
import java.util.function.Function;

/**
 * Generate a GUID
 * @author Gregory Green
 */
public class KeyGenerateGuidFunction<T> implements Function<T, String>
{
    @Override
    public String apply(T t)
    {
        return UUID.randomUUID().toString();
    }
}
