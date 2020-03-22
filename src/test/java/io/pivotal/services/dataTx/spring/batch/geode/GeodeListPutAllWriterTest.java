package io.pivotal.services.dataTx.spring.batch.geode;

import nyla.solutions.core.security.user.data.UserProfile;
import org.apache.geode.cache.Region;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class GeodeListPutAllWriterTest
{
    @Test
    void item_writer_putall()
    throws Exception
    {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("imani@vmware.com");
        userProfile.setPhone("555-555-5555");
        Function<UserProfile,String> converter = (user) -> user.getEmail();

        Region<String, UserProfile> region = mock(Region.class
                );

        GeodeListPutAllWriter writer = new GeodeListPutAllWriter(region,converter);


        List<UserProfile> list = Collections.singletonList(userProfile);
        writer.write(list);

        verify(region,atLeastOnce()).putAll(any());

    }
}