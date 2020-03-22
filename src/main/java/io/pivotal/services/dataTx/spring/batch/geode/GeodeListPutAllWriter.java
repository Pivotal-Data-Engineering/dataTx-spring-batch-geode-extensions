package io.pivotal.services.dataTx.spring.batch.geode;

import org.apache.geode.cache.Region;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Item writer that uses a convert to change the l
 * @author Gregory Green
 */
public class GeodeListPutAllWriter<T> implements ItemWriter<T>
{
    private final Region<Object,Object> region;
    private  final Function<Object,Object> toKey;
    public GeodeListPutAllWriter(Region<?, ?> region, Function<?, ?> toKey)
    {
        this.region = (Region)region;
        this.toKey = (Function)toKey;
    }


    public void write(List<?extends T> items)
    throws Exception
    {
        Function<Object,Object> toValue = (o) -> o;

        Map<Object,Object> map = items.stream()
                .collect(Collectors.toMap(toKey,
                        toValue));

        region.putAll(map);

    }

}
