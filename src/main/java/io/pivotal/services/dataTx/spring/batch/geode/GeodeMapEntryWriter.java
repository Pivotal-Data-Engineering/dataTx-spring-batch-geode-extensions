package io.pivotal.services.dataTx.spring.batch.geode;

import org.apache.geode.cache.Region;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * Converts list to map to perform a Apache Geode putall operation.
 *
 * @author Gregory Green
 */
public class GeodeMapEntryWriter<K,V>  implements ItemWriter<Map.Entry<K,V>>
{
    private final Region<K,V> region;

    /**
     *
     * @param region the region to put
     */
    public GeodeMapEntryWriter(Region<K, V> region)
    {
        this.region = region;
    }//-------------------------------------------

    @Override
    public void write(List<? extends Map.Entry<K, V>> items)
    throws Exception
    {
        if(items == null || items.isEmpty())
            return; //nothing to write

        Map<K,V> map = items.stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,Map.Entry::getValue)
                );

        region.putAll(map);
    }
}
