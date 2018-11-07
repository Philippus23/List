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

	private ListNode head;
	private ListNode tail;
	private ListNode current;
	private ListNode previous;

	/**
	 * Eine leere Schlange wird erzeugt.
	 * Objekte, die in dieser Schlange verwaltet werden, muessen vom Typ
	 * ContentType sein.
	 */
	public List() {
		head = null;
		tail = null;
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
		return current == null;
	}

	/**
	 * Das erste Objekt wird aus der Schlange entfernt.
	 * Falls die Schlange leer ist, wird sie nicht veraendert.
	 */
	public void next() {
		if (!this.isEmpty() || this.hasAccess()) {
			current = current.getNext();
			previous = current;
		}
	}
	public void toFirst(){
		if(!this.isEmpty()){
			current= current.head();
		}
	}
	public void toLast(){
		if(!this.isEmpty()){
			current = current.tail();
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
			ListNode newNode = new ListNode(pContent);
			if (this.isEmpty()) {
				head = newNode;
				tail = newNode;
			} else {
				tail.setNext(newNode);
				tail = newNode;
			}
		}
	}

	/**
	 * Das erste Objekt wird aus der Schlange entfernt.
	 * Falls die Schlange leer ist, wird sie nicht veraendert.
	 */
	public void remove() {
		if (!this.isEmpty() || ) {
			head = head.getNext();
			if (this.isEmpty()) {
				head = null;
				tail = null;
			}
		}
	}

	/**
	 * Die Anfrage liefert das erste Objekt der Schlange.
	 * Die Schlange bleibt unveraendert.
	 * Falls die Schlange leer ist, wird null zurueckgegeben.
	 *
	 * @return das erste Objekt der Schlange vom Typ ContentType oder null,
	 *         falls die Schlange leer ist
	 */
	public ContentType front() {
		if (this.isEmpty()) {
			return null;
		} else {
			return head.getContent();
		}
	}
}
