# Spring Batch Apache Geode Extensions

This library contains a few useful classes to help with [Spring
Batch](https://spring.io/projects/spring-batch) applications that use [Apache Geode](https://geode.apache.org/).
[Apache Geode](https://geode.apache.org/) is the open source In-Memory Data Grid (IMDG).
[Tanzu VMware (Pivotal)](https://tanzu.vmware.com/) has an commercial implementation of Apache Geode
called [GemFire](https://gemfire.docs.pivotal.io/gemfire/about_gemfire.html) and a cloud managed service deployment 
called [Tanzu GemFire or Pivotal Cloud Cache (PCC)](https://tanzu.vmware.com/gemfire) . 
This modules can be used with Apache Geode, GemFire, PCC and Tanzu GemFire.


This module can also be used with [Spring Data Geode](https://spring.io/projects/spring-data-geode)
or [Spring Data GemFire](https://spring.io/projects/spring-data-gemfire) . 


In many cases, these utilities are improvements over the default [Spring
                                                                 Batch](https://spring.io/projects/spring-batch)
[GemFireItemWriter](https://docs.spring.io/spring-batch/docs/4.2.x/reference/html/readersAndWriters.html#gemfireItemWriter).

Category     |       Type               | Notes
------------ | ------------------------ | ---------------
ItemWriter  |  GeodeListPutAllWriter   | Optimized for Apache Geode writes using a [Region PutAll](https://gemfire.docs.pivotal.io/geode/basic_config/data_entries_custom_classes/managing_data_entries.html) operation. It must be provided with a [java.util.Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) to determine the key to use from list data domain object.
ItemWriter  | GeodeMapEntryWriter      | Using the Region putall where the list already contains  key and value in the form of a [Map.Entry](https://docs.oracle.com/javase/8/docs/api/java/util/Map.Entry.html)
ItemReader  | GeodePdxItemReader       | Reads region entries into a [Map.Entry](https://docs.oracle.com/javase/8/docs/api/java/util/Map.Entry.html) where the value is expected to be an instance PDX.


For out of box [java.util.Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) that can be used for *GeodeListPutAllWriter* see the following 

Category     |    Notes
------------ |  -----
[KeyGenerateGuidFunction](https://github.com/Pivotal-Data-Engineering/dataTx-spring-batch-geode-extensions/blob/master/src/main/java/io/pivotal/services/dataTx/spring/batch/geode/KeyGenerateGuidFunction.java)| Returns a UUID string
[KeyJavaBeanPropertyFunction](https://github.com/Pivotal-Data-Engineering/dataTx-spring-batch-geode-extensions/blob/master/src/main/java/io/pivotal/services/dataTx/spring/batch/geode/KeyJavaBeanPropertyFunction.java)| Using reflection to dynamically use a JavaBean's property as a the value. This implementation uses [nyla-solutions](https://github.com/nyla-solutions/nyla) [JavaBean](https://github.com/nyla-solutions/nyla/blob/master/src/main/java/nyla/solutions/core/util/JavaBean.java) implementation. 
