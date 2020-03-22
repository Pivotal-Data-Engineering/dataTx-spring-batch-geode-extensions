package io.pivotal.services.dataTx.spring.batch.geode;

import org.apache.geode.cache.Region;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GeodeMapEntryWriterTest
{
    @Test
    void test_writer()
    throws Exception
    {
        GeodeMapEntryWriter writer =  null;


        try
        {
            writer = new GeodeMapEntryWriter(null);
        }
        catch (IllegalArgumentException e)
        {
        }

        Region<String,String> region = Mockito.mock(Region.class);
        writer = new GeodeMapEntryWriter(region);


        Map<String,String> expected = new HashMap<>();

        writer.write(null);


        writer.write(expected
                .entrySet()
                .stream()
                .collect(Collectors.toList()));

        String text;
        for (int i =0; i < 20; i++)
        {
            text = String.valueOf(i);
            expected.put(text,text);
        }

        writer.write(expected
                .entrySet()
                .stream()
                .collect(Collectors.toList()));

    }
}