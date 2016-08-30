/**
 * <h1>LinkedList의 두 가지 구현</h1>
 * <h2>공통 구현 팁</h2>
 * <ul>
 *     <li>두 방법 모두 내부적으로 getNode() 메소드를 구현함으로써 중복적인 노드 검색 로직을 줄인다</li>
 *     <li>성능을 위해 size 필드를 사용하고 깔끔한 구현을 위해 sentinel(head, tail) 객체 필드를 사용한다.</li>
 *     <li>ListNode는 외부에 노출하지 않는 클래스이므로 구지 setter, getter를 이용해서 접근하지 않는다.</li>
 * </ul>
 * <h2>구현 비교</h2>
 * <ul>
 *     <li>SinglyLinkedList : add와 remove 구현 시 index-1 위치의 노드에 접근해야 해서 까다롭다.</li>
 *     <li>DoublyLinkedList : add와 remove 구현 시 노듸의 next, prev를 모두 업데이트 해줘야 한다.</li>
 * </ul>
 * @author Dale Seo
 */
package seo.dale.datastructure.list;