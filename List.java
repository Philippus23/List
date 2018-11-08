/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Generische Klasse List<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse List (Warteschlange) verwalten beliebige
 * Objekte vom Typ ContentType nach dem First-In-First-Out-Prinzip, d.h., das
 * zuerst abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden haben
 * eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten Objekte.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Generisch_02 2014-02-21
 */
public class List<ContentType> {

	/* --------- Anfang der privaten inneren Klasse -------------- */

	private class ListNode {

		private ContentType content = null;
		private ListNode nextNode = null;

		/**
		 * Ein neues Objekt vom Typ ListNode<ContentType> wird erschaffen.
		 * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
		 *
		 * @param pContent das Inhaltselement des Knotens vom Typ ContentType
		 */
		public ListNode(ContentType pContent) {
			content = pContent;
			nextNode = null;
		}

		/**
		 * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
		 * gesetzt.
		 *
		 * @param pNext der Nachfolger des Knotens
		 */
		public void setNext(ListNode pNext) {
			nextNode = pNext;
		}

		/**
		 * Liefert das naechste Element des aktuellen Knotens.
		 *
		 * @return das Objekt vom Typ ListNode, auf das der aktuelle Verweis zeigt
		 */
		public ListNode getNext() {
			return nextNode;
		}

		/**
		 * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
		 *
		 * @return das Inhaltsobjekt des Knotens
		 */
		public ContentType getContent() {
			return content;
		}

	}

	/* ----------- Ende der privaten inneren Klasse -------------- */

	public ListNode head;
	public ListNode tail;
	public ListNode current;


	/**
	 * Eine leere Schlange wird erzeugt.
	 * Objekte, die in dieser Schlange verwaltet werden, muessen vom Typ
	 * ContentType sein.
	 */
	public List() {
		head = null;
		tail = null;
		current = null;
	}

	/**
	 * Die Anfrage liefert den Wert true, wenn die Schlange keine Objekte enthaelt,
	 * sonst liefert sie den Wert false.
	 *
	 * @return true, falls die Schlange leer ist, sonst false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Die Anfrage liefert den Wert true, wenn die Schlange keine Objekte enthaelt,
	 * sonst liefert sie den Wert false.
	 *
	 * @return true, falls die Schlange leer ist, sonst false
	 */
	public boolean hasAccess() {
		return current != null;
	}

	/**
	 * Das erste Objekt wird aus der Schlange entfernt.
	 * Falls die Schlange leer ist, wird sie nicht veraendert.
	 */
	public void next() {
		if (this.hasAccess()) {
			current = current.getNext();
		}
	}

	public void toFirst(){
		if(!this.isEmpty()){
			current = head;
		}
	}

	public void toLast(){
		if(!this.isEmpty()){
			current = tail;
		}
	}


	public ContentType getContent() {
		return (this.hasAccess()) ? current.getContent() : null;
	}

	public void setContent(ContentType pContent) {
		if (pContent != null && this.hasAccess()) {
			current.setContent(pContent);
		}
	}

	public void insert(ContentType pContent) {
     	if (pContent != null) {
			ListNode neu = new ListNode(pContent);
      	if (this.hasAccess()) {
         	if (current == head) {
					neu.setNext(head);
           		head = neu;
         	} else {
					ListNode previous = this.getPrevious(current);
           		neu.setNext(previous.getNext());
           		previous.setNext(neu);
         	}

       	} else if (this.isEmpty()) {
           	head = neu;
				tail = neu;
       	}
     	}
   }
	/**
	 * Das Objekt pContentType wird an die Schlange angehaengt.
	 * Falls pContentType gleich null ist, bleibt die Schlange unveraendert.
	 *
	 * @param pContent
	 *            das anzuhaengende Objekt vom Typ ContentType
	 */
	public void append(ContentType pContent) {
		if (pContent != null) {
			ListNode neu = new ListNode(pContent);
			if (!this.isEmpty()) {
				tail.setNext(neu);
				tail = neu;
			} else {
				head = neu;
				tail = neu;
			}
		}
	}

	public void concat(List<ContentType> pList) {
   	if (pList != null && pList != this && !pList.isEmpty()) {
      if (!this.isEmpty()) {
			tail.setNext(pList.head);
      	tail = pList.tail;
      } else {
			head = pList.head;
         tail = pList.tail;
      }

      pList.current = null;
		pList.head = null;
		pList.tail = null;
     	}
	}

	/**
	 * Das erste Objekt wird aus der Schlange entfernt.
	 * Falls die Schlange leer ist, wird sie nicht veraendert.
	 */
	public void remove() {
		if (this.hasAccess() && !this.isEmpty()) {
			if (current != head) {
				ListNode previous = this.getPrevious(current);
         	if (current == last) {
         		tail = previous;
         	}
         	previous.setNext(current.getNext());
        	} else {
				head = head.getNext();
			}

      	ListNode nxt = current.getNext();
      	current.setContent(null);
      	current.setNext(null);
      	current = nxt;

      	if (this.isEmpty()) {
         	tail = null;
      	}
      }
	}

	private ListNode getPrevious(ListNode pNode) {
		ListNode ret = null;
		if (pNode != first && pNode != null && !this.isEmpty()) {
       	ListNode tmp = first;
       	while (tmp != null && tmp.getNextNode() != pNode) {
         	tmp = tmp.getNextNode();
       	}
       	ret = tmp;
     	}

		return ret;
   }


}
