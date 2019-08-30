package com.training.api.concurrency;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main( String[] args ){

        Set<Person> set = new HashSet<Person>();
        Set<Person> setSynchronized = Collections.synchronizedSet( set );

        Map<Integer, Person> map = new HashMap();
        Map<Integer, Person> mapSynchronized = Collections.synchronizedMap( map );

        List<Person> list = new ArrayList<Person>();
        List<Person> listSynchronized = Collections.synchronizedList( list );

        initCollections( set, map, list, setSynchronized, mapSynchronized, listSynchronized );

        int person = 6784;
        System.out.println( "Set..." );
        validateContains( set, person );
        System.out.println( "----------------------" );
        System.out.println( "Set synchronized..." );
        validateContains( setSynchronized, person );
        System.out.println( "----------------------" );
        System.out.println( "Map..." );
        validateContains( map, person );
        System.out.println( "----------------------" );
        System.out.println( "Map synchronized..." );
        validateContains( mapSynchronized, person );
        System.out.println( "----------------------" );
        System.out.println( "List..." );
        validateContains( list, person );
        System.out.println( "----------------------" );
        System.out.println( "List synchronized..." );
        validateContains( listSynchronized, person );
        System.out.println( "----------------------" );

    }

    public static void validateContains( Collection<Person> collection, int id ){
        long start = System.nanoTime();
        boolean result = collection.contains( id );
        long finish = System.nanoTime();
        System.out.println( "Contains: " + result + "...time:" + TimeUnit.NANOSECONDS.toMicros(finish - start));
    }

    public static void validateContains( Map<Integer, Person> collection, int id ){
        long start = System.nanoTime();
        boolean result = collection.containsKey( id );
        long finish = System.nanoTime();
        System.out.println( "Contains: " + result + "...time:" + TimeUnit.NANOSECONDS.toMicros(finish - start));
    }

    public static void initCollections(Set<Person> set, Map<Integer, Person> map, List<Person> list,
                                       Set<Person> setSynchronized, Map<Integer, Person> mapSynchronized, List<Person> listSynchronized){
        int persons = 100000;
        for( int i=0; i<persons; i++ ){
            Person person = new Person(i);
            set.add( person ); setSynchronized.add( person );
            map.put( i, person ); mapSynchronized.put( i, person );
            list.add( person ); listSynchronized.add( person );
        }
    }


}
