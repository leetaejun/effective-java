package com.taejun.e5;

import java.util.*;

/**
 * Created by leeta on 2017-01-16.
 * 참고한 링크
 * https://www.youtube.com/watch?v=DIufvQ2QGAY
 * https://www.youtube.com/watch?v=OYB07VM3nNI
 * https://www.youtube.com/watch?v=ipT2XG1SHtQ&t=67s
 */
public class Main {
    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>();
        int[] aa = {1,2,3,4,5};
        int[] bb = {2,3};
        a.add(aa);
        a.add(bb);
        System.out.println(a.get(0)[0]);

        if (a.get(0) instanceof int[]) {

        }

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("aaa"); s1.add("bbb");
        s2.add("ccc"); s2.add("ddd");
        Set<String> s3 = union(s1, s2);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }

    private static void unsafeAdd3(Collection<String> collection, String s) {
        /*
        if (collection instanceof List) {
            collection.add(s);
        }

        if (collection instanceof List<String>) {
            collection.add(s);
        }
        */
    }

    // [[[들어가기]]]
    // # Generics 가 뭔가요?
    // 컴파일러를 잘 쓰기 위한 도구?
    // type parameter based polymorphism?
    // Generics 을 안쓰면 에러가 나더라? 경고가 나더라?

    // # p149. Generics 덕에 프로그램이 더 안전해 지는 이유는 무엇인가?
    // 그 덕에 프로그램은 더 안전하고 명료해지지만, 대가가 있다. 프로그램이 복잡해지는 것이다.

    // Generics 나오기 전과 후는 어떻게 달라졌는지?
        /*
        List aList = new ArrayList();
        List<String> bList = new ArrayList<>();
        List<Object> cList = new ArrayList<>();

        aList.add("a");
        aList.add(1);
        bList.add("a");
        cList.add("a");
        cList.add(1);

         unsafeAdd(bList, new Integer(1));
         unsafeAdd2(bList, new Integer(2));
         */

    // Generics 없이는 자바는 형안정성이 없는 언어일까?
    // static type 언어 => 컴파일 타임에 타입이 틀리면 예외를 던져준다.
    // strong type 언어 => 런타임 시점에도 타입이 틀리면 예외를 던져준다.
    // 근데 Generics 전에는 지원하지 않고 Object를 넣고 Casting을 했다.
    // (자바 초기에 구현 당시 어려움이 있고 사용상 힘들다고 판단하여 뺐음)


    // 규칙23
    // Don`t use raw types in new code
    // 새 코드에는 무인자 제네릭 자료형을 사용하지 말라


    // 규칙24
    // (Eliminate unchecked warning)
    // 무점검 경고를 제거하라
    // 사실 뭐 얘기할 가치가 없다. 하다가 에러(경고)나면 고치면 된다.


    // 규칙25
    // prefer lists to arrays
    // 배열 대신 리스트를 써라
    // 배열이 좋은(쓰는?) 이유?
    // 초기화 리터럴을 제공해준다. (리스트를 사용하면 번거로움?)
    // int[] a = {1,2,3,4,5};
    // List<Integer> iList = Arrays.asList(1,2,3,4,5);

    // 공변 자료형(covariant)? 불변 자료형(invariant)?
    // 배열은 공변 자료형, 리스트는 불변 자료형
    // Object[] objects = new String[10];
    // List<Object> objectList = new ArrayList<String>();
    // String의 List는 Object의 List와 상속관계가 아니기 때문에 안된다.

    //

    // 규칙26
    // Favor generic types
    // 가능하면 제네릭 자료형으로 만들 것

    // 규칙27
    // Favor generic methods
    // 가능하면 제네릭 메소드로 만들 것
    // Class generic vs Method generic
    // 타입 추론 가능
    // 형 안정성? => 컴파일이 되면 믿을 수 있게 돌아간다
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // 규칙28
    // Use bounded wildcards to increase API flexibility
    // 한정적 와일드카드를 써서 API 유연성을 높여라
    // => 이유?
    // 불공변 자료형이 문제가 되는 경우(위의 union처럼)가 있다-> 좀 더 유연성있게 만들기 위한게 한정적 와일드카드
    // wildcards라고 해서 다 넣는게 아니라 null 빼곤 다 안됨(p.155)

    // 규칙29
    // Consider typesafe heterogeneous containers
    // 형 안전 다형성 컨테이너를 쓰면 어떨지 따져보라



















}
